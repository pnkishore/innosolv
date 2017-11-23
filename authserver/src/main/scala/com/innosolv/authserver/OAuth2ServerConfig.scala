package com.innosolv.authserver

import org.springframework.beans.factory.annotation.{Autowired, Qualifier, Value}
import org.springframework.context.annotation.{Bean, Configuration, Primary}
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.{AuthorizationServerConfigurerAdapter, EnableAuthorizationServer}
import org.springframework.security.oauth2.config.annotation.web.configurers.{AuthorizationServerEndpointsConfigurer, AuthorizationServerSecurityConfigurer}
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.store.{JwtAccessTokenConverter, JwtTokenStore}

@Configuration
@EnableAuthorizationServer
class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

  @Value("jwt.signing.key")
  private var jwtSigningKey: String = _

  @Autowired
  @Qualifier("userDetailsService")
  private var userDetailsService: UserDetailsService = _

  @Autowired
  private var authenticationManager: AuthenticationManager = _

  override def configure(endpoints: AuthorizationServerEndpointsConfigurer): Unit = {
    endpoints.authenticationManager(authenticationManager)
      .userDetailsService(userDetailsService)
      .tokenStore(tokenStore)
      .accessTokenConverter(accessTokenConverter())
  }

  override def configure(security: AuthorizationServerSecurityConfigurer): Unit = {
    security.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_API')").checkTokenAccess(
      "hasAuthority('ROLE_API')")
  }

  override def configure(clients: ClientDetailsServiceConfigurer): Unit = {
    clients.inMemory()
      .withClient("ui")
      .secret("uisecret").authorizedGrantTypes("password", "client_credentials")
      .accessTokenValiditySeconds(5000).scopes("read").authorities("ROLE_UI")
        .and()
      .withClient("api")
      .secret("apisecret").authorizedGrantTypes("password", "client_credentials")
      .accessTokenValiditySeconds(5000).scopes("read").authorities("ROLE_API")

  }

  @Bean
  @Primary
  def tokenServices: DefaultTokenServices = {
    val ts = new DefaultTokenServices
    ts.setTokenStore(tokenStore)
    ts
  }

  @Bean
  def tokenStore: JwtTokenStore = new JwtTokenStore(accessTokenConverter())

  @Bean
  def accessTokenConverter(): JwtAccessTokenConverter = {
    val tokenConverter = new JwtAccessTokenConverter
    tokenConverter.setSigningKey(jwtSigningKey)
    tokenConverter
  }
}
