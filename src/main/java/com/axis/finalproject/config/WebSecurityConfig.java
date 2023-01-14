package com.axis.finalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.axis.finalproject.service.JwtUserDetailsService;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 JwtUserDetailsService userDetailsService;

	  @Autowired
	  private AuthEntryPointJwt unauthorizedHandler;

	  @Bean
	  public AuthTokenFilter authenticationJwtTokenFilter() {
	    return new AuthTokenFilter();
	  }
	  
	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
//	  @Bean
//	  public PasswordEncoder passwordEncoder() {
//		  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		}

	  
	  
	  
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	
	    {
	
	        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	
	   }

	
	    @Bean
	
	    CorsConfigurationSource corsConfigurationSource()
	
	    {
	
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	
	        source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
	
	        return source;
	
	    }
	
	
	
	 
//	  @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	        .authorizeRequests()
//	        .antMatchers("/token")
//	        .permitAll()
//	        .anyRequest()
//	        .authenticated()
//	        .and()
//	        .csrf().disable()
//	        .addFilterBefore(authenticationJwtTokenFilter(), 
//	                UsernamePasswordAuthenticationFilter.class);
//	    }
//	  
	  
	  
	  
}