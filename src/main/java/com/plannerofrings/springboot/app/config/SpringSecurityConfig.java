package com.plannerofrings.springboot.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.plannerofrings.springboot.app.auth.handler.LoginSuccesHandler;
import com.plannerofrings.springboot.app.models.service.JpaUserDetailsService;

//
/* **** SPRING SECURITY CONFIGURATION CLASS ****
 * Spring looks to see if there is any class that implements
 * the WebSecurityConfigurer interface, which implements
 * the WebSecurityConfigurerAdapter class, and if so,
 * uses the functions that interface has to configure
 * application security.*/
//Habilitamos las anotaciones de Spring Security @Secured y @PreAutorize
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// Inject the @Bean to encrypt the passwords
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private LoginSuccesHandler succesHandler;

	/*
	 * Method to register and configure the users of our application
	 * AuthenticationManagerBuilder registers our users and we have to inject it to
	 * be able to use it
	 */
	@Autowired
	protected void configure(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	// Use this method to configure the HttpSecurity through our acl rules on routes
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * all our static resources are going to be public routes
		 */
		http.authorizeRequests()
				.antMatchers("/uploads/**", "/css/**", "/webfonts/**", "/fonts/**", "/js/**", "/images/**", "/listar/**", "/api/clientes/**",
						"/locale")
				.permitAll().anyRequest().authenticated()
				// pass the instance of the SuccesHandler class
				.and().formLogin().successHandler(succesHandler)
				// enable the login page with that route
				.loginPage("/login")// .successForwardUrl("/")
				// implement login for all users
				.permitAll()
				// implement logout for all users
				.and().logout().permitAll()
				// enable the access denied page to the path we gave you in the MvcConfig
				.and().exceptionHandling().accessDeniedPage("/error_403");
	}

}
