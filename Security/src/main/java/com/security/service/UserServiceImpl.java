package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.model.UserModel;
import com.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User registerUser(UserModel userModel) 
	{
	 User user=new User();
	 
	 user.setEmail(userModel.getEmail());
     user.setUserName(userModel.getUserName());
	 user.setRole(userModel.getRole());
	 user.setPassword(passwordEncoder.encode(userModel.getPassword()));
	 userRepository.save(user);
	 
	 return user;
	}


	@Override
	public List<User> getUsers() 
	{
	 return userRepository.findAll();
	}

}
