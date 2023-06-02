package ru.vorobyov.computerstore.entity;

import jakarta.persistence.*;

/**
 * The PropertySet entity that property set entry in the database
 */
@Entity
@Table(name = "property_sets")
public class PropertySet {

    /**
     * Instantiates a new Property set.
     */
    public PropertySet() {
    }

    /**
     * Instantiates a new Property set.
     *
     * @param product  the product
     * @param property the property
     * @param value    the value
     */
    public PropertySet(Product product, Property property, PropertyValue value) {
        this.product = product;
        this.property = property;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_id", nullable = false)
    private PropertyValue value;

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
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
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

    /**
     * Gets value.
     *
     * @return the value
     */
    public PropertyValue getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(PropertyValue value) {
        this.value = value;
    }
}
