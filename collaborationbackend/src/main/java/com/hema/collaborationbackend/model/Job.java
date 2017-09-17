package com.hema.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Job {
	
	@Id
	private int JobID;
	
	private String JobProfile;
	
	private String JobDesc;
	
	private String Qualification;
	
	private String Status;
	
	private Date PostDate;

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public String getJobProfile() {
		return JobProfile;
	}

	public void setJobProfile(String jobProfile) {
		JobProfile = jobProfile;
	}

	public String getJobDesc() {
		return JobDesc;
	}

	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getPostDate() {
		return PostDate;
	}

	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}
	
	
	

}
