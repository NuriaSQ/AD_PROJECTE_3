package com.projecte3.repository;

import com.projecte3.model.User;
import com.projecte3.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByRole(Role role);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}