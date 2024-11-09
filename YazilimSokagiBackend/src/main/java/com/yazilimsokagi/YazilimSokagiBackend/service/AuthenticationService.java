
// 7. Authentication Service
package com.yazilimsokagi.YazilimSokagiBackend.service;

import com.yazilimsokagi.YazilimSokagiBackend.dto.AuthenticationRequest;
import com.yazilimsokagi.YazilimSokagiBackend.dto.RegisterRequest;
import com.yazilimsokagi.YazilimSokagiBackend.model.User;
import com.yazilimsokagi.YazilimSokagiBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.yazilimsokagi.YazilimSokagiBackend.dto.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))  // Şifreyi şifreliyoruz
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user.getUsername());  // Direkt User kullanabilirsiniz
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = repository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));  // Optional ile orElseThrow kullanımı
        var jwtToken = jwtService.generateToken( user.getUsername());  // UserDetails implementasyonu yapıldığı için doğrudan User kullanılabilir
        return new AuthenticationResponse(jwtToken);
    }
}