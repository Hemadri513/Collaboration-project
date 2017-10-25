package com.hema.collaborationbackend.dao;

import com.hema.collaborationbackend.model.ProfilePicture;

public interface ProfilePictureDAO {
	
	void uploadProfilePic(ProfilePicture profilePicture);
	
	ProfilePicture getProfilePic(String username);
}
