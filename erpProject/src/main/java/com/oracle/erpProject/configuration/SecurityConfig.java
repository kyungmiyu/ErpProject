package com.oracle.erpProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.cors(cors -> cors.disable())
		    .csrf(csrf -> csrf.disable())
		    ;
		
		return http.build();
		/*
		
		 http
         .authorizeHttpRequests((authz) -> authz
             .anyRequest().authenticated()
         )
         .httpBasic(withDefaults());
		 return http.build();
		*/

	}
	/*
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
	    }
	
*/
}
