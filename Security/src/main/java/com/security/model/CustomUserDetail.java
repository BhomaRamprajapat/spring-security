package com.security.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.User;

public class CustomUserDetail implements UserDetails
{
	private User user;
	
	public CustomUserDetail(User user)
	{
	 this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
	 HashSet<SimpleGrantedAuthority> set=new HashSet();
	 
	 set.add(new SimpleGrantedAuthority(user.getRole()));
	 
	 return set;
	}

	@Override
	public String getPassword() 
	{
	 return this.user.getPassword();
	}

	@Override
	public String getUsername() 
	{
	 return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
	 return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
	 return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
     return true;
	}

	@Override
	public boolean isEnabled() 
	{
     return true;
	}

}
