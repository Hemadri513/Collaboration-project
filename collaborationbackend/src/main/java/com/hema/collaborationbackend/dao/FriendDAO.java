package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.Friend;
import com.hema.collaborationbackend.model.User;

public interface FriendDAO {
	
	List<User> listOfSuggestedUsers(String username);

	void friendRequest(Friend friend);

	List<Friend> pendingRequests(String toId);
}
