package com.lucasmurilo.treinospring.repositories;

import com.lucasmurilo.treinospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
