package com.yazilimsokagi.YazilimSokagiBackend.repository;

import com.yazilimsokagi.YazilimSokagiBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {

        User findByUsername(String name);
}
