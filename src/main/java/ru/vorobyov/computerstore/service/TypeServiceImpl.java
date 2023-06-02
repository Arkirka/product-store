package ru.vorobyov.computerstore.service;

import org.springframework.stereotype.Service;
import ru.vorobyov.computerstore.entity.Type;
import ru.vorobyov.computerstore.repository.TypeRepository;

import java.util.Optional;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
    private final TypeRepository repository;

    public TypeServiceImpl(TypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Type> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Type> getByName(String name) {
        return repository.findByName(name);
    }

}
