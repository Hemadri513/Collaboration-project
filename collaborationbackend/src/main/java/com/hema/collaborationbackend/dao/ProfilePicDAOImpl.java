package com.hema.collaborationbackend.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.ProfilePicture;

@Repository
@Transactional
public class ProfilePicDAOImpl implements ProfilePictureDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void uploadProfilePic(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);

	}

}
