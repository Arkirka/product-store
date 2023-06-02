package ru.vorobyov.computerstore.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vorobyov.computerstore.entity.PropertySet;
import ru.vorobyov.computerstore.repository.PropertySetRepository;

import java.util.List;

@Service("propertySetService")
public class PropertySetServiceImpl implements PropertySetService{
    private final PropertySetRepository repository;

    public PropertySetServiceImpl(PropertySetRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PropertySet> addAll(List<PropertySet> properties) {
        return repository.saveAll(properties);
    }

    @Override
    @Transactional
    public void deleteAll(List<PropertySet> properties) {
        repository.deleteAll(properties);
    }
}
