package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.Blog;
import com.hema.collaborationbackend.model.Forum;


@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createforum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised" +e);
			return false;
		}
	}
	
	@Transactional
	public boolean approveforum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised:" +e);
			return false;
		}
	}

	@Transactional
	public boolean deleteforum(int forumId) {
		try {
			Session session=sessionFactory.openSession();
			Forum forum=(Forum)session.get(Forum.class,forumId);
			session.delete(forum);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised" +e);
			return false;
		}
	}

	public boolean editforum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Forum getforum(int forumId) {
		
		return null;
		
	}

	public List<Forum> getforums() {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Forum where status = 'A'");
		List<Forum> listForum = query.list();
		session.close();
		return listForum;
	}

}
