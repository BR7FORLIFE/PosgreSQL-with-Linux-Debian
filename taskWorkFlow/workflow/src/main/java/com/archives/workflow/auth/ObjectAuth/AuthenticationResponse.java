package com.archives.workflow.auth.ObjectAuth;

import java.util.Date;

public class AuthenticationResponse {
    public String username;
    public String token;
    public Date datetime;

    public AuthenticationResponse(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
