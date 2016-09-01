package com.guitar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
		(auth.inMemoryAuthentication().withUser("ion").password("ion").roles(new String[] { "USER" }).and()).withUser("admin").password("admin")
				.roles(new String[] { "USER", "ADMIN" });
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}
}
