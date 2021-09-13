package com.lucasmurilo.treinospring.repositories;

import com.lucasmurilo.treinospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
