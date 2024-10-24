package com.caixinha.api.response;

public class LoginResponse {
    private int id;

    private String token;

    private long expiresIn;

    private String email;

    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoginResponse [id=" + id + ", token=" + token + ", expiresIn=" + expiresIn + ", email=" + email
                + ", name=" + name + "]";
    }
}
