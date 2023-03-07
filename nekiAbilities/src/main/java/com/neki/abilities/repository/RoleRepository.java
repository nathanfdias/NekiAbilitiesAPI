package com.neki.abilities.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.abilities.Enums.ERole;
import com.neki.abilities.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
