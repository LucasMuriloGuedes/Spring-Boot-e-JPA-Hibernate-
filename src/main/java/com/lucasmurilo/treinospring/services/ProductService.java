package com.lucasmurilo.treinospring.services;

import com.lucasmurilo.treinospring.entities.Product;
import com.lucasmurilo.treinospring.repositories.ProductRepository;
import com.lucasmurilo.treinospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não localizado! Id :" + id + ", da classe: " + Product.class.getName()));
    }

    public Product insert(Product obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public Product update(Integer id, Product obj) {
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
