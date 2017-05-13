package br.com.appvendas.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

import br.com.appvendas.model.Permissao;
import br.com.appvendas.security.entrypoint.CustomBasicAuthenticationEntryPoint;
import br.com.appvendas.security.provider.VendedorMobileAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	public static final String REALM = "REALM_SEC";
	
	@Autowired
	private VendedorMobileAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("mario").password("mario").roles("USER");
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/produtos/**").hasRole(Permissao.ROLE_USER.getDescricao())
		.antMatchers("/clientes/**").hasRole(Permissao.ROLE_USER.getDescricao())
		.antMatchers("/formasPag/**").hasRole(Permissao.ROLE_USER.getDescricao())
		.antMatchers("/login").hasRole(Permissao.ROLE_USER.getDescricao())
		.and()
		.httpBasic()
		.realmName(REALM)
		.authenticationEntryPoint(getBasicAuthEntryPoint())
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public AuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
}