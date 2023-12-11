package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.model.UserModel;
import com.security.service.UserServiceImpl;

@RestController
public class RegistrationController 
{
 @Autowired
 private UserServiceImpl userService;	

 @PostMapping("/register")
 public User registerUser(@RequestBody UserModel userModel)
 {
  User user=userService.registerUser(userModel);
  
  return user;
 }
 
 @GetMapping("/alluser")
 public List<User> getUsers()
 {
  return userService.getUsers();
 }
}
