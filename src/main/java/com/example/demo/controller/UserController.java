/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruggery
 */
@RestController
@RequestMapping("/users") //the URL for this class will always be users.
public class UserController {

    private final UserRepository userRepository;

    //constructor to receive a userRepository as parameter
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll(); //this is a method from interface that writes a SELECT * from users.
    }
    
    //method to test if user will be saved and print on the webpage
    @GetMapping("/add")
    public String addUser(@RequestParam String name,@RequestParam String email, 
            @RequestParam Integer age){
        User temp = new User();
        temp.setName(name);
        temp.setEmail(email);
        temp.setAge(age);
        userRepository.save(temp);
        return "User saved successfully!";
    }
}
