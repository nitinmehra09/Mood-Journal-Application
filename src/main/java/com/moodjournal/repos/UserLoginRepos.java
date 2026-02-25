package com.moodjournal.repos;

import com.moodjournal.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLoginRepos extends MongoRepository<User, ObjectId> {
    User findAllByUsername(String username);
}
