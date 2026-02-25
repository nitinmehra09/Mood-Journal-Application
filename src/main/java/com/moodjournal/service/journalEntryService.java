package com.moodjournal.service;

import com.moodjournal.entities.JournalEntry;
import com.moodjournal.entities.User;
import com.moodjournal.repos.JournalEntryRepos;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class journalEntryService {
    @Autowired
    private JournalEntry journalEntry;

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private JournalEntryRepos journalEntryRepos;

    public List<JournalEntry> findAllEntry(){
        return journalEntryRepos.findAll();
    }

    public JournalEntry findEntryById(ObjectId myID){
        return journalEntryRepos.findById(myID).orElse(null);
    }

    public void saveEntry(JournalEntry journalEntry, String username){
        User user = userLoginService.getUserByUserName(username);
        JournalEntry saved = journalEntryRepos.save(journalEntry);
        user.getJournalEntries().add(saved);
        userLoginService.saveUser(user);
    }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepos.save(journalEntry);
    }

    public JournalEntry updateEntry(ObjectId myId){
        return journalEntryRepos.findById(myId).orElse(null);
    }

    public void deleteEntry(ObjectId myId, String username){
        User user = userLoginService.getUserByUserName(username);
        user.getJournalEntries().removeIf(x->x.getId().equals(myId));
        userLoginService.saveUser(user);
        journalEntryRepos.deleteById(myId);
    }

}
