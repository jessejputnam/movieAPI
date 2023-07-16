package com.jessejputnam.movieAPI.Model;

import java.util.UUID;

public class Account {
    private String id;
    private String username;
    private String password;
    private String email;

    /**
     * Constructor for new account to push to DB
     * 
     * @param username - String
     * @param password - String
     * @param email    - String
     */
    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Constructor for existing account from DB will all fields
     * 
     * @param id       - String
     * @param username - String
     * @param password - String
     * @param email    - String
     */
    public Account(String id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Account acc = (Account) obj;

        return acc.getId().equals(id) && acc.getPassword().equals(password)
                && acc.getUsername().equals(username) && acc.getEmail().equals(email);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account{" + "id: " + id + ", username: " + username + ", password: " + password + ", email: "
                + email + "}";
    }
}
