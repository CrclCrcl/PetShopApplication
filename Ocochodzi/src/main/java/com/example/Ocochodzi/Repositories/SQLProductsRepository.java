package com.example.Ocochodzi.Repositories;

import com.example.Ocochodzi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;


@Validated
@Repository
public interface SQLProductsRepository extends ProductsRepository, JpaRepository<Products,Integer> {



}