package com.kanban.demo.service;

import com.kanban.demo.dto.RegisterRequest;
import com.kanban.demo.model.User;
import com.kanban.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(RegisterRequest request) {
        // Verificar se usuário já existe
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username já existe");
        }

        // Criar novo usuário
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : "USER");

        // Salvar e retornar
        return userRepository.save(user);
    }
}