package com.lucasmurilo.treinospring.services;

import com.lucasmurilo.treinospring.entities.User;
import com.lucasmurilo.treinospring.repositories.UserRepository;
import com.lucasmurilo.treinospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não localizado! Id :" + id + ", da classe: " + User.class.getName()));
    }

    public User insert(User obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public User update(Integer id, User obj) {
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
