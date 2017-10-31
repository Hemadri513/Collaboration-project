package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.Friend;
import com.hema.collaborationbackend.model.User;
@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> listOfSuggestedUsers(String username) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select * from userdetails where username in"
				+ "(select username from userdetails where username!=? minus "
				+ "(select fromId from friend where toId=? "
				+ "union select toId from friend where fromId=?)"
				+ ")");
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(User.class); //to convert records to User Objects
		List<User> suggestedUsers=query.list();
		return suggestedUsers; //List<User>
	}

	@Override
	public void friendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		
	}

	@Override
	public List<Friend> pendingRequests(String toId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0, toId);
		return query.list();

	}
	
	
}
