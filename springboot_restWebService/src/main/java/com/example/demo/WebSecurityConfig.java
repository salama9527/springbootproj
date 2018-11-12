package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			System.out.println("configure authentication using jdbc");
			auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).dataSource(dataSource).usersByUsernameQuery("select name,password,enable from Employee where name=?").authoritiesByUsernameQuery("select name,role from Employee_roles where name=?");
			
		}
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		
			System.out.println("configure http security");
			http
			.csrf().disable().authorizeRequests()
			.antMatchers("/employee/add").permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/employee/put","/employee/getAll","/employee/getById/{id}","employee/put/{id}","employee/delete/{id}")
			.authenticated().and().
			addFilter(new JwtAuthenticationFilter(authenticationManager()));
			System.out.println("lets c 1st");
			http.addFilter(new JwtAuthorizationFilter(authenticationManager()));
		
			

}

}
