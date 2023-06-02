package ru.vorobyov.computerstore.service;

import ru.vorobyov.computerstore.entity.PropertyValue;

import java.util.Optional;

/**
 * The interface Property value service for interacting with the database.
 */
public interface PropertyValueService {
    Optional<PropertyValue> getById(Long id);
}
