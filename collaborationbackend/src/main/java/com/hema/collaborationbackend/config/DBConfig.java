package com.hema.collaborationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hema.collaborationbackend.dao.BlogDAO;
import com.hema.collaborationbackend.dao.BlogDAOImpl;
import com.hema.collaborationbackend.model.Blog;
import com.hema.collaborationbackend.model.BlogComment;
import com.hema.collaborationbackend.model.Forum;

@Configuration
@ComponentScan("com.hema.collaborationbackend.model")
@EnableTransactionManagement
public class DBConfig {

	
	public DataSource getOracleDataSource() {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("hemadri");
		driverManagerDataSource.setPassword("hemadri");
		
		return driverManagerDataSource;
	}
	
	public Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2dd1.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		System.out.println("sessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
		
	}
	
	@Bean
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		return new BlogDAOImpl(sessionFactory);
	}
	
}
