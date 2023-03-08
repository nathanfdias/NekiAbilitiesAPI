package com.neki.abilities.dto.UserAbilityDTOs;

import com.neki.abilities.model.Ability;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbilityIdDTO {

    private Long id;

    public AbilityIdDTO(Ability ability) {
        this.id = ability.getId();
    }
}
