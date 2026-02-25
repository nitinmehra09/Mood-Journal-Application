package com.moodjournal.service;

import com.moodjournal.entities.User;
import com.moodjournal.repos.UserLoginRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserLoginService {
    @Autowired
    private UserLoginRepos userLoginRepos;

    public List<User> getAll(){
        return userLoginRepos.findAll();
    }

    public User getUserByUserName(String username){
        return userLoginRepos.findAllByUsername(username);
    }

    public void saveUser(User user){
        userLoginRepos.save(user);
    }

    public void deleteUser(User user){
        userLoginRepos.deleteById(user.getId());
    }

}
