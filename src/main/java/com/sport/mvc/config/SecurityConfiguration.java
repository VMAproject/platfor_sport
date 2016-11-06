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
	    	.antMatchers("/resources/**").permitAll()
	    	.antMatchers("/404").permitAll()
	        .antMatchers("/login").permitAll()
			.antMatchers("/home").permitAll() //тестовая страница сюда переходит
	        .antMatchers("/registration").permitAll()
	        .antMatchers("/**").authenticated() /// на страницы не пеоеходит которые идут с этим маркером
	        .and().formLogin().loginPage("/login")
	        .usernameParameter("username")
			.passwordParameter("password")

	        .failureUrl("/login?error=1")
	        .and().csrf() //csrf enable so you need to send csrf parameter
	        .and().logout().logoutUrl("/logout")
	        .logoutSuccessUrl("/login")
	        .and().exceptionHandling().accessDeniedPage("/404");
	    }
	    
	    
}