package com.example.Quiz_Project.repository;

import com.example.Quiz_Project.entities.User;
import com.example.Quiz_Project.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByRole(UserRole role);

    User findFirstByEmail(String email);
}
