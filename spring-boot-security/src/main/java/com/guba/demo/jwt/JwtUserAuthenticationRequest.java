package com.guba.demo.jwt;

public class JwtUserAuthenticationRequest {

    private String username;

    private String password;

    public JwtUserAuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
