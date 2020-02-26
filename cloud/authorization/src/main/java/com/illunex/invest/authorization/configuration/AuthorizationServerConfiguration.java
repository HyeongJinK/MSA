package com.illunex.invest.authorization.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("reader")
                    .authorizedGrantTypes("code","authorization_code", "implicit","password")
                    .redirectUris("http://my.redirect.uri")
                    .secret("{noop}secret")
                    .scopes("product:read")
                    .accessTokenValiditySeconds(600_000_000)
                    .and()
                .withClient("writer")
                    .authorizedGrantTypes("code","authorization_code", "implicit","password")
                    .redirectUris("http://my.redirect.uri")
                    .secret("{noop}secret")
                    .scopes("product:read", "product:write")
                    .accessTokenValiditySeconds(600_000_000)
                    .and()
                .withClient("noscopes")
                    .authorizedGrantTypes("code","authorization_code", "implicit","password")
                    .redirectUris("http://my.redirect.uri")
                    .secret("{noop}secret")
                    .scopes("none")
                    .accessTokenValiditySeconds(600_000_000);
    }
}
