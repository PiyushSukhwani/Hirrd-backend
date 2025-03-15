package com.hirrd.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationResponse {

    public AuthenticationResponse (String jwt) {
        this.jwt = jwt;
    }
    private final String jwt;
}
