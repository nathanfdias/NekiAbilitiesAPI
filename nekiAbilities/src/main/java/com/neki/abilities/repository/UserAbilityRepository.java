package com.neki.abilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.abilities.model.UserAbility;

public interface UserAbilityRepository extends JpaRepository<UserAbility, Long> {

}
