package com.hema.collaborationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hema.collaborationbackend.model.BlogComment;
import com.hema.collaborationbackend.model.BlogPost;
import com.hema.collaborationbackend.model.Job;
import com.hema.collaborationbackend.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.hema.collaborationbackend.model")
public class DBConfig {

	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getDataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[] {User.class,BlogPost.class,Job.class,BlogComment.class};
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hemadri");
		dataSource.setPassword("hemadri");
		return dataSource;
	}
	
	
	@Bean
	public HibernateTransactionManager hibTransManagement() {
		return new HibernateTransactionManager(sessionFactory());
	}
	
}
