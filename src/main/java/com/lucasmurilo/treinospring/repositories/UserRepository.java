package com.lucasmurilo.treinospring.repositories;

import com.lucasmurilo.treinospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
