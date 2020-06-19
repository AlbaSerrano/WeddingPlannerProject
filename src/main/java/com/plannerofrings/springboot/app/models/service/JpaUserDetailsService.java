package com.plannerofrings.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plannerofrings.springboot.app.models.dao.IUserDao;
import com.plannerofrings.springboot.app.models.entity.Role;
import com.plannerofrings.springboot.app.models.entity.User;

/*Service class that implements the Spring Security UserDetailsService
 *  interface responsible for implementing the user authentication process*/

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	// Inject the dao class
	@Autowired
	private IUserDao userDao;

	// Logger to show some important data on the console
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// get the user with this username
		User user = userDao.findByUsername(username);

		// validate if the user exists
		if (user == null) {
			logger.error("Error login: no existe el usuario + '" + username + "'");
			/*
			 * throw an exception through the spring security class
			 * UsernameNotFoundException when the user doesn't exist
			 */
			throw new UsernameNotFoundException("Usuario " + username + " no existe en el sistema");
		}

		// List to registry the authorities of the user
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// go through the list of user roles
		for (Role role : user.getRoles()) {
			logger.info("Role: " + role.getAuthority());
			/*
			 * Granted Authority is the abstract interface and SimpleGrantedAuthority is the
			 * implementation Registry the role of the user as Authority
			 */
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		// Validate if the user has assigned roles
		if (authorities.isEmpty()) {
			logger.error("Error login: el usuario + '" + username + "' no tiene roles asignados");
			throw new UsernameNotFoundException("Usuario " + username + " no tiene roles asignados");
		}

		// return the authenticated user
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(),
				true, true, true, authorities);
	}

}
