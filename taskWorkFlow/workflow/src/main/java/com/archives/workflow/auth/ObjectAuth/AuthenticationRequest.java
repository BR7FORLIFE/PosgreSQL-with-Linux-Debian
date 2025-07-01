package com.archives.workflow.auth.ObjectAuth;

public class AuthenticationRequest {
    private String user;
    private String password;

    public AuthenticationRequest() {
    }

    public String getUser() {
        return user;
    }

    public void setEmail(String email) {
        this.user = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
