package com.neki.abilities.dto.UserAbilityDTOs;

import java.util.Date;

import com.neki.abilities.dto.AbilityDTOs.AbilityResponseDTO;
import com.neki.abilities.dto.UserDTOs.UserDTO;
import com.neki.abilities.model.UserAbility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAbilityDTO {

    private Long id;
    private UserDTO user;
    private AbilityResponseDTO ability;
    private Integer knowledgeLevel;
    private Date createdAt;
    private Date updatedAt;

    public UserAbilityDTO(UserAbility userAbility){
        this.id = userAbility.getId();
        this.user = new UserDTO(userAbility.getUser());
        this.ability = new AbilityResponseDTO(userAbility.getAbility());
        this.knowledgeLevel = userAbility.getKnowledgeLevel();
    }
}
