package ru.vorobyov.computerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.computerstore.entity.PropertyValue;

/**
 * The interface Property value repository.
 */
@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, Long> {
}
