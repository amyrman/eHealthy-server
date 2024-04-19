package com.ehealth.server.resources;

public class UserCredentials {
    private String email;
    private String password;

    // Default constructor for JSON (de)serialization
    public UserCredentials() {
    }

    // Constructor with parameters
    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter for username
    public String getEmail() {
        return email;
    }

    // Setter for username
    public void setEmail(String email) {
        this.email = email;
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
