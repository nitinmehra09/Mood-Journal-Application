package com.moodjournal.controller;

import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;


    @GetMapping
    public List<User> showAllInfo(){
        return userLoginService.getAll();
    }


    @PostMapping()
    public void CreateUser(@RequestBody User user){
        userLoginService.saveUser(user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username){
        User user = userLoginService.getUserByUserName(username);
        userLoginService.deleteUser(user);
    }


    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username){
        User userInDb = userLoginService.getUserByUserName(username);
        if(userInDb!=null){
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userLoginService.saveUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
