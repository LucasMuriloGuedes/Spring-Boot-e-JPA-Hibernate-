package com.lucasmurilo.treinospring.services;

import com.lucasmurilo.treinospring.entities.Category;
import com.lucasmurilo.treinospring.repositories.CategoryRepository;
import com.lucasmurilo.treinospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não localizado! Id :" + id + ", da classe: " + Category.class.getName()));
    }

    public Category insert(Category obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public Category update(Integer id, Category obj) {
        findById(id);
        obj.setId(id);
        obj = repository.save(obj);
        return obj;
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
