package com.nmfzone.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.google.common.base.Strings;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Hibernate
{

    @Value("${config.database.driver}")
    private String db_driver;

    private static final String db_url = "jdbc:mysql://localhost:3306/";

    @Value("${config.database.name}")
    private String db_name;

    @Value("${config.database.username}")
    private String db_username;

    @Value("${config.database.password}")
    private String db_password;

    @Value("${config.database.hibernate.dialect}")
    private String db_dialect;

    @Value("${config.database.hibernate.hbm2ddl_auto}")
    private String db_hbm2ddlAuto;

    @Value("${config.database.hibernate.show_sql}")
    private String db_showSql;

    @Value("${config.database.hibernate.format_sql}")
    private String db_formatSql;

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.nmfzone.app.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(db_driver);
        dataSource.setUrl(db_url + db_name);
        dataSource.setUsername(db_username);
        dataSource.setPassword(db_password);
        return dataSource;
    }

    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        if (!Strings.isNullOrEmpty(db_dialect)) {
            properties.put("hibernate.dialect", db_dialect);
        }
        if (!Strings.isNullOrEmpty(db_hbm2ddlAuto)) {
            properties.put("hibernate.hbm2ddl.auto", db_hbm2ddlAuto);
        }
        if (!Strings.isNullOrEmpty(db_showSql)) {
            properties.put("hibernate.show_sql", db_showSql);
        }
        if (!Strings.isNullOrEmpty(db_formatSql)) {
            properties.put("hibernate.format_sql", db_formatSql);
        }
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s)
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

}
