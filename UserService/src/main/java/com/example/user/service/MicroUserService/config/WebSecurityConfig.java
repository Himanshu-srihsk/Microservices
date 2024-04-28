package com.example.user.service.MicroUserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	@Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		try {
			httpSecurity.authorizeHttpRequests((requests) -> requests
				    .anyRequest().authenticated())
			.oauth2ResourceServer((oauth2) -> oauth2
				    .jwt(Customizer.withDefaults()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return httpSecurity.build();
   }
}
