package com.lab2.lab2.service;


import com.lab2.lab2.config.SecUser;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity=userService.findByUsername(username);
        if(userEntity==null)
            throw new UsernameNotFoundException("Username/password is invalid");
        //now problem: userEntity--->UserDetails(which spring sec understand)
        return new SecUser(userEntity);
    }
}