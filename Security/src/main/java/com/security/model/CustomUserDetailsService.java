package com.security.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.entity.User;
import com.security.repository.UserRepository;



public class CustomUserDetailsService implements UserDetailsService 
{   
	@Autowired
    UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
	 User user=userRepository.findByUserName(username);
	 
	 if(user==null)
	  throw new UsernameNotFoundException("User not Found!");
	 
	 return new CustomUserDetail(user);
	}
 
}
