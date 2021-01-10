package com.example.springbootdemo.security;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import com.example.springbootdemo.entity.Role;
import com.example.springbootdemo.repository.RoleRepository;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password, enabled from user where username=?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username=?");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		List<Role> roles = roleRepository.findAll();
		List<String> canEditUser = new ArrayList<String>(),
		canEditRole = new ArrayList<String>(),
		canEditTask = new ArrayList<String>(),
		canEditProf = new ArrayList<String>();
		
		roles.forEach((r)->{
			if(r.isEditFutureProf())
				canEditProf.add(r.getName());
			if(r.isEditRole())
				canEditRole.add(r.getName());
			if(r.isEditTask())
				canEditTask.add(r.getName());
			if(r.isEditUser())
				canEditUser.add(r.getName());
		});
		
		System.out.println("Can Edit Profs: "+canEditProf);
		System.out.println("Can Edit Roles	: "+canEditRole);
		
		http.authorizeRequests() // authorize
				.antMatchers("/").permitAll() // allow "/" to be seen without authentication
				.antMatchers("/api/*").hasAnyRole("ADMIN")
				.antMatchers("/api/roles/*").hasAnyRole(canEditRole.toArray(new String[0]))
				.antMatchers("/api/future_teachers/*").hasAnyRole(canEditProf.toArray(new String[0]))
				.antMatchers("/api/users/*").hasAnyRole(canEditUser.toArray(new String[0]))
				.antMatchers("/api/tasks/*").hasAnyRole(canEditTask.toArray(new String[0]))
				.anyRequest().authenticated() // all requests are authenticated
				.and().formLogin().permitAll() // allow "/login"
				.defaultSuccessUrl("/", true) // set default page for success login
				.and().logout().permitAll() // allow "logout"
				.and().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
				
	
	}
}
