package com.nmfzone.app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nmfzone.app.model.User;

@Configuration
@EnableTransactionManagement
public class App
{

	@Bean
	public HibernateTemplate hibernateTemplate()
    {
		return new HibernateTemplate(sessionFactory());
	}

	@Bean
	public SessionFactory sessionFactory()
    {
		return new LocalSessionFactoryBuilder(getDataSource())
		   .addAnnotatedClasses(User.class)
		   .buildSessionFactory();
	}

	@Bean
	public DataSource getDataSource()
    {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/spring_db");
	    dataSource.setUsername("root");
	    dataSource.setPassword("$!Nabilmuhf29!$");

	    return dataSource;
	}

	@Bean
	public HibernateTransactionManager hibTransMan()
    {
		return new HibernateTransactionManager(sessionFactory());
	}
}
