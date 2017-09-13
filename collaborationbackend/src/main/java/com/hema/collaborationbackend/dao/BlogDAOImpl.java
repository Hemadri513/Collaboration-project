package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createBlog(Blog blog)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised" +e);
			return false;
		}
	}

	@Transactional
	public boolean approveBlog(Blog blog)
	{
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised:" +e);
			return false;
		}

	}

	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editBlog(int blogId) {
		
		
		
		return false;
	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getBlogs() {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog where status = 'A'");
		List<Blog> listBlog=query.list();
		session.close();
		return listBlog;

	}

}
