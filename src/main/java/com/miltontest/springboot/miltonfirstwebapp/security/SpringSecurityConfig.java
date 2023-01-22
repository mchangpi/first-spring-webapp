package com.miltontest.springboot.miltonfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration // Same as applicationContext.xml
public class SpringSecurityConfig {
  
  Function<String, String> passwordEncoder
    = input -> bcryptEncoder().encode(input);

  @Bean
  public InMemoryUserDetailsManager createUserDetailsMgr() {
    UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("milton").password("test")
        .roles("USER", "ADMIN").build();

    return new InMemoryUserDetailsManager(userDetails);
  }
  
  @Bean
  public PasswordEncoder bcryptEncoder() {
    return new BCryptPasswordEncoder();
  }
}
