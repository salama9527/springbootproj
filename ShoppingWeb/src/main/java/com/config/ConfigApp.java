package com.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform.TransactionManagerAdapter;
import org.hibernate.service.Service;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryImpl;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.controller","com.dao","com.model","com.service","com.entity"})
public class ConfigApp {

@Bean
public InternalResourceViewResolver getViewResolver()
{
	InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
	internalResourceViewResolver.setPrefix("/WEB-INF/");
	internalResourceViewResolver.setSuffix(".jsp");
	return internalResourceViewResolver;
}

@Bean
public DataSource getDataSource(){
	DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
	driverManagerDataSource.setUrl("jdbc:mysql://localhost/shoppingApp");
	driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	driverManagerDataSource.setUsername("root");
	driverManagerDataSource.setPassword("root");
	return driverManagerDataSource;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
	
	localSessionFactoryBuilder.addAnnotatedClass(com.entity.User_Hlo.class);
	localSessionFactoryBuilder.addAnnotatedClasses(com.entity.User_Hlo.class,com.entity.Category_Hlo.class,com.entity.Subcategory_Hlo.class);
	localSessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
	localSessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "create");
	return localSessionFactoryBuilder.buildSessionFactory();
}
@Bean
@Autowired
public PlatformTransactionManager getTransactionmanager(SessionFactory sessionFactory)
{
	HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
	return hibernateTransactionManager;
}
}
