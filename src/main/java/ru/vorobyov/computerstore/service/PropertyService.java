package ru.vorobyov.computerstore.service;

import ru.vorobyov.computerstore.entity.Property;

import java.util.Optional;

/**
 * The interface Property service for interacting with the database.
 */
public interface PropertyService {
    Optional<Property> getById(Long id);
}
