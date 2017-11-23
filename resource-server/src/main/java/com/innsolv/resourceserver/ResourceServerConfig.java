package com.innsolv.resourceserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("jwt.signing.key")
    private String jwtSigningKey;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").hasRole("UI");
    }

    //  @Primary
//  @Bean def tokenService: RemoteTokenServices = {
//    val tokenService = new RemoteTokenServices
//    tokenService.setCheckTokenEndpointUrl("http://localhost:8001/oauth/check_token")
//    tokenService.setClientId("api")
//    tokenService.setClientSecret("apisecret")
//    tokenService
//  }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices ts = new DefaultTokenServices();
        ts.setTokenStore(tokenStore());
        return ts;
    }

    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSigningKey);
        return tokenConverter;
    }

}
