package com.hema.collaborationbackend.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	

}
