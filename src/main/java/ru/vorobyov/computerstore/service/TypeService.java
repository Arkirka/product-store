package ru.vorobyov.computerstore.service;

import ru.vorobyov.computerstore.entity.Type;

import java.util.Optional;

/**
 * The interface Type service for interacting with the database.
 */
public interface TypeService {
    Optional<Type> getById(Long id);
    Optional<Type> getByName(String name);
}
