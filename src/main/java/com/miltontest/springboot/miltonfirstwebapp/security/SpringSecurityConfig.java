package com.miltontest.springboot.miltonfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Same as applicationContext.xml
public class SpringSecurityConfig {
  
  @Bean
  public InMemoryUserDetailsManager createUserDetailsMgr() {
    UserDetails user1 = createNewUser("milton", "test");
    UserDetails user2 = createNewUser("test", "test");
    return new InMemoryUserDetailsManager(user1, user2);
  }
  
  @Bean
  public PasswordEncoder bcryptEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  private UserDetails createNewUser(String name, String pw) {
    Function<String, String> passwordEncoder = input -> bcryptEncoder().encode(input);

    UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(name).password(pw)
        .roles("USER", "ADMIN").build();
    return userDetails;
  }
  
  //CSRF disabled
  //Frames
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated());
    
    http.formLogin(withDefaults());
    http.csrf().disable();
    http.headers().frameOptions().disable();
    
    return http.build();
  }
}
