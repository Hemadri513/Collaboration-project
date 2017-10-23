package com.hema.collaborationbackend.dao;

import java.util.List;

import com.hema.collaborationbackend.model.Job;

public interface JobDAO {
	
	void addJob(Job job);
	List<Job> getAllJobs();
	Job getJob(int jobId);

}
