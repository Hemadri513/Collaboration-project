package com.hema.collaborationbackend.service;

import java.util.List;

import com.hema.collaborationbackend.model.User;

public interface FriendService {

	List<User> listOfSuggestedUsers(String username);
	
}
