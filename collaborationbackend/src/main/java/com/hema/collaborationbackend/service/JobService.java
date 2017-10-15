package com.hema.collaborationbackend.service;

import java.util.List;

import com.hema.collaborationbackend.model.Job;

public interface JobService {

	void addJob(Job job);
	List<Job> getAllJobs();
}
