package net.mofed.reportracking.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.mofed.reportracking.app.service.UserDetailsServiceImpl;



@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable()
		.authorizeRequests()
		
		.antMatchers("/").hasAnyAuthority( "EMCP","ADMIN","USER","AUDIT","BUDGET","CASH","PROPERTY","INSPECTION","ACCOUNT")
        		
		.antMatchers("/list-todos").hasAnyAuthority("ADMIN","EMCP")
		
		.antMatchers("/organizations").hasAnyAuthority("ADMIN","EMCP")	
		
		.antMatchers("/audittransactionlists").hasAnyAuthority("AUDIT")
		.antMatchers("/budgettransactionlists").hasAnyAuthority("BUDGET")
		.antMatchers("/propertytransactionlists").hasAnyAuthority("PROPERTY")
		.antMatchers("/cashtransactionlists").hasAnyAuthority("CASH")
		.antMatchers("/accounttransactionlists").hasAnyAuthority("ACCOUNT")
		
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		;
	}
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}
	
	}
