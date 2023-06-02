package ru.vorobyov.computerstore.entity;

import jakarta.persistence.*;

/**
 * The Type entity that represents type entry in the database.
 */
@Entity
@Table(name = "types")
public class Type {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
