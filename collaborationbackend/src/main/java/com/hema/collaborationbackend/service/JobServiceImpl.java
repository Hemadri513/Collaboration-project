package com.hema.collaborationbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.collaborationbackend.dao.JobDAO;
import com.hema.collaborationbackend.model.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Override
	public void addJob(Job job) {
		jobDAO.addJob(job);

	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return null;
	}

}
