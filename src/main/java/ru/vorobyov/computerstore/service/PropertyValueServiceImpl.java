package ru.vorobyov.computerstore.service;

import org.springframework.stereotype.Service;
import ru.vorobyov.computerstore.entity.PropertyValue;
import ru.vorobyov.computerstore.repository.PropertyValueRepository;

import java.util.Optional;

@Service("propertyValueService")
public class PropertyValueServiceImpl implements PropertyValueService{
    private final PropertyValueRepository repository;

    public PropertyValueServiceImpl(PropertyValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PropertyValue> getById(Long id) {
        return repository.findById(id);
    }
}
