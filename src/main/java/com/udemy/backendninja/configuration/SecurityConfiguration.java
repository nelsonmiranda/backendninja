package com.udemy.backendninja.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioService")
	private UserDetailsService usuarioService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/*","/imgs/*").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
		.usernameParameter("usuario").passwordParameter("password")
		.defaultSuccessUrl("/loginsuccess").permitAll() //No existe url
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
		.permitAll();
	}

	
}
