package com.neki.abilities.dto.UserAbilityDTOs;

import com.neki.abilities.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserIdDTO {

    private Long id;

    public UserIdDTO(User user) {
        this.id = user.getId();
    }
}
