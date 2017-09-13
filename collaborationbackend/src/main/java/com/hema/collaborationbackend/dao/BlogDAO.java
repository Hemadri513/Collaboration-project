package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.Blog;

public interface BlogDAO {

	public boolean createBlog();
	public boolean approveBlog();
	public boolean deleteBlog();
	public boolean editBlog();
	
	public Blog getBlog();
	
	public List<Blog> getBlogs();
	
}
