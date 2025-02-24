package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.repo.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public JournalEntry createJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepo.save(journalEntry);
    }

    public JournalEntry getJournalEntryById(String id) {
        return journalEntryRepo.findById(id).orElseThrow(() -> new RuntimeException("Journal Entry not found"));
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepo.findAll();
    }

    public JournalEntry updateJournalEntry(String id, JournalEntry updatedEntry) {
        if (!journalEntryRepo.existsById(id)) {
            throw new RuntimeException("Journal Entry not found");
        }
        updatedEntry.setId(id);
        return journalEntryRepo.save(updatedEntry);
    }

    public void deleteJournalEntry(String id) {
        journalEntryRepo.deleteById(id);
    }
}
