package com.neki.abilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.abilities.model.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Boolean existsByNameIgnoreCase(String name);
}
