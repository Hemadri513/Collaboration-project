package com.hema.collaborationbackend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hema.collaborationbackend.dao.BlogCommentDAO;
import com.hema.collaborationbackend.model.BlogComment;

public class BlogCommentDAOTestCase {

static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		blogCommentDAO = (BlogCommentDAO)annotationConfigAppContext.getBean("blogCommentDAO");
	}
	

	@Test
	public void createBlogTest()
	{
		BlogComment blogComment = new BlogComment();
		
		blogComment.setID(3001);
		blogComment.setBlogID(1001);
		blogComment.setComment1("Blog comment string");
		blogComment.setUserID(10);
		blogComment.setUsername("hema");
		blogComment.setCreateDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog comment creation",blogCommentDAO.createBlogComment(blogComment));
		
		
	}

	@Ignore
	@Test
	public void approveBlogTest() {
		
		BlogComment blogComment = new BlogComment();
		
		blogComment.setID(3001);
		blogComment.setBlogID(1001);
		blogComment.setComment1("Blog comment string");
		blogComment.setUserID(10);
		blogComment.setUsername("hema");
		blogComment.setCreateDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog creation",blogCommentDAO.approveBlogComment(blogComment));
		
	}
	
	@Ignore
	@Test
	public void getAllApprovedBlogTest() 
	{
		
		List<BlogComment> listBlogComment=blogCommentDAO.getBlogComments();
		assertTrue("No Approved Blog Comments", listBlogComment.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteBlogTest() {
		assertTrue("problem in deleting blog comment", blogCommentDAO.deleteBlogComment(1001));
		
	}
	
}
