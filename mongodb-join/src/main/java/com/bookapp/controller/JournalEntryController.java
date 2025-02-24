package com.bookapp.controller;

import com.bookapp.entities.UserJournalEntryDTO;
import com.bookapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bookapp.entities.JournalEntry;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;



    @PostMapping
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok(journalEntryService.createJournalEntry(journalEntry));
    }


    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id) {
        return ResponseEntity.ok(journalEntryService.getJournalEntryById(id));
    }


    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.ok(journalEntryService.getAllJournalEntries());
    }


    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable String id, @RequestBody JournalEntry journalEntry) {
        return ResponseEntity.ok(journalEntryService.updateJournalEntry(id, journalEntry));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable String id) {
        journalEntryService.deleteJournalEntry(id);
        return ResponseEntity.noContent().build();
    }
}
