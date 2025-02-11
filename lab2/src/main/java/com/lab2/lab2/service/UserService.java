package com.lab2.lab2.service;


import com.lab2.lab2.entity.User;

public interface UserService {
    public User findByUsername(String username);
    public void addUser(User userEntity);
}