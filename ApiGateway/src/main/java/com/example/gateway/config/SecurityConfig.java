package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	//@SuppressWarnings("removal")
	@Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//		httpSecurity.authorizeExchange(exchanges -> exchanges
//			    .anyExchange().authenticated()).oauth2ResourceServer(OAuth2ResourceServerSpec::jwt);
		
		httpSecurity
	        .authorizeExchange(exchanges ->
	            exchanges
	 
	                .anyExchange().authenticated()
	        )
	        .oauth2ResourceServer(oauth2ResourceServer ->
	            oauth2ResourceServer
	                .jwt(Customizer.withDefaults())
	        );
		
		return httpSecurity.build();
		
  }
	
}
