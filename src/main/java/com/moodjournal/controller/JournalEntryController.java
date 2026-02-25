package com.moodjournal.controller;

import com.moodjournal.entities.JournalEntry;
import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import com.moodjournal.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Home")
public class JournalEntryController{

    @Autowired
    private journalEntryService journalEntryService;

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/{username}")
    public ResponseEntity<List<JournalEntry>> getAllEntry(@PathVariable String username){
        User user = userLoginService.getUserByUserName(username);
        List<JournalEntry> journalEntry = user.getJournalEntries();
        if(!journalEntry.isEmpty()){
            return new ResponseEntity<List<JournalEntry>>(journalEntry,HttpStatus.FOUND);
        }
        return new ResponseEntity<List<JournalEntry>>(journalEntry,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{myId}")
    public ResponseEntity<JournalEntry> getEntryByID(@PathVariable ObjectId myId){
        JournalEntry journalEntry = journalEntryService.findEntryById(myId);
        if(journalEntry!=null){
            return new ResponseEntity<JournalEntry>(journalEntry,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry journalEntry,@PathVariable String username){
        try {
            journalEntryService.saveEntry(journalEntry,username);
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<JournalEntry>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{username}/{myId}")
    public boolean delete(@PathVariable ObjectId myId,@PathVariable String username){
        journalEntryService.deleteEntry(myId,username);
        return true;
    }

    @PutMapping("/{myId}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
        JournalEntry oldEntry = journalEntryService.findEntryById(myId);
        if(oldEntry!=null){
            //title ^
            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle():oldEntry.getTitle());
            oldEntry.setMood(newEntry.getMood()!=null && !newEntry.getMood().equals("")?newEntry.getMood(): oldEntry.getMood());
            journalEntryService.saveEntry(oldEntry);
            return new ResponseEntity<JournalEntry>(oldEntry, HttpStatus.OK);
        }
        return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
    }
}
