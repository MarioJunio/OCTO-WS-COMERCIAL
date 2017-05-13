package br.com.appvendas.security.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.appvendas.model.VendedorMobile;
import br.com.appvendas.security.excpetion.UserNotEnabled;
import br.com.appvendas.service.VendedorMobileService;

@Component
public class VendedorMobileAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private VendedorMobileService vendedorMobileService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		String usuario = auth.getName();
		String senha = auth.getCredentials().toString();

		VendedorMobile vendedorMobile = vendedorMobileService.entrar(usuario, senha);

		// se encontrou o vendedor
		if (vendedorMobile != null) {
			
			// checa se o vendedor está ativo
			if (vendedorMobile.isAtivo()) {
				
				Collection<? extends GrantedAuthority> permissoes = vendedorMobile.getPermissoes();
					
//				System.out.printf("[authentication provider] authenticate %s:%s - %s \n", usuario, senha, permissoes.toString());

				return new UsernamePasswordAuthenticationToken(usuario, senha, permissoes);
			} else {
				throw new UserNotEnabled("Vendedor mobile está desativado");
			}
		}

		throw new BadCredentialsException("Vendedor mobile está desativado");
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
