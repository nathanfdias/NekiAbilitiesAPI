package com.neki.abilities.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.abilities.dto.UserAbilityDTOs.UserAbilityDTO;
import com.neki.abilities.dto.UserAbilityDTOs.UserAbilityRequestDTO;
import com.neki.abilities.exception.AbilityException;
import com.neki.abilities.exception.UserException;
import com.neki.abilities.model.Ability;
import com.neki.abilities.model.User;
import com.neki.abilities.model.UserAbility;
import com.neki.abilities.repository.AbilityRepository;
import com.neki.abilities.repository.UserAbilityRepository;
import com.neki.abilities.repository.UserRepository;

import jakarta.transaction.Transactional;

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

    @Transactional
    public UserAbility insertUserAbility(UserAbilityRequestDTO userAbility) {

        if (userAbility.getAbility() == null || userAbility.getUser() == null) {
            throw new IllegalArgumentException("Invalid fields");
        }

        User user = userRepository.findById(userAbility.getUser().getId())
                .orElseThrow(() -> new UserException("User not found: id = " + userAbility.getUser().getId()));

        Ability ability = abilityRepository.findById(userAbility.getAbility().getId())
                .orElseThrow(() -> new AbilityException("Ability not found: id = " + userAbility.getAbility().getId()));

        if (user.getUserAbility().stream().anyMatch(us -> us.getAbility().getId() == ability.getId())) {
            throw new AbilityException("Impossible to insert the same ability");
        }

        UserAbility u = new UserAbility();

        u.setKnowledgeLevel(userAbility.getKnowledgeLevel());
        u.setUser(user);
        u.setAbility(ability);
        u.setCreatedAt(new Date());
        u.setUpdatedAt(new Date());

        return userAbilityRepository.save(u);
    }

    @Transactional
    public UserAbilityDTO updateUserAbility(Long id, UserAbility userAbility) {

        userAbility.setId(id);
        UserAbility newUser = new UserAbility();
        Optional<UserAbility> userAbilityS = userAbilityRepository.findById(id);

        newUser.setId(userAbility.getId());
        newUser.setKnowledgeLevel(userAbility.getKnowledgeLevel());
        newUser.setAbility(userAbility.getAbility());
        newUser.setUser(userAbility.getUser());
        newUser.setCreatedAt(userAbilityS.get().getCreatedAt());
        newUser.setUpdatedAt(new Date());

        userAbilityRepository.save(newUser);

        return new UserAbilityDTO(userAbility);
    }

    @Transactional
    public Boolean delete(Long id) {
        try {
            UserAbility userAbility = userAbilityRepository.findById(id)
                    .orElseThrow(() -> new AbilityException("Could not find userAbility id = " + id));

            userAbilityRepository.deleteById(userAbility.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
