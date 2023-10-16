package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.dto.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    } 
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().cors().and()
                .authorizeHttpRequests()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .requestMatchers(HttpMethod.GET,"/swagger-ui/**","/v3/api-docs/**").permitAll()//http://localhost:8080/swagger-ui/index.html#/
                    .requestMatchers("/passangers/signup", "/passangers/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/flights/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/flights/**").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/flights/**").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/flights/**").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/trips/**").hasAuthority("ADMIN") 
                    .requestMatchers(HttpMethod.GET, "/trips/**").permitAll() 
                    .requestMatchers(HttpMethod.PUT, "/reservations/**").permitAll() // Require authentication for POST
                    .requestMatchers(HttpMethod.PUT, "/trips/**").hasAuthority("ADMIN") 
                    .requestMatchers(HttpMethod.DELETE, "/trips/**").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/reservations/**").authenticated() // Require authentication for POST
                    .requestMatchers(HttpMethod.GET, "/reservations/**").hasAuthority("USER") // Require ADMIN for GET
                    .requestMatchers(HttpMethod.DELETE, "/reservations/**").hasAuthority("USER") // Require USER for DELETE
                    .requestMatchers("/passangers/**", "/flights/**", "/trips/**", "/reservations/**").authenticated() 
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}