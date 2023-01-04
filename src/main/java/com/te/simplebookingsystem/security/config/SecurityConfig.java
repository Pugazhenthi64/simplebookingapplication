//package com.te.simplebookingsystem.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import lombok.RequiredArgsConstructor;
//
//@EnableWebSecurity
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	
//		
//		private final UserDetailsService userDetailsService;
//		private final PasswordEncoder passwordEncoders; 
//		private final SecurityFilterAutoConfiguration autoConfiguration;
//		@Autowired
//		private final UserDetailsService userDetailsService2;
//		
//		@Autowired
//		private BCryptPasswordEncoder passwordEncoder;
//		
//		@Autowired
//		private InvalidUserAuthEntryPoint authEntryPoint;
//		
//		private final String ADMIN = "ADMIN";
//		private final String User = "USER";
//		@Override
//		@Bean
//			protected AuthenticationManager authenticationManager() throws Exception {
//				return super.authenticationManager();
//		}
//		
//		  @Override
//			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//				auth
//				.userDetailsService(userDetailsService)
//				.passwordEncoder(passwordEncoder); 
//			}
//
//		  
//	
//		 }
//
