package com.example.journalApp.Entity;

import com.example.journalApp.Controller.JournalEntryController;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class JournalEntry  {

    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

    }
