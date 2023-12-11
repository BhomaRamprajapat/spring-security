package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.model.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig 
{

 @Bean
 public PasswordEncoder passwordEncoder()
 {
  return new BCryptPasswordEncoder(11);
 }
 
 @Bean
 public UserDetailsService userDetailsService()
 {
  return new CustomUserDetailsService();
 }
 

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
 {
	  http.csrf(csrf->csrf.disable())
	      .authorizeHttpRequests(authorize->
	      authorize.requestMatchers("/register").permitAll()
	      .anyRequest()
	      .authenticated()
	      );
			 
		  http.formLogin();
		  
  return http.build();
 }
 
 
 @Bean
 public AuthenticationProvider authenticationProvider()
 {
  DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
  authenticationProvider.setUserDetailsService(userDetailsService());
  authenticationProvider.setPasswordEncoder(passwordEncoder());
  
  return authenticationProvider;
 }
}
