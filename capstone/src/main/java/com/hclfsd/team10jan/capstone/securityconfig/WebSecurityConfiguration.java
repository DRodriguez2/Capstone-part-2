package com.hclfsd.team10jan.capstone.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
        .antMatchers("/","/css/*", "/js/*").permitAll()
        .antMatchers("/registration").permitAll()
        .antMatchers("/homeAdmin", "/admin/*").hasRole("ADMIN")
        .antMatchers("/music/*").not().hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
			.loginPage("/login").permitAll()
			.failureUrl("/login?error=true")
			.defaultSuccessUrl("/home", true)
			.usernameParameter("username")
			.passwordParameter("password")
		.and()
		.logout()
			.logoutUrl("/logout")
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
	        .logoutSuccessUrl("/login");
	}    
}
