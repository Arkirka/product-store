package ru.vorobyov.computerstore.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import javax.annotation.processing.Generated;

/**
 * DTO that represents properties data.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nameId",
        "valueId"
})
@Generated("jsonschema2pojo")
public class PropertyDto {

    /**
     * Instantiates a new Property dto.
     */
    public PropertyDto() {
    }

    /**
     * Instantiates a new Property dto.
     *
     * @param nameId  the name id
     * @param valueId the value id
     */
    public PropertyDto(Long nameId, Long valueId) {
        this.nameId = nameId;
        this.valueId = valueId;
    }

    @Min(0)
    @JsonProperty("nameId")
    private Long nameId;
    @Min(0)
    @JsonProperty("valueId")
    private Long valueId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Gets name id.
     *
     * @return the name id
     */
    @JsonProperty("nameId")
    public Long getNameId() {
        return nameId;
    }

    /**
     * Sets name id.
     *
     * @param nameId the name id
     */
    @JsonProperty("nameId")
    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    /**
     * Gets value id.
     *
     * @return the value id
     */
    @JsonProperty("valueId")
    public Long getValueId() {
        return valueId;
    }

    /**
     * Sets value id.
     *
     * @param valueId the value id
     */
    @JsonProperty("valueId")
    public void setValueId(Long valueId) {
        this.valueId = valueId;
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
