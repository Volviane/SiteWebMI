package com.mi.config;




import javax.validation.OverridesAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("conf1");
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/addRole","/roleList","/index","/registrationAdministrator"
				,"/homeAdministrator","/connectionAdministrator", "/addCycle", "/createEvent", "/addCourse", "/addLevel").permitAll()
		.anyRequest().authenticated().and().formLogin()
		.loginPage("/login").permitAll().and().logout().permitAll();
		System.out.println("conf2");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("conf3");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		System.out.println("conf4");
	}

	
	public void configure(WebSecurity web) throws Exception {
		System.out.println("conf5");
		web.ignoring().antMatchers("/css/*");
		System.out.println("conf6");
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		System.out.println("conf7");
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
		System.out.println("conf8");
		return super.userDetailsService();
	}
	


    
}
