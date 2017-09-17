package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.Forum;



public interface ForumDAO {

	public boolean createforum(Forum forum);
	public boolean approveforum(Forum forum);
	public boolean deleteforum(int forumId);
	public boolean editforum(int forumId);
	
	public Forum getforum(int forumId);
	
	public List<Forum> getforums();
	
}
