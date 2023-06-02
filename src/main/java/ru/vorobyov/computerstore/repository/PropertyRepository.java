package ru.vorobyov.computerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.computerstore.entity.Property;

/**
 * The interface Property repository.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
