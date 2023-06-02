package ru.vorobyov.computerstore.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vorobyov.computerstore.dto.ModifyProductRequest;
import ru.vorobyov.computerstore.dto.ProductDto;
import ru.vorobyov.computerstore.dto.PropertyDto;
import ru.vorobyov.computerstore.entity.*;
import ru.vorobyov.computerstore.service.*;

import java.util.*;

/**
 * Controller for interacting with products
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController extends BaseController{
    private final TypeService typeService;
    private final ProductService productService;
    private final PropertyService propertyService;
    private final PropertySetService propertySetService;
    private final PropertyValueService propertyValueService;

    /**
     * Instantiates a new Products controller.
     *
     * @param typeService          the type service
     * @param productService       the product service
     * @param propertyService      the property service
     * @param propertySetService   the property set service
     * @param propertyValueService the property value service
     */
    public ProductsController(TypeService typeService,
                              ProductService productService,
                              PropertyService propertyService,
                              PropertySetService propertySetService,
                              PropertyValueService propertyValueService) {
        this.typeService = typeService;
        this.productService = productService;
        this.propertyService = propertyService;
        this.propertySetService = propertySetService;
        this.propertyValueService = propertyValueService;
    }

    /**
     * Adds a new product
     *
     * @param request DTO with new product data
     * @return response entity of CREATED(201) if product was added successfully and with an error status otherwise
     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid ModifyProductRequest request){
        var type = typeService.getById(request.getTypeId());

        if (type.isEmpty())
            return getBadRequestResponse("This type of product does not exist!");

        var productOptional = createProduct(request, type.get());
        boolean isProductCreated = productOptional.isPresent();

        if (!isProductCreated)
            return getServiceUnavailableResponse("Failed to create a product! Please try again later!");

        if (request.getProperties().isEmpty())
            return getCreatedResponse();

        boolean isPropertySetsCreated =
                createPropertySets(request.getProperties(), productOptional.get());

        return isPropertySetsCreated
                ? getCreatedResponse()
                : getServiceUnavailableResponse("Failed to create product properties! Please try again later!");
    }

    private Optional<Product> createProduct(ModifyProductRequest request, Type type){
        var product = new Product(
                request.getSerialNumber(),
                request.getManufacturer(),
                request.getPrice(),
                request.getQuantity(),
                type
        );
        return productService.save(product);
    }

    private boolean createPropertySets(List<PropertyDto> propertyDtoList, Product product) {
        var sets = new ArrayList<PropertySet>();
        var propertyMap =
                parseDtoToProperties(propertyDtoList, product.getType());
        propertyMap.forEach(
                (property, propertyValues) -> propertyValues.forEach(
                        propertyValue -> sets.add(new PropertySet(product, property, propertyValue))
                )
        );
        return !propertySetService.addAll(sets).isEmpty();
    }

    private Map<Property, List<PropertyValue>> parseDtoToProperties(List<PropertyDto> propertyDtoList, Type type) {
        Map<Property, List<PropertyValue>> propertyValueMap = new HashMap<>();

        propertyDtoList.forEach(x -> {
            var property = propertyService.getById(x.getNameId());
            var value = propertyValueService.getById(x.getValueId());

            if (isPropertyAndValueValid(property, value, type)) {
                Property prop = property.get();
                PropertyValue val = value.get();

                propertyValueMap.computeIfAbsent(prop, k -> new ArrayList<>()).add(val);
            }
        });
        return propertyValueMap;
    }

    private boolean isPropertyAndValueValid(Optional<Property> property,
                                            Optional<PropertyValue> value,
                                            Type type){
        if (property.isEmpty() || value.isEmpty())
            return false;

        Property prop = property.get();
        PropertyValue val = value.get();

        if (!val.getProperty().getId().equals(prop.getId()))
            return false;

        return prop.getType().getId().equals(type.getId());
    }

    /**
     * Updates the data of an existing product
     *
     * @param productId the product id
     * @param request   DTO with data for updating existing product
     * @return response entity of NO_CONTENT(204) if product was updated successfully and with an error status otherwise
     */
    @Validated
    @PutMapping("{productId}")
    public ResponseEntity<?> update(@PathVariable @Min(0) long productId,
                                    @RequestBody @Valid ModifyProductRequest request){
        var product = productService.getByIdFetchPropertySet(productId);
        if (product.isEmpty())
            return getNotFoundResponse("Product not found!");

        var type = typeService.getById(request.getTypeId());
        if (type.isEmpty())
            return getBadRequestResponse("This type of product does not exist!");

        var propertySets = product.get().getPropertySet();
        propertySetService.deleteAll(propertySets);

        boolean isProductUpdated = updateProduct(product.get(), type.get(), request);

        if (!isProductUpdated)
            return getServiceUnavailableResponse("Failed to update a product! Please try again later!");

        if (request.getProperties().isEmpty())
            return ResponseEntity.noContent().build();

        boolean isPropertySetsCreated =
                createPropertySets(request.getProperties(), product.get());

        return isPropertySetsCreated
                ? ResponseEntity.noContent().build()
                : getServiceUnavailableResponse("Failed to create new product properties! Please try again later!");
    }

    private boolean updateProduct(Product product, Type type,
                                  ModifyProductRequest request){
        product.setSerialNumber(request.getSerialNumber());
        product.setManufacturer(request.getManufacturer());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setType(type);
        product.setPropertySet(null);

        return productService.save(product).isPresent();
    }

    /**
     * Gets all products.
     *
     * @param type product type
     * @return response entity of OK(200) and all products
     * if type is null or blank and by type otherwise
     */
    @Validated
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam("type") String type){
        var productType = typeService.getByName(type);
        if (productType.isEmpty())
            return getNotFoundResponse("Product type not found!");

        var products = type == null || type.isBlank()
                ? productService.getAllFetchAll()
                : productService.getAllByTypeNameFetchAll(type);

        if (products.isEmpty())
            return ResponseEntity.noContent().build();

        var productsDto = parseProductListToDto(products);

        return ResponseEntity.ok(productsDto);
    }

    private List<ProductDto> parseProductListToDto(List<Product> products){
        return  products.stream()
                .map(this::parseProductToDto)
                .toList();
    }

    /**
     * Gets product data by its id.
     *
     * @param productId the product id
     * @return response entity of OK(200) and product data
     * if product was found successfully and with an error status otherwise
     */
    @Validated
    @GetMapping("{productId}")
    public ResponseEntity<?> get(@PathVariable @Min(0) long productId){
        var productOptional = productService.getByIdFetchAll(productId);
        if (productOptional.isEmpty())
            return getNotFoundResponse("Product not found!");

        var product = productOptional.get();
        var productDto = parseProductToDto(product);

        return ResponseEntity.ok(productDto);
    }

    private ProductDto parseProductToDto(Product product){
        var propertySets =
                parsePropertySetListToDto(product.getPropertySet());

        return new ProductDto(
                product.getId(),
                product.getSerialNumber(),
                product.getManufacturer(),
                product.getPrice(),
                product.getQuantity(),
                product.getType().getId(),
                propertySets
        );
    }

    private List<PropertyDto> parsePropertySetListToDto(List<PropertySet> sets){
        return sets.stream()
                .map(this::parsePropertySetToDto)
                .toList();
    }

    private PropertyDto parsePropertySetToDto(PropertySet set){
        return new PropertyDto(
                set.getProperty().getId(),
                set.getValue().getId()
        );
    }
}
