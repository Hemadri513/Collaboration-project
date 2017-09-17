package com.hema.collaborationbackend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hema.collaborationbackend.dao.ForumDAO;
import com.hema.collaborationbackend.model.Blog;
import com.hema.collaborationbackend.model.Forum;

public class ForumDAOTestCase {

	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		forumDAO = (ForumDAO)annotationConfigAppContext.getBean("forumDAO");
	}
	
	@Ignore
	@Test
	public void createForumTest()
	{
		Forum forum = new Forum();
		
		forum.setForumId(2001);
		forum.setForumName("test");
		forum.setForumContent("forum description");
		forum.setUserId(1001);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		
		
		assertTrue("Problem in Forum creation",forumDAO.createforum(forum));
		
		
	}
	@Ignore
	@Test
	public void approveForumTest() {
		
		Forum forum = new Forum();

		forum.setForumId(2001);
		forum.setForumName("test");
		forum.setForumContent("forum description");
		forum.setUserId(1001);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		assertTrue("Problem in Forum approve creation",forumDAO.approveforum(forum));
		
	}
	
	
	
	@Test
	public void getAllApprovedForumTest() 
	{
		
		List<Forum> listForum=forumDAO.getforums();
		assertTrue("No Approved forums", listForum.size()>0);
	}

	
	
}
