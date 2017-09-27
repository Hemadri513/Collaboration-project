package com.hema.collaborationbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.collaborationbackend.dao.UserDAO;
import com.hema.collaborationbackend.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.registerUser(user);
	}
	
	
	
}
