package com.irctc.booking.service;

import com.irctc.booking.entity.User;
import com.irctc.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        if (userRepository.existsByEmail(user.getEmail()))
        {
            throw new RuntimeException("Email Already Exist. ");
        }

        return userRepository.save(user);

    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }



}
