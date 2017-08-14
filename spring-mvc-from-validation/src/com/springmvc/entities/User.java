package com.springmvc.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

public class User {

  private Long id;
  
  @NotNull
  @Size(min=5, max=16)
  private String username;

  @NotNull
  @Size(min=5, max=25)
  private String password;
  
  @NotNull
  @Email
  private String email;

  public User() {}
  
  public User(String username, String password,  String email) {
    this(null, username, password,  email);
  }

  public User(Long id, String username, String password,  String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

 
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object that) {
    return EqualsBuilder.reflectionEquals(this, that,  "username", "password", "email");
  }
  
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this,  "username", "password", "email");
  }

}
