package com.example.game_market.controller;

import com.example.game_market.entity.User;
import com.example.game_market.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}