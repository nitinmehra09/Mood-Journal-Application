package com.moodjournal.repos;

import com.moodjournal.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserLoginMongoTempReposTest {

    @Autowired
    private UserLoginMongoTempRepos userLoginMongoTempRepos;

    @Test
    public void Test(){
        assertNotNull(userLoginMongoTempRepos.getUserForSA());
    }

}