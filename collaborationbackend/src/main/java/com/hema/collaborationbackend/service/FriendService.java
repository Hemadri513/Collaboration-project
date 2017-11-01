package com.hema.collaborationbackend.service;

import java.util.List;

import com.hema.collaborationbackend.model.Friend;
import com.hema.collaborationbackend.model.User;

public interface FriendService {

	List<User> listOfSuggestedUsers(String username);

	void friendRequest(Friend friend);
	
	List<Friend> pendingRequests(String toId);

	void updateFriendRequest(Friend friend);
	
}
