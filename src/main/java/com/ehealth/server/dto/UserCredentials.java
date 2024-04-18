package com.ehealth.server.dto;

public class UserCredentials {
    private String username;
    private String password;

    // Default constructor for JSON (de)serialization
    public UserCredentials() {
    }

    // Constructor with parameters
    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
