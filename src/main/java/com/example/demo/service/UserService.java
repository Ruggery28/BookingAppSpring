/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruggery
 */
@Service
public class UserService {

    //object to communicate with UserRepository
    private final UserRepository userRepository;

    //A constructor to talk to UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all users inside the Repository
    public List<User> getAllUsers(){
        return userRepository.findAll(); //this is a method from interface that writes a SELECT * from users.
    }
    
    public void registerUser(User user) {
        //this will check first if user is over 18, before saving him into database
        if (user.getAge() < 18) {
            // This stops the process and sends a message back
            throw new RuntimeException("User must be at least 18 years old to register.");
        } else {
            userRepository.save(user);
        }
    }

    public void deleteUserById(Integer id){
        //method to delete a user by its Id
        userRepository.deleteById(id);
    }
    
    public User getUserById(Integer id){
        //this will return user by Id or null if he doesnt exist
        return userRepository.findById(id).orElse(null);
    }
    
    public List<User> searchUsers(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return userRepository.findByNameContainingIgnoreCase(keyword);
        }
        return userRepository.findAll(); // Return everything if search is empty
    }
    
}
