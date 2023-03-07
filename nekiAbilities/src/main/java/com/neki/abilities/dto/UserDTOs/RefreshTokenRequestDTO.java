package com.neki.abilities.dto.UserDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RefreshTokenRequestDTO {

    @NotBlank
    private String refreshToken;
}
