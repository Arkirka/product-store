package ru.vorobyov.computerstore.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vorobyov.computerstore.constant.ProductType;
import ru.vorobyov.computerstore.dto.AddProductRequest;
import ru.vorobyov.computerstore.dto.UpdateProductRequest;

/**
 * Controller for interacting with products
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    /**
     * Adds a new product
     *
     * @param request DTO with new product data
     * @return response entity of CREATED(201) if product was added successfully
     * and with an error status otherwise
     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid AddProductRequest request){
        return ResponseEntity.ok().build();
    }

    /**
     * Updates the data of an existing product
     *
     * @param request DTO with data for updating existing product
     * @return response entity of NO_CONTENT(204) if product was updated successfully
     * and with an error status otherwise
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProductRequest request){
        return ResponseEntity.ok().build();
    }

    /**
     * Gets all products by their type.
     *
     * @param type the type
     * @return the all
     */
    @Validated
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam("type") @NotNull ProductType type){
        return ResponseEntity.ok().build();
    }

    /**
     * Gets product data by its id.
     *
     * @param productId the product id
     * @return response entity of OK(204) and product data if product was found successfully
     * and with an error status otherwise
     */
    @Validated
    @GetMapping("{productId}")
    public ResponseEntity<?> get(@PathVariable @Min(0) long productId){
        return ResponseEntity.ok().build();
    }
}
