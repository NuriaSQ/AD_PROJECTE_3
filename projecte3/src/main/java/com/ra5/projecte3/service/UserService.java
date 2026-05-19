package com.ra5.projecte3.service;

import org.springframework.stereotype.Service;
import com.ra5.projecte3.dto.UserResponseDTO;
import com.ra5.projecte3.mapper.UserMapper;
import com.ra5.projecte3.model.Role;
import com.ra5.projecte3.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Constructor per injecció de dependències
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Retorna tots els usuaris
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // Cerca un usuari per ID
    public UserResponseDTO findById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }

    // Filtra usuaris per rol
    public List<UserResponseDTO> findByRole(Role role) {
        return userRepository.findByRole(role)
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // Cerca usuari per username
    public UserResponseDTO findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDto)
                .orElse(null);
    }
}