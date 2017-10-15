package com.hema.collaborationbackend.service;

import java.util.List;

import com.hema.collaborationbackend.model.BlogPost;

public interface BlogPostService {

	void addBlogPost(BlogPost blogPost);
	
	List<BlogPost> getBlogs(int approved);
	
	BlogPost getBlogById(int id);
}
