
package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.filter.CustomerAuthenticationFilter;

import lombok.RequiredArgsConstructor;

/**
 * @author sseyha
 * @date Nov 28, 2022 11:01:29 PM
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic();
		http.addFilter(new CustomerAuthenticationFilter(null));
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("1").password(passwordEncoder().encode("1")).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManagerBean() throws Exception {
		return null;
	}

}
