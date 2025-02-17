package com.lab2.lab2.service;

import com.lab2.lab2.entity.User;
import com.lab2.lab2.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;
    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUser(User userEntity) {
        userRepo.save(userEntity);
    }
}