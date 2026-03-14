package com.moodjournal.controller;

import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping()
    public List<User> getAllUser(){
        return userLoginService.getAll();
    }

    @PostMapping()
    public void createAdmin(@RequestBody User user){
        userLoginService.saveNewAdmin(user);
    }
}
