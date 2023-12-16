package com.example.Ocochodzi.Repositories;

import com.example.Ocochodzi.model.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {
    List<Products> findAll();
    Optional<Products> findById(Integer id);

    Products save(Products entity);
    boolean existsById(Integer id);
    Object findAll(Pageable page);

    default List<Products> findByAccessibility() {
        return findByAccessibility(false);
    }
    List<Products> findByAccessibility(@Param("state") boolean done);

}
