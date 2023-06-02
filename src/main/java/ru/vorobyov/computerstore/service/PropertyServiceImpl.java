package ru.vorobyov.computerstore.service;

import org.springframework.stereotype.Service;
import ru.vorobyov.computerstore.entity.Property;
import ru.vorobyov.computerstore.repository.PropertyRepository;

import java.util.Optional;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService{
    private final PropertyRepository repository;

    public PropertyServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Property> getById(Long id) {
        return repository.findById(id);
    }
}
