package com.br.pb.sisbus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.br.pb.sisbus.daos.impl.UsuarioSessionDaoImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan("com.br.pb.sisbus")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DriverManagerDataSource dataSource;
	
	UsuarioSessionDaoImpl usuarioDaoImpl;
	
	@Autowired 
	SisBusAuthenticationProvider sibusAuthenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(sibusAuthenticationProvider);
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/assets/**");
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http
		.authorizeRequests().antMatchers("/admin/**" , "/config_escala/**" , "/config_quadro_horario/**").hasAuthority("ADMIN")
	.and()
		.authorizeRequests().antMatchers("/gestor/**" , "/config_escala/**" , "/config_quadro_horario/**").hasAuthority("GESTOR")
	.and()
		.authorizeRequests().antMatchers("/**" , "/gestor/**" , "/admin/**", "/admin_master/**", "/config_escala/**" , "/config_quadro_horario/**").hasAuthority("ADMIN_MASTER").anyRequest().authenticated()
	.and()
		.formLogin().loginProcessingUrl("/autenticar").loginPage("/login").usernameParameter("username")
		.passwordParameter("password").defaultSuccessUrl("/index" , true).failureUrl("/erro").permitAll()
	.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.and()
		.exceptionHandling().accessDeniedPage("/403")
	.and()
		.csrf().disable();
	
	}
	
}