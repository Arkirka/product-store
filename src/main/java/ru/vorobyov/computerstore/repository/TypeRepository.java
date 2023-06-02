package ru.vorobyov.computerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobyov.computerstore.entity.Type;

import java.util.Optional;

/**
 * The interface Type repository.
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    /**
     * Find by name.
     *
     * @param name type name
     * @return the optional
     */
    Optional<Type> findByName(String name);
}
