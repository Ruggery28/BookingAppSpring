/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //I have updated here since we moved the old variable to handle inside userService
    private final UserService userService;

    //constructor to receive a userRepository as parameter
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers(); 
    }
    
    //method to test if user will be saved and print on the webpage
    @GetMapping("/add")
    public String addUser(@RequestParam String name,@RequestParam String email, 
            @RequestParam Integer age){
        User temp = new User();
        temp.setName(name);
        temp.setEmail(email);
        temp.setAge(age);
        userService.registerUser(temp); //updated it here to registerUser
        return "redirect:/success-page"; //this will tell the brownser to go to that page
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/user-list";
    }
    
}
