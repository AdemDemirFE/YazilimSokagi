package com.yazilimsokagi.YazilimSokagiBackend.dto;
public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String Role,
        String password
) {}