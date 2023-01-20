package com.miltontest.springboot.miltonfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  public boolean authenticate(String name, String password)
  {
    boolean isValidName = name.equalsIgnoreCase("milton");
    boolean isValidPassword = password.equalsIgnoreCase("test");
    
    return (isValidName && isValidPassword);
  }
}
