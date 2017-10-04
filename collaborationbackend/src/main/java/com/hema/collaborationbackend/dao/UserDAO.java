package com.hema.collaborationbackend.dao;

import com.hema.collaborationbackend.model.User;

public interface UserDAO {

	boolean registerUser(User user);

	boolean isUsernameValid(String username);

	boolean isEmailValid(String email);
	
	
	

}