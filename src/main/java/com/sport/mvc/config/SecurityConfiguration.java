/**
 * 
 */
package com.sport.mvc.config;

import com.sport.mvc.models.SessionHistory;
import com.sport.mvc.services.SessionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Configuration
@EnableWebSecurity
@ComponentScan({"com.sport.mvc"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	UserDetailsService userDetailsService;


	@Autowired
	SessionHistoryService sessionHistoryService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		history();
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

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	private void history() {
		SessionHistory sessionHistory = new SessionHistory();
        sessionHistory.setSessionDate(new Date());
//		sessionHistory.setUsers(user);
        sessionHistoryService.addSession(sessionHistory);
    }

}