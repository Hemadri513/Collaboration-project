package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.BlogPost;

public interface BlogPostDAO {
	
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(int approved);
	BlogPost getBlogById(int id);

}
