package br.com.appvendas.security.entrypoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import br.com.appvendas.security.config.SecurityConfiguration;
import br.com.appvendas.security.excpetion.UserNotEnabled;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
		
		// usuario e/ou senha nao encontrados
		if (authException.getClass().equals(BadCredentialsException.class)) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} else if (authException.getClass().equals(UserNotEnabled.class)) { // usuario nao ativo 
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
		
//		PrintWriter printWriter = response.getWriter();
//		printWriter.write("HTTP STATUS 401: " + authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName(SecurityConfiguration.REALM);
		super.afterPropertiesSet();
	}
}
