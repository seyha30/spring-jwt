package com.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sseyha
 * @date Nov 29, 2022 12:21:36 AM
 */
@Component
@Slf4j
public class CustomerAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public CustomerAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = this.obtainUsername(request);
		String password = this.obtainPassword(request);
		log.info("User name is {} and the password is {} ", username, password);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);

		return authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		return super.obtainPassword(request);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		return super.obtainUsername(request);
	}

	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}

	@Override
	public void setUsernameParameter(String usernameParameter) {
		super.setUsernameParameter(usernameParameter);
	}

	@Override
	public void setPasswordParameter(String passwordParameter) {
		super.setPasswordParameter(passwordParameter);
	}

	@Override
	public void setPostOnly(boolean postOnly) {
		super.setPostOnly(postOnly);
	}

}
