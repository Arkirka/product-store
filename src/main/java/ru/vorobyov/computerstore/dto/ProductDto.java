package ru.vorobyov.computerstore.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * DTO that represents product data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "serial_number",
        "manufacturer",
        "price",
        "quantity",
        "typeId",
        "properties"
})
@Generated("jsonschema2pojo")
public class ProductDto {
    /**
     * Instantiates a new Product dto.
     */
    public ProductDto() {
    }

    /**
     * Instantiates a new Product dto.
     *
     * @param id           the id
     * @param serialNumber the serial number
     * @param manufacturer the manufacturer
     * @param price        the price
     * @param quantity     the quantity
     * @param typeId       the type id
     * @param properties   the properties
     */
    public ProductDto(Long id,
                      String serialNumber,
                      String manufacturer,
                      Double price,
                      Integer quantity,
                      Long typeId,
                      List<PropertyDto> properties) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.typeId = typeId;
        this.properties = properties;
    }

    @NotNull
    @Min(0)
    @JsonProperty("id")
    private Long id;
    @NotBlank
    @NotNull
    @JsonProperty("serial_number")
    private String serialNumber;
    @NotBlank
    @NotNull
    @JsonProperty("manufacturer")
    private String manufacturer;
    @Min(0)
    @JsonProperty("price")
    private Double price;
    @JsonProperty("quantity")
    private Integer quantity;
    @Min(0)
    @JsonProperty("typeId")
    private Long typeId;
    @JsonProperty("properties")
    @Valid
    private List<PropertyDto> properties;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Gets id.
     *
     * @return the id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets serial number.
     *
     * @return the serial number
     */
    @JsonProperty("serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets serial number.
     *
     * @param serialNumber the serial number
     */
    @JsonProperty("serial_number")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets manufacturer.
     *
     * @return the manufacturer
     */
    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets manufacturer.
     *
     * @param manufacturer the manufacturer
     */
    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    @JsonProperty("typeId")
    public Long getTypeId() {
        return typeId;
    }

    /**
     * Sets type id.
     *
     * @param typeId the type id
     */
    @JsonProperty("typeId")
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    @JsonProperty("properties")
    public List<PropertyDto> getProperties() {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    @JsonProperty("properties")
    public void setProperties(List<PropertyDto> properties) {
        this.properties = properties;
    }

    /**
     * Gets additional properties.
     *
     * @return the additional properties
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Sets additional property.
     *
     * @param name  the name
     * @param value the value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}