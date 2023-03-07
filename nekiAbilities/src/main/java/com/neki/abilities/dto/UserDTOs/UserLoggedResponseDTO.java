package com.neki.abilities.dto.UserDTOs;

import java.util.HashSet;
import java.util.Set;

import com.neki.abilities.model.Role;
import com.neki.abilities.model.User;

import lombok.Data;

@Data
public class UserLoggedResponseDTO {

    private Long id;
    private String username;
    private String email;
    private Set<Role> roles = new HashSet<>();

    public UserLoggedResponseDTO(User u) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.roles = u.getRoles();
    }
}
