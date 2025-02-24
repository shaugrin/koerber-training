package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public User createUser(User user) {
        List<JournalEntry> validEntries = new ArrayList<>();

        for (JournalEntry entry : user.getJournalEntries()) {
            journalEntryRepo.findById(entry.getId()).ifPresent(validEntries::add);
        }

        user.setJournalEntries(validEntries);
        return userRepo.save(user);
    }


    public User getUserById(String id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(String id, User updatedUser) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return userRepo.save(updatedUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
