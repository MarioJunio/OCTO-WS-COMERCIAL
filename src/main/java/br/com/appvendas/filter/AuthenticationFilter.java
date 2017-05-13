package br.com.appvendas.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.UrlPathHelper;

public class AuthenticationFilter implements Filter {

	// authenticate headers
	private final String XAuthUsername = "X-Auth-Username";
	private final String XAuthPassword = "X-Auth-Password";
	private final String XAuthToken = "X-Auth-Token";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;

		Optional<String> username = Optional.ofNullable(httpRequest.getHeader(XAuthUsername));
		Optional<String> password = Optional.ofNullable(httpRequest.getHeader(XAuthPassword));
		Optional<String> token = Optional.ofNullable(httpRequest.getHeader(XAuthToken));

		String resourcePath = new UrlPathHelper().getPathWithinApplication(httpRequest);

		System.out.println("[DEBUG] Autenticação realizada");

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
