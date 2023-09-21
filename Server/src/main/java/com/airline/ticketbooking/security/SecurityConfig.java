package com.airline.ticketbooking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new PassangerUserDetailsService();
    }
    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    			http.authorizeHttpRequests()
//        		.requestMatchers("/passangers/add","/category","/category/**","/category/get").permitAll()
//        		.and()
//                .authorizeHttpRequests()
//                .requestMatchers("/passangers","/passangers/**","/passangers/get","/forgot-password","/reset-password","/flights","/flights/**")
//                .authenticated();
//    			http.formLogin();
//    			http.csrf().disable();
//    			return http.build();
//    }
//   
	@Bean
	SecurityFilterChain defaultSecurityFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.requestMatchers("/category/get").authenticated()
		.requestMatchers("/category").permitAll()
		.requestMatchers("/category/**").hasAnyRole("ADMIN")
		.requestMatchers("/passangers/add").permitAll()
		.requestMatchers("/passangers","/passangers/**",
				"/passangers/get","/forgot-password","/reset-password",
				"/flights","/flights/**").authenticated()
		.requestMatchers("/reservations/**").authenticated()
		.requestMatchers("/reservations/passanger/**").authenticated()
		.requestMatchers("/reservations").permitAll();
		http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		return http.build();
	} 

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}