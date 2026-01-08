/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruggery
 */
@Controller //this will make the return be a file and not just a simple String
@RequestMapping("/users") //the URL for this class will always be users.
public class UserController {

    //I have updated here since we moved the old variable to handle inside userService
    private final UserService userService;

    //constructor to receive a userRepository as parameter
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody //this will try to get a raw data as we want.
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //method that update and insert inside the database
    @GetMapping("/add")
    public String addUser(@RequestParam(required = false) Integer id, @RequestParam String name,
            @RequestParam String email, @RequestParam Integer age) {
        User temp = new User();
        
        if (id != null) {
            temp.setId(id); //only set the id if it is not null
        }

        temp.setName(name);
        temp.setEmail(email);
        temp.setAge(age);
        userService.registerUser(temp); //updated it here to registerUser
        return "redirect:/success-page"; //this will tell the brownser to go to that page
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users-list";
    }

}
