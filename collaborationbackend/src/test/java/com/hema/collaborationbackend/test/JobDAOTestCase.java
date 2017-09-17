package com.hema.collaborationbackend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hema.collaborationbackend.dao.JobDAO;
import com.hema.collaborationbackend.model.Job;

public class JobDAOTestCase {

static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		jobDAO = (JobDAO)annotationConfigAppContext.getBean("jobDAO");
	}
	

	@Test
	public void createJobTest()
	{
		Job job = new Job();
		
		job.setJobID(5001);
		job.setJobDesc("job desc");
		job.setJobProfile("job profile");
		job.setPostDate(new java.util.Date());
		job.setQualification("B.E");
		job.setStatus("NA");
		
		
		assertTrue("Problem in Job creation",jobDAO.createJob(job));
		
		
	}

	@Ignore
	@Test
	public void approveJobTest() {
		
		Job job = new Job();
		
		job.setJobID(5001);
		job.setJobDesc("job desc");
		job.setJobProfile("job profile");
		job.setPostDate(new java.util.Date());
		job.setQualification("B.E");
		job.setStatus("NA");
		
		assertTrue("Problem in Approve job creation",jobDAO.approveJob(job));
		
	}
	
	@Ignore
	@Test
	public void getAllApprovedJobTest() 
	{
		
		List<Job> listJob=jobDAO.getJobs();
		assertTrue("No Approved Blogs", listJob.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteJobTest() {
		assertTrue("problem in deleting", jobDAO.deleteJob(2001));
		
	}
	
	
}
