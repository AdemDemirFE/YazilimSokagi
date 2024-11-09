package com.yazilimsokagi.YazilimSokagiBackend.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@Table(name = "Users")
public class User implements UserDetails {  // Implement UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String roles;  // Comma separated roles string
    private String activationKey;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert roles string into GrantedAuthorities (ROLE_USER, ROLE_ADMIN, etc.)
        if (roles != null && !roles.isEmpty()) {
            return List.of(roles.split(","))
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim()))
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;  // Using email as username
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true;  // Account is enabled
    }

    // Remove orElseThrow method from User class. This is better handled in the service layer.
}
