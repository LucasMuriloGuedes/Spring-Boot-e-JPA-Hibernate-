package com.lucasmurilo.treinospring.services;

import com.lucasmurilo.treinospring.entities.User;
import com.lucasmurilo.treinospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
