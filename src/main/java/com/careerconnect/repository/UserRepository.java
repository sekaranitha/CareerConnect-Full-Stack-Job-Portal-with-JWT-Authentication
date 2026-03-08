package com.careerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.careerconnect.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
