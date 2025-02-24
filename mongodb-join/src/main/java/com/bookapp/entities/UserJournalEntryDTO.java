package com.bookapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJournalEntryDTO {
    private String id;
    private String userName;
    private String email;
    private List<JournalEntry> journalEntries;
}
