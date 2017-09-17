package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.ForumComment;

public interface ForumCommentDAO {

	public boolean createForumComment(ForumComment forumComment);
	public boolean approveForumComment(ForumComment forumComment);
	
	public boolean deleteForumComment(int ID);
	
	public boolean editForumComment(int ID);
	
	public ForumComment getForumComment(int ID);
	
	public List<ForumComment> getForumComments();
	
}
