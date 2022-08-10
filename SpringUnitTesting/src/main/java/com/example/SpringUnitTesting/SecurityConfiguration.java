package com.example.SpringUnitTesting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll();


//        http.authorizeRequests()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin() // change httpBasic() to oauth2Login() for API resources
//            .and()
//            .logout();


//        // adding a rule to require authentication for all content via OAuth
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        String username = "moe";
        String password = "1234";
        UserDetails thisUser = User.withUsername(username).password(passwordEncoder().encode(password))
                .authorities("admin")
                .build();

        userDetailsManager.createUser(thisUser);

        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}