package com.Authenticate.Auth.DTO.Response;

import lombok.Data;

@Data
public class AuthResponse {

    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
