package com.example.springbootslf4jwithlogback.controller;

import com.example.springbootslf4jwithlogback.dto.UserDTO;
import com.example.springbootslf4jwithlogback.model.User;
import com.example.springbootslf4jwithlogback.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

   @PostMapping("/save")
    public User saveUser(@RequestBody UserDTO userDTO) {
       User saveUser=userService.saveUser(userDTO);
       log.info("User is Saved!!!! ID:"+saveUser.getId()+" FirstName:"+saveUser.getFirstName()+" LastName:"+saveUser.getLastName());
        return saveUser;
    }

   @PutMapping( "/update/{id}")
    public User updateUser(@PathVariable("id") String id,@RequestBody UserDTO userDTO) {

       User saveUser=userService.updateUser(id,userDTO);
       log.info("User ID:"+saveUser.getId() + " Updated!!!! New FirstName:"+saveUser.getFirstName()+"  New LastName:"+saveUser.getLastName());
        return saveUser;
    }

   @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
       User user=userService.getUser(id);
       log.info("User ID:"+user.getId() + " Deleted!!!");
       userService.deleteUser(id);
    }

   @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") String id) {
       User user=userService.getUser(id);
       log.info("User ID:"+user.getId() + " Selected!!!! FirstName:"+user.getFirstName()+" LastName:"+user.getLastName());
        return userService.getUser(id);
    }

  @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
