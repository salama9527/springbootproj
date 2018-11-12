package com.Controller;

import java.util.Locale;


import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableTransactionManagement
@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.Controller","com.Dao","com.Model","com.Service","com.Entity"})
public class Config extends WebMvcConfigurerAdapter{
	
	@Bean
 public ViewResolver getResolver()
 {
	 InternalResourceViewResolver irv=new InternalResourceViewResolver();
	 irv.setPrefix("/WEB-INF/");
	 irv.setSuffix(".jsp");
	 return irv;
 }
	@Bean
	 public DriverManagerDataSource getDataSource() {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	          dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	          dataSource.setUrl("jdbc:mysql://localhost/mvcJpaCrud");
	          dataSource.setUsername("root");
	          dataSource.setPassword("root");
	      return dataSource;
	 }
	 @Bean
	 @Autowired
	 public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException{
	      JpaTransactionManager jpaTransaction = new JpaTransactionManager();
	      jpaTransaction.setEntityManagerFactory(emf);
	      return jpaTransaction;
	 }
	@Bean
	 public LocalContainerEntityManagerFactoryBean getEMF() {
	     LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	     emf.setDataSource(getDataSource());
	     emf.setPackagesToScan(new String[] { "com.Controller","com.Dao","com.Model","com.Service" ,"com.Entity"});
	     emf.setJpaVendorAdapter(getHibernateAdapter());
	         Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	        jpaProperties.put("hibernate.format_sql","false");
	      emf.setJpaProperties(jpaProperties);
	   return emf;
	 }
	  @Bean
	  public JpaVendorAdapter getHibernateAdapter() {
	      return new HibernateJpaVendorAdapter();
	  }

	  @Bean(value="messageSource")
	  public MessageSource getSource(){
		  System.out.println("source message");
		  ResourceBundleMessageSource rbms=new ResourceBundleMessageSource();
		  rbms.setBasenames("messages");
		  rbms.setUseCodeAsDefaultMessage(true);
		  return rbms;
	  }
	  @Bean(value="localeResolver")
	  public LocaleResolver getLocaleResolver()
	  {
		  System.out.println("locale resolver");
		  CookieLocaleResolver clr=new CookieLocaleResolver();
		  clr.setDefaultLocale(new Locale("en","US"));
		  return clr;
	  }
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
		lci.setParamName("lang");
		registry.addInterceptor(lci);
	}
	}

