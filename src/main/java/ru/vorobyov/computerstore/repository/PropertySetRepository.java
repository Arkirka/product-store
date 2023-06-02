package ru.vorobyov.computerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.computerstore.entity.PropertySet;

/**
 * The interface Property set repository.
 */
@Repository
public interface PropertySetRepository extends JpaRepository<PropertySet, Long> {
}
