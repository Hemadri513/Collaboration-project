package com.hema.collaborationbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.collaborationbackend.dao.ProfilePictureDAO;
import com.hema.collaborationbackend.model.ProfilePicture;

@Service
public class ProfilePictureServiceImpl implements ProfilePictureService {

	@Autowired
	private ProfilePictureDAO profilePictureDAO;
	
	@Override
	public void uploadProfilePicture(ProfilePicture profilePicture) {
		profilePictureDAO.uploadProfilePic(profilePicture);
	}

}
