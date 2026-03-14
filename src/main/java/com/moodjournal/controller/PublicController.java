package com.moodjournal.controller;

import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping()
    public void CreateUser(@RequestBody User user){
        userLoginService.saveNewUser(user);
    }
}
