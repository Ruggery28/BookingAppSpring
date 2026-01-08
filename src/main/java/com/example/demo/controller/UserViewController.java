/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Ruggery
 */
@Controller
public class UserViewController {

    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration() {
        return "user-form";
    }

    @GetMapping("/users-list")
    public String userList(Model model) {
        //get the list from the user
        List<User> allUsers = userService.getAllUsers();
        //add it to the model (name it users)
        model.addAttribute("users", allUsers);
        return "user-list";
    }

    @GetMapping("/success-page")
    public String showSuccess() {
        return "success";
    }
    
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        User user = userService.getUserById(id);
        //add the user object to the model so the HTML can see it
        model.addAttribute("user", user);
        return "user-form";
    }
    
    
    
    
}
