package com.security.service;

import java.util.List;

import com.security.entity.User;
import com.security.model.UserModel;

public interface UserService {

	public User registerUser(UserModel userModel);

	public List<User> getUsers();

}
