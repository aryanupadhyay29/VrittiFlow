package com.example.journalApp.service;

import com.example.journalApp.Entity.JournalEntry;
import com.example.journalApp.repo.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry){
     journalEntryRepo.save(journalEntry);
    }
    public List<JournalEntry> getAllEntries(){
        return journalEntryRepo.findAll();
    }
    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);

    }
    public JournalEntry updateEntry(ObjectId myId, JournalEntry entry){
        JournalEntry old = journalEntryRepo.findById(myId).orElse(null);
        if(old != null){
            old.setTitle(entry.getTitle());
            old.setContent(entry.getContent());
            old.setDate(entry.getDate());
            entry = old;
        }
        return journalEntryRepo.save(entry);
    }
}
