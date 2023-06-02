package ru.vorobyov.computerstore.entity;

import jakarta.persistence.*;

/**
 * The Property Value entity that represents property value entry in the database.
 */
@Entity
@Table(name = "property_values")
public class PropertyValue {

    /**
     * Instantiates a new Property value.
     */
    public PropertyValue() {
    }

    /**
     * Instantiates a new Property value.
     *
     * @param id the id
     */
    public PropertyValue(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    @Column(name = "prop_value", nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets property.
     *
     * @return the property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets property.
     *
     * @param property the property
     */
    public void setProperty(Property property) {
        this.property = property;
    }
}
