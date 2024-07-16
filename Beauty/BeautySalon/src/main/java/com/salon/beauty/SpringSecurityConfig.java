package com.salon.beauty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.salon.beauty.servicios.AutenticacionService;


//@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private AutenticacionService autenticacionService;
	

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(autenticacionService);		 
    }
	
	@Configuration
	@Order(1)
	public static class RestfulSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
	    private AccessDeniedHandler accessDeniedHandler;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
		
			 http
			 	.csrf().disable();
			
			 http
				.antMatcher("/api/**")
				.authorizeRequests()
				.anyRequest()
				.hasRole("Administrador")
			  .and()
			  	.httpBasic()
			  .and()
			  	.sessionManagement()
			  		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)//No se necesita que la sesion sea creada
			  .and()			 
	         	.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // solo cuando el usuario no tiene el rol o privilegio. Aun cuando la clave sea correcta;
			  
			
		}
		
		
	}
	
	@Configuration
	@Order(2)
	public static class WebLoginSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
	    private AccessDeniedHandler accessDeniedHandler;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			
			 http
	         .authorizeRequests()
					.antMatchers("/", "/index","/css/**","/fonts/**","/images/**","/js/**","/video/**").permitAll()
					//.antMatchers("/resources/**").permitAll()
					.antMatchers("/admin/**").hasAnyRole("Administrador")
					.antMatchers("/user/**").hasAnyRole("Estilista")
					.anyRequest().authenticated()
	         .and()
	         	.formLogin()
					.loginPage("/login")
					.permitAll()
			 .and()
	         	.logout()	         		
	         	    .invalidateHttpSession(true)
	         		.deleteCookies("auth_code", "JSESSIONID")
	         		.permitAll()
			 .and()
			    .csrf()
			 .and()
	         	.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // solo cuando el usuario no tiene el rol o privilegio. Aun cuando la clave sea correcta
			
			
			 
			 
		}
		
	}
	
	
	 
	
	/*
	 *    @Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/assets/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .and()
                .csrf();
}
	 * */
	
}
