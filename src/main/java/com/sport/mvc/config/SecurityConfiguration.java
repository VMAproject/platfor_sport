/**
 * 
 */
package com.sport.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableWebSecurity

@ComponentScan({"com.sport.mvc"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.authorizeRequests()
				.antMatchers("A_small_fitness_first_work_Page.jsp").authenticated()

				.antMatchers("index.jsp").permitAll()
				.and().formLogin().loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")

				.defaultSuccessUrl("/registerPerson/showFirstWorkPage")

				.failureUrl("/login?error=1")
				.and().csrf() //csrf enable so you need to send csrf parameter
				.and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/index")
				.and().exceptionHandling().accessDeniedPage("/404");

	}

}