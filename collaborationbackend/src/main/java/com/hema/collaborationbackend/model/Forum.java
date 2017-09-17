package com.hema.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Forum {
	
	@Id
	private int ForumId;
	
	private String ForumName;
	
	private String ForumContent;
	
	private int UserId;
	
	private Date createDate;
	
	private String Status;

	public int getForumId() {
		return ForumId;
	}

	public void setForumId(int forumId) {
		ForumId = forumId;
	}

	public String getForumName() {
		return ForumName;
	}

	public void setForumName(String forumName) {
		ForumName = forumName;
	}

	public String getForumContent() {
		return ForumContent;
	}

	public void setForumContent(String forumContent) {
		ForumContent = forumContent;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

}
