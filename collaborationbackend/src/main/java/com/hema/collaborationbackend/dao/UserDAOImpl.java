package com.hema.collaborationbackend.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean registerUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean isUsernameValid(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		
		if(user==null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean isEmailValid(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0, email);
		User usertable=(User) query.uniqueResult();
		if(usertable==null)
			return true;
		else
			return false;
	}

}