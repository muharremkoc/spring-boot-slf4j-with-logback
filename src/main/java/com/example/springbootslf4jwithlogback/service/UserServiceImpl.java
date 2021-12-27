package com.example.springbootslf4jwithlogback.service;

import com.example.springbootslf4jwithlogback.dto.UserDTO;
import com.example.springbootslf4jwithlogback.mapper.UserMapper;
import com.example.springbootslf4jwithlogback.model.User;
import com.example.springbootslf4jwithlogback.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user=userMapper.userDTOToUser(userDTO);



        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, UserDTO userDTO) {
        User user=userRepository.findById(id).orElseThrow();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
         userRepository.deleteById(id);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
