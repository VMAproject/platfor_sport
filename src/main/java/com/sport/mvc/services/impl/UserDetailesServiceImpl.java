package com.sport.mvc.services.impl;


import com.sport.mvc.models.User;
import com.sport.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailesServiceImpl implements UserDetailsService {
	

	@Autowired
	UserService userservice;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userservice.getUserByUsername(username);
		
		if (user != null) {
			String password = user.getPassword();
			boolean enabled= user.getIsactive().equalsIgnoreCase("Y");
			boolean accountNonExpired = user.getIsnonexpired().equalsIgnoreCase("Y");
			boolean credentialsNonExpired= user.getIsnonexpired().equalsIgnoreCase("Y");
			boolean accountNonLocked= user.getIsnonlocked().equalsIgnoreCase("Y");
			
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
			
			org.springframework.security.core.userdetails.User securedUser = 
					new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securedUser;
		}else {
			 throw new UsernameNotFoundException("Invalid User");
		}
		
	}

}
