package com.yazilimsokagi.YazilimSokagiBackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Şifreleri BCrypt ile şifrele
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // BCrypt ile şifrelenmiş şifreleri kullanın
        UserDetails admin = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))  // Şifreyi encode ediyoruz
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))  // Şifreyi encode ediyoruz
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Yetkilendirme işlemleri
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(HttpMethod.POST, "/customers/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/customers/customerAll").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/customers/updateCustomer").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/customers/deleteCustomer/**").hasRole("ADMIN")
                        .anyRequest().authenticated()  // Diğer tüm istekler kimlik doğrulaması gerektirir
                )
                // HTTP Basic Authentication
                .httpBasic(Customizer.withDefaults()) // httpBasic() ile basit kimlik doğrulaması
                .csrf().disable(); // Eğer sadece API erişimi varsa CSRF'i devre dışı bırakabilirsiniz

        return httpSecurity.build();
    }
}