package com.moodjournal.service;

import com.moodjournal.entities.User;
import com.moodjournal.repos.UserLoginRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserLoginService {
    @Autowired
    private UserLoginRepos userLoginRepos;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll(){
        return userLoginRepos.findAll();
    }

    public User getUserByUserName(String username){
        return userLoginRepos.findAllByUsername(username);
    }

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userLoginRepos.save(user);
    }

//    public void saveNewUser(User user){
//        userLoginRepos.save(user);
//    }




    public void deleteUser(User user){
        userLoginRepos.deleteById(user.getId());
    }

}
