package com.example.petbe.services;


import com.example.petbe.models.User;

public interface UserService {
    User loginUser(String gmail, String password);
}
