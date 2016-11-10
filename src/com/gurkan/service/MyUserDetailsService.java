package com.gurkan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.UserDAOImpl;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAOImpl userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

		com.gurkan.domain.User user = userDao.findByEmail(email);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getTitle()));

		return buildUserForAuthentication(user, authorities);

	}
	
	// Converts com.gurkan.domain.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.gurkan.domain.User user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), authorities);
	}
	
	public UserDAOImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}

}
