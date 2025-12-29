package com.contacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    // @Bean
    // public UserDetailsService userDetailsService() {

    //     UserDetails user1 = User.withUsername("admin123")
    //             .password(passwordEncoder().encode("admin123"))
    //             .roles("ADMIN", "USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(user1);
    // }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider(null);

        provider.setUserDetailsService(null);
        provider.setPasswordEncoder(null);
        

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
