package com.innosolv.authserver

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService}
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service("userDetailsService")
class UserService extends UserDetailsService {

  override def loadUserByUsername(username: String) = {
    if ("naga" == username) new User(username, "user-secret", List("Contractor"))
    else new User(username, "user-secret", List("Non-Contractor"))
  }
}

class User(userName: String, pwd: String, authorities: List[String]) extends UserDetails {

  override def isAccountNonLocked = true

  override def getAuthorities = {
    authorities.map(a => new GrantedAuthority() {
      override def getAuthority: String = "ROLE_" + a
    } ).asJava
  }

  override def getUsername = userName

  override def getPassword = pwd

  override def isCredentialsNonExpired = true

  override def isAccountNonExpired = true

  override def isEnabled = true
}
