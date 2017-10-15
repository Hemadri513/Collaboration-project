package com.hema.collaborate.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hema.collaborationbackend.model.Error;
import com.hema.collaborationbackend.model.Job;
import com.hema.collaborationbackend.model.User;
import com.hema.collaborationbackend.service.JobService;
import com.hema.collaborationbackend.service.UserService;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null) {
			Error error = new Error(5,"Unauthrized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		User user=userService.getUserByUsername(username);
		if(!user.getRole().equals("ADMIN")) {
			Error error = new Error(6,"Access Denied");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			
		}
		try {
			job.setPostedOn(new Date());
		jobService.addJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		catch(Exception e) {
			Error error = new Error (7,"Unable to insert job details");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
			
		}
	}
	
	public ResponseEntity<?> getAllJobs(HttpSession session){
		
		
		String username=(String)session.getAttribute("username");
		if(username==null) {
			Error error = new Error(5,"Unauthrized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		List<Job> jobs=jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
}
