package com.moodjournal.controller;

import com.moodjournal.entities.User;
import com.moodjournal.repos.UserLoginRepos;
import com.moodjournal.service.UserLoginService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginRepos userLoginRepos;

    @GetMapping
    public List<User> showAllInfo(){
        return userLoginService.getAll();
    }




    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userLoginRepos.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // jisse login hai woh delete ho jayega
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userLoginService.getUserByUserName(username);
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userLoginService.saveUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
