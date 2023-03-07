package com.neki.abilities.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.neki.abilities.model.RefreshToken;
import com.neki.abilities.model.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    RefreshToken findByUserAndExpiryDateAfter(User user, Instant instante);

    @Modifying
    int deleteByUser(User user);
}
