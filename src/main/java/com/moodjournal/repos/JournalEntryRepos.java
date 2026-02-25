package com.moodjournal.repos;

import com.moodjournal.entities.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepos extends MongoRepository<JournalEntry,ObjectId> {
}
