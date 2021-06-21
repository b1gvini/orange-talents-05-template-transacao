package br.com.zupacademy.transacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(request-> request.antMatchers(HttpMethod.GET, "/transacoes/**")
												.hasAuthority("SCOPE_batata")
												)
		.csrf().disable()
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
