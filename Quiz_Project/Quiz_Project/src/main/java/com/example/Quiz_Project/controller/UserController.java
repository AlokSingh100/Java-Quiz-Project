package com.example.Quiz_Project.controller;
import com.example.Quiz_Project.entities.User;
import com.example.Quiz_Project.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user){

        if (userService.hasUserWithEmail(user.getEmail())){
            return  new ResponseEntity<>("User Already Exists", HttpStatus.NOT_ACCEPTABLE);
        }
        User createdUser = userService.createUser(user);
        if (createdUser == null){
            return new ResponseEntity<>("User Not Created, Try Again Later...",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(createdUser,HttpStatus.OK);
    }
}
