package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.BlogComment;

@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean createBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean approveBlogComment(BlogComment blogComment) {
		try {
		
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised:" +e);
			return false;
		}

	}

	@Transactional
	@Override
	public boolean deleteBlogComment(int ID) {
		try {
			Session session=sessionFactory.openSession();
			BlogComment blogComment=(BlogComment)session.get(BlogComment.class,ID);
			session.delete(blogComment);
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

	@Override
	public boolean editBlogComment(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlogComment getBlogComment(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<BlogComment> getBlogComments() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment where status = 'A'");
		List<BlogComment> listBlogComment= query.list();
		session.close();
		return listBlogComment;
	}

}
