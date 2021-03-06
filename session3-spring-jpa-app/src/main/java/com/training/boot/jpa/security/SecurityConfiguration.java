package com.training.boot.jpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// Whenever you want to customize the security
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Override the security for rest endpoints
	// all request to http://localhost:8080/employees/{id} will be authenticated
	// httpBasic will authenticate details from POSTMAN & client app like Angular
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/employees/**").authenticated().antMatchers("/contact").permitAll()
				.antMatchers("/status").permitAll().and().httpBasic();
	}

	// Override to create the user credentials programmatically
	// User Management using InMemoryUserDetailsManager
	// User -> username, password, ROLE -> ADMIN or ROLE -> USER
	// ROLE defines authority granted to that user

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManager inMemoryManager = new InMemoryUserDetailsManager();

		// Create a User
		UserDetails user1 = User.withUsername("john").password("12345").authorities("ADMIN").build();

		// Create a User
		UserDetails user2 = User.withUsername("jill").password("12345").authorities("GUEST").build();

		// register use with in memory authentication manager
		inMemoryManager.createUser(user1);
		inMemoryManager.createUser(user2);

		// register the manager with the authentication manager builder
		auth.userDetailsService(inMemoryManager);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
