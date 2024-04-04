package com.oracle.erpProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	/*
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
				 http
		         .authorizeHttpRequests((authz) -> authz
		             .anyRequest().authenticated()
		        		 .requestMatchers("/").permitAll()
		        		 .requestMatchers("/api/1").hasRole("role_employee")
		        		 .requestMatchers("/api/2").hasRole("role_manager")
		        		 .requestMatchers("/api/3").hasRole("role_admin")
		             	 .anyRequest().authenticated()
		         )
		         .httpBasic(withDefaults());
		         .formLogin((formLogin) -> formLogin
		        		 	.usernameParameter("username")
		        		 	.passwordParameter("password")
		        		 	.defaultSuccessUrl("/", true)
		        		 );
				 return http.build();
		*/
		

				http.authorizeHttpRequests()
			    .anyRequest().permitAll(); // 모든 URL에 대한 접근을 모든 사용자에게 허용
				return http.build();

			}
/*
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("").password("").roles("role_").build());
		return manager;
	}
*/

/*
	@Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/예외처리하고 싶은 url", "/예외처리하고 싶은 url");
    }
    
*/
}