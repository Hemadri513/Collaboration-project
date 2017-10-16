package com.hema.collaborationbackend.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table
public class BlogComment {

	private int id;
	private String commentText;
	private User commentedBy;
	private Date commentedOn;
	private BlogPost blogPost;
	
	
	
	
}
