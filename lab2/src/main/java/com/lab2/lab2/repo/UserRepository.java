package com.lab2.lab2.repo;


import com.lab2.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String userName);
}

