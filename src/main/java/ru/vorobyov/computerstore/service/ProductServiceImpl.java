package ru.vorobyov.computerstore.service;

import org.springframework.stereotype.Service;
import ru.vorobyov.computerstore.entity.Product;
import ru.vorobyov.computerstore.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> save(Product product) {
        return Optional.of(repository.save(product));
    }

    @Override
    public List<Product> getAllByTypeNameFetchAll(String typeName) {
        return repository.findAllByTypeNameFetchAll(typeName);
    }

    @Override
    public List<Product> getAllFetchAll() {
        return repository.findAllFetchAll();
    }

    @Override
    public Optional<Product> getByIdFetchAll(Long id) {
        return repository.findByIdFetchAll(id);
    }

    @Override
    public Optional<Product> getByIdFetchPropertySet(Long id) {
        return repository.findByIdFetchPropertySet(id);
    }
}
