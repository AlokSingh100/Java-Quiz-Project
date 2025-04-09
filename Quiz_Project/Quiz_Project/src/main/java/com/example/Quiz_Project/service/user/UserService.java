package com.example.Quiz_Project.service.user;

import com.example.Quiz_Project.entities.User;

public interface UserService {
    User createUser(User user);

    Boolean hasUserWithEmail(String email);
}
