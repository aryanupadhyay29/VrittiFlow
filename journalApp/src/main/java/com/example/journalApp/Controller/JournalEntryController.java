package com.example.journalApp.Controller;

import com.example.journalApp.Entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("entries")
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllEntries();
    }

    @PostMapping()
    public  JournalEntry createEntry(@RequestBody JournalEntry entry){
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;

    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntrybyId(@PathVariable ObjectId myId){
        return journalEntryService.getById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public void deleteJournalEntrybyId(@PathVariable ObjectId myId){
         journalEntryService.deleteById(myId);
    }
    @PutMapping("update/{myId}")
    public JournalEntry updateJounal(@PathVariable ObjectId myId ,  @RequestBody JournalEntry entry){
        return journalEntryService.updateEntry(myId , entry);

    }





}
