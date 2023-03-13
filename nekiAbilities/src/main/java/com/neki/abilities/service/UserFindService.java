package com.neki.abilities.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.abilities.dto.UserDTOs.UserFindResponseDTO;
import com.neki.abilities.model.User;
import com.neki.abilities.repository.UserRepository;

@Service
public class UserFindService {
    @Autowired
    private UserRepository userRepository;

    public UserFindResponseDTO findById(Long id) {

        Optional<User> users = userRepository.findById(id);

        return new UserFindResponseDTO(users.get());
    }
}
