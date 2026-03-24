package com.moodjournal.repos;

import com.moodjournal.entities.ConfigJournalAppEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfigJournalAppRepos extends MongoRepository<ConfigJournalAppEntity, ObjectId> {
}
