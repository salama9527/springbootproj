package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"com.dao","com.controller","com.Entity","com.service"})
@Import({Config.class,WebSecurityConfig.class})
@EnableAutoConfiguration(exclude={org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class/*,SecurityAutoConfiguration.class*/})
public class SpringbootRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestWebServiceApplication.class, args);
	}
}
