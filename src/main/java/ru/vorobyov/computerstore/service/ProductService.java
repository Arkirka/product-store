package ru.vorobyov.computerstore.service;

import ru.vorobyov.computerstore.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * The interface Product service for interacting with the database.
 */
public interface ProductService {
    Optional<Product> save(Product product);
    List<Product> getAllByTypeNameFetchAll(String typeName);
    List<Product> getAllFetchAll();
    Optional<Product> getByIdFetchAll(Long id);
    Optional<Product> getByIdFetchPropertySet(Long id);
}
