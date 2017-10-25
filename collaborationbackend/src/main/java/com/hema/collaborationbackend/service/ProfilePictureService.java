package com.hema.collaborationbackend.service;

import com.hema.collaborationbackend.model.ProfilePicture;

public interface ProfilePictureService {

	void uploadProfilePicture(ProfilePicture profilePicture);
	
	ProfilePicture getProfilePicture(String username);
}
