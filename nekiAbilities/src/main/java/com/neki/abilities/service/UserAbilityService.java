package com.neki.abilities.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.abilities.dto.UserAbilityDTOs.UserAbilityDTO;
import com.neki.abilities.model.UserAbility;
import com.neki.abilities.repository.AbilityRepository;
import com.neki.abilities.repository.UserAbilityRepository;
import com.neki.abilities.repository.UserRepository;

@Service
public class UserAbilityService {
    @Autowired
    private UserAbilityRepository userAbilityRepository;

    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private UserRepository userRepository;

    public List<UserAbilityDTO> findAll() {
        List<UserAbility> user = userAbilityRepository.findAll();
        List<UserAbilityDTO> response = new ArrayList<>();

        for (UserAbility users : user) {
            response.add(new UserAbilityDTO(users));
        }
        return response;
    }
}
