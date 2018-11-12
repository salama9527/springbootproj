package com.example.demo;

import java.util.Properties;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.aspectj.lang.annotation.Before;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.controller","com.Entity","com.dao","com.service"})
@EnableTransactionManagement
public class Config {

	@Autowired
    private Environment env;
	
	 @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	        // See: application.properties
	        System.out.println(env.getProperty("spring.datasource.driver-class-name"));
	        System.out.println(env.getProperty("spring.datasource.url"));
	        System.out.println(env.getProperty("spring.datasource.username"));
	        System.out.println(env.getProperty("spring.datasource.password"));
	        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	        dataSource.setUrl(env.getProperty("spring.datasource.url"));
	        dataSource.setUsername(env.getProperty("spring.datasource.username"));
	        dataSource.setPassword(env.getProperty("spring.datasource.password"));
	 
	        System.out.println("## getDataSource: " + dataSource);
	 
	        return dataSource;
	    }
	 
	@Bean
	@Autowired
	  public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	    sessionFactory.setDataSource(getDataSource());
	    sessionFactory.setPackagesToScan("com.controller","com.Entity","com.dao","com.service");
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    hibernateProperties.put("hibernate.show_sql",true);
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	    hibernateProperties.put("spring.jpa.properties.hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");
         
     sessionFactory.setAnnotatedClasses(com.Entity.User.class);
	    sessionFactory.setHibernateProperties(hibernateProperties);

	    return sessionFactory;
	  }
	
}
	

