package com.hema.collaborationbackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.collaborationbackend.dao.UserDAO;
import com.hema.collaborationbackend.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	
	public boolean registerUser(User user) {
		
		return userDAO.registerUser(user);
	}

	@Override
	@Transactional
	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return userDAO.isUsernameValid(username);
	}

	@Override
	@Transactional
	public boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		return userDAO.isEmailValid(email);
	}
	
	
	
}
