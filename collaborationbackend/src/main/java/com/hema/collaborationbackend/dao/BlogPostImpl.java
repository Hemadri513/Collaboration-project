package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.BlogPost;

@Repository
@Transactional
public class BlogPostImpl implements BlogPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);
	}

	@Override
	public List<BlogPost> getBlogs(int approved) {
		Session session=sessionFactory.getCurrentSession();
		
		//if approved = 0 , select * from blogpost where approved =0; blogs waiting for approval
		// if approved =1, select * from blogpost where approved = 1; blogs waiting for approved
		Query query=session.createQuery("from BlogPost where approved="+approved);
		return query.list();
	}


	@Override
	public BlogPost getBlogById(int id) {
		Session session = sessionFactory.getCurrentSession();
		 BlogPost blogPost =(BlogPost)session.get(BlogPost.class,id);  //select * from blogpost where id=?
		return blogPost;
	}

}
