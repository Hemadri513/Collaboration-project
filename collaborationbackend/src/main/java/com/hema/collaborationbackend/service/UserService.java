package com.hema.collaborationbackend.service;

import com.hema.collaborationbackend.model.User;

public interface UserService {

	boolean registerUser(User user);
	boolean isUsernameValid(String username);
	boolean isEmailValid(String email);
	User login(User user);
	void update(User user);
	User getUserByUsername(String username);
	 boolean isUpdatedEmailValid(String email,String username);
}
