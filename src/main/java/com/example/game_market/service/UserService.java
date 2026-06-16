package com.example.game_market.service;

import com.example.game_market.entity.User;
import com.example.game_market.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}