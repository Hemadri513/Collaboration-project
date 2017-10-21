package com.hema.collaborationbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.collaborationbackend.dao.BlogPostDAO;
import com.hema.collaborationbackend.model.BlogComment;
import com.hema.collaborationbackend.model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	@Autowired
	private BlogPostDAO blogPostDAO;
	
	@Override
	public void addBlogPost(BlogPost blogPost) {
		blogPostDAO.addBlogPost(blogPost);
	}

	@Override
	public List<BlogPost> getBlogs(int approved) {
		
		return blogPostDAO.getBlogs(approved);
	}

	@Override
	public BlogPost getBlogById(int id) {
		
		return blogPostDAO.getBlogById(id);
	}

	@Override
	public void updateBlogPost(BlogPost blogPost) {
		blogPostDAO.addBlogPost(blogPost);
		
	}

	@Override
	public void addBlogComment(BlogComment blogComment) {
		blogPostDAO.addBlogComment(blogComment);
	}

	@Override
	public List<BlogComment> getBlogComments(int blogPostId) {
		return blogPostDAO.getBlogComments(blogPostId);
	}

}
