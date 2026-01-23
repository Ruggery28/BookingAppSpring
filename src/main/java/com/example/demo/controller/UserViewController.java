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

    //Show the list of users
    @GetMapping("/users-list")
    public String userList(Model model) {
        //get the list from the user
        List<User> allUsers = userService.getAllUsers();
        //add it to the model (name it users)
        model.addAttribute("users", allUsers);
        return "user-list";
    }

    //Show the for for a new user
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // You MUST add an empty User object so the form has a 'target'
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping("/success-page")
    public String showSuccess() {
        return "success";
    }

    //Show the form for EDITING an existing user
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        User existingUser = userService.getUserById(id); //fetch from database
        //add the user object to the model so the HTML can see it
        model.addAttribute("user", existingUser); //put in the cart
        return "user-form";
    }

}
