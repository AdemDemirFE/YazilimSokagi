package com.yazilimsokagi.YazilimSokagiBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yazilimsokagi.YazilimSokagiBackend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
