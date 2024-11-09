// 5. Authentication Controller
package com.yazilimsokagi.YazilimSokagiBackend.controller;

import com.yazilimsokagi.YazilimSokagiBackend.dto.AuthenticationRequest;
import com.yazilimsokagi.YazilimSokagiBackend.dto.AuthenticationResponse;
import com.yazilimsokagi.YazilimSokagiBackend.dto.RegisterRequest;
import com.yazilimsokagi.YazilimSokagiBackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}