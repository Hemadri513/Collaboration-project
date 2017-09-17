package com.hema.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hema.collaborationbackend.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean createJob(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean approveJob(Job job) {
		try {
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised:" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteJob(int jobid) {
		try {
			Session session=sessionFactory.openSession();
			Job job=(Job)session.get(Job.class,jobid);
			session.delete(job);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised" +e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean editJob(int jobid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public Job getJob(int jobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Job> getJobs() {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Job where status = 'A'");
		List<Job> listJob= query.list();
		session.close();
		return listJob;
	}

}
