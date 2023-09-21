package com.airline.ticketbooking.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.airline.ticketbooking.model.Passanger;
import com.airline.ticketbooking.model.Role;


public class PassangerUserDetails implements UserDetails {


	private Passanger passanger;

    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public PassangerUserDetails(Passanger passanger) {
        name=passanger.getName();
        password=passanger.getPassword();
        String s="";
        Set<Role> roleString=passanger.getRoles();
        for(Role r:roleString) {
        	s=r.getRole(); 
        }
        authorities = Arrays.stream(s.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    			return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}