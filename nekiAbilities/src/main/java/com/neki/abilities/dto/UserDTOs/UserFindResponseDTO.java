package com.neki.abilities.dto.UserDTOs;

import java.util.ArrayList;
import java.util.List;

import com.neki.abilities.dto.UserAbilityDTOs.UserAbilityFindUserDTO;
import com.neki.abilities.model.User;
import com.neki.abilities.model.UserAbility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFindResponseDTO {

    private Long id;
    private String username;
    private List<UserAbilityFindUserDTO> userAbility;

    public UserFindResponseDTO(User u) {
        this.id = u.getId();
        this.username = u.getUsername();

        List<UserAbilityFindUserDTO> userAbilityDTO = new ArrayList<>();
        for (UserAbility ability : u.getUserAbility()) {
            userAbilityDTO.add(new UserAbilityFindUserDTO(ability));
        }
        this.userAbility = userAbilityDTO;
    }
}