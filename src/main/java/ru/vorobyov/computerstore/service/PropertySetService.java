package ru.vorobyov.computerstore.service;

import ru.vorobyov.computerstore.entity.PropertySet;

import java.util.List;

/**
 * The interface Property set service for interacting with the database.
 */
public interface PropertySetService {
    List<PropertySet> addAll(List<PropertySet> properties);
    void deleteAll(List<PropertySet> properties);
}
