package com.gyapeee.learnuml.repository;

import com.gyapeee.learnuml.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
