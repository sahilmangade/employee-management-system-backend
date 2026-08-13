package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.LoginDTO;
import com.ems.dto.RegisterDTO;
import com.ems.entity.User;
import com.ems.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    // Employee Registration
    @PostMapping("/register")
    public String register(
            @RequestBody RegisterDTO dto) {

        return userService.register(dto);
    }

    // Admin Creation
    @PostMapping("/addadmin")
    public String addAdmin(
            @RequestBody RegisterDTO dto) {

        return userService.addAdmin(dto);
    }

    // Login
    @PostMapping("/login")
    public User login(
            @RequestBody LoginDTO dto) {

        return userService.login(dto);
    }
}