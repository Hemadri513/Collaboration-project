package com.hema.collaborationbackend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hema.collaborationbackend.dao.ForumCommentDAO;
import com.hema.collaborationbackend.model.ForumComment;


public class ForumCommentDAOTestCase {

static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		forumCommentDAO = (ForumCommentDAO)annotationConfigAppContext.getBean("forumCommentDAO");
	}
	

	@Test
	public void createForumTest()
	{
		ForumComment forumComment = new ForumComment();
		
		forumComment.setID(3001);
		forumComment.setForumID(1001);
		forumComment.setComment1("Blog comment string");
		forumComment.setUserID(10);
		forumComment.setUsername("hema");
		forumComment.setCreateDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog comment creation",forumCommentDAO.createForumComment(forumComment));
		
		
	}

	@Ignore
	@Test
	public void approveForumTest() {
		
ForumComment forumComment = new ForumComment();
		
		forumComment.setID(3001);
		forumComment.setForumID(1001);
		forumComment.setComment1("Blog comment string");
		forumComment.setUserID(10);
		forumComment.setUsername("hema");
		forumComment.setCreateDate(new java.util.Date());
	
		
		assertTrue("Problem in forum approve ",forumCommentDAO.approveForumComment(forumComment));
		
	}
	
	@Ignore
	@Test
	public void getAllApprovedForumTest() 
	{
		
		List<ForumComment> listForumComment=forumCommentDAO.getForumComments();
		assertTrue("No Approved forum Comments", listForumComment.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteForumTest() {
		assertTrue("problem in deleting forum comment", forumCommentDAO.deleteForumComment(1001));
		
	}
}
