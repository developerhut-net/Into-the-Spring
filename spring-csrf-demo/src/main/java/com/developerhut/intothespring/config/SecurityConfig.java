package com.developerhut.intothespring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
		http.authorizeHttpRequests(request -> 
			request.anyRequest().permitAll()
		)
		.httpBasic(Customizer.withDefaults())
		.csrf(c -> {
			c.ignoringRequestMatchers("/white");
			//c.csrfTokenRepository(csrfTokenRepository());
			//c.csrfTokenRepository(new CustomCSRFTokenRepository());
		});
		//.csrf().disable();
		
		return http.build();
		
	}
	
	@Bean
	public CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-CSRF-TOKEN"); // or X-XSRF-TOKEN
		return repository;
	}
	
}
