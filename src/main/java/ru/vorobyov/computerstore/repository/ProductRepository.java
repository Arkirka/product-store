package ru.vorobyov.computerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vorobyov.computerstore.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find all by type typeName and fetch all children.
     *
     * @param typeName type name
     * @return Product list
     */
    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.type pt " +
            "JOIN FETCH p.propertySet ps " +
            "JOIN FETCH ps.property " +
            "JOIN FETCH ps.value " +
            "WHERE pt.name = :name")
    List<Product> findAllByTypeNameFetchAll(@Param("name") String typeName);

    /**
     * Find all fetch all and fetch all children.
     *
     * @return Product list
     */
    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.type pt " +
            "JOIN FETCH p.propertySet ps " +
            "JOIN FETCH ps.property " +
            "JOIN FETCH ps.value ")
    List<Product> findAllFetchAll();

    /**
     * Find by id and fetch all children
     *
     * @param id Product id
     * @return Product optional
     */
    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.type pt " +
            "JOIN FETCH p.propertySet ps " +
            "JOIN FETCH ps.property " +
            "JOIN FETCH ps.value " +
            "WHERE p.id = :id")
    Optional<Product> findByIdFetchAll(@Param("id") Long id);

    /**
     * Find by id and fetch property set
     *
     * @param id Product id
     * @return optional of Product
     */
    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.type pt " +
            "JOIN FETCH p.propertySet ps " +
            "WHERE p.id = :id")
    Optional<Product> findByIdFetchPropertySet(@Param("id") Long id);

}
