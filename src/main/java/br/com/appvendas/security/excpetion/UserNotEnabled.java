package br.com.appvendas.security.excpetion;

import org.springframework.security.core.AuthenticationException;

public class UserNotEnabled extends AuthenticationException {

	public UserNotEnabled(String msg) {
		super(msg);
	}

}
