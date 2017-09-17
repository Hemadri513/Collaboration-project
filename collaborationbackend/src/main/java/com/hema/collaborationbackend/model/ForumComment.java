package com.hema.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ForumComment {

	
	@Id
	private int ID;
	
	private int ForumID;
	
	private String Comment1;
	
	private int UserID;
	
	private String username;
	
	private Date createDate;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getForumID() {
		return ForumID;
	}

	public void setForumID(int forumID) {
		ForumID = forumID;
	}

	public String getComment1() {
		return Comment1;
	}

	public void setComment1(String comment1) {
		Comment1 = comment1;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
