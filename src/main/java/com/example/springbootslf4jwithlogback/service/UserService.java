package com.example.springbootslf4jwithlogback.service;

import com.example.springbootslf4jwithlogback.dto.UserDTO;
import com.example.springbootslf4jwithlogback.model.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);
    User updateUser(String id,UserDTO userDTO);
    void deleteUser(String id);
    User getUser(String id);
    List<User> getUsers();
}
