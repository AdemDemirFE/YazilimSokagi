package com.yazilimsokagi.YazilimSokagiBackend.dto;

public record AuthenticationRequest(
        String username,
        String email,
        String password
) {

}
