package com.example.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@ComponentScan(basePackages= {"com.example"})
public class WebSecConfig {
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager i=new InMemoryUserDetailsManager();
		i.createUser(User.withDefaultPasswordEncoder().username("Bhanu").password("123456789").roles("Admin").build());
		return i;
	}
	public void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest().hasRole("Bhanu")
			.and().formLogin().and()
			.httpBasic()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/");
	}
}
