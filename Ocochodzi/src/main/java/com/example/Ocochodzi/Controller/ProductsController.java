package com.example.Ocochodzi.Controller;

import com.example.Ocochodzi.model.Products;
import com.example.Ocochodzi.Repositories.ProductsRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;

@RestController
public class ProductsController {
    public static final Logger logger = LoggerFactory.getLogger(ProductsController.class);
    private final ProductsRepository repository;

    public ProductsController(final ProductsRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/productses")
    ResponseEntity<Products> CreateProduct(@RequestBody @Valid Products toCreate){
        Products result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);

    }
    @GetMapping (value = "/productses",params = {"!sort","!size","!page"})
    ResponseEntity<?> readAllProducts() {
        logger.warn("Exposing All Products");
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping (value = "/productses")
    ResponseEntity<?> readAllProducts(Pageable page){
        logger.info("Custom Page");
        return ResponseEntity.ok(repository.findAll((org.springframework.data.domain.Pageable)page));
    }
    @GetMapping (value = "/productses/{id}")
    ResponseEntity<Products> readSpecificProduct(@PathVariable int id) {
            return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping(value = "/products/{id}")
    ResponseEntity<?> updateProducts(@PathVariable int id, @RequestBody Products toUpdate){
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}

