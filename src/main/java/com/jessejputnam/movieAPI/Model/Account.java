package com.jessejputnam.movieAPI.Model;

import java.util.UUID;

public class Account {
    private String accountId;
    private String username;
    private String password;
    private String email;

    /**
     * Create new account to push to DB
     * 
     * @param username String for unique username
     * @param password String
     * @param email    String for unique email
     */
    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountId = UUID.randomUUID().toString();
    }

    /**
     * Recreate existing account from DB will all fields
     * 
     * @param accountId String
     * @param username  String
     * @param password  String
     * @param email     String
     */
    public Account(String accountId, String username, String password, String email) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId() {
        accountId = UUID.randomUUID().toString();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

        return acc.getAccountId().equals(accountId) && acc.getPassword().equals(password)
                && acc.getUsername().equals(username) && acc.getEmail().equals(email);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account{" + "id: " + accountId + ", username: " + username + ", password: " + password + ", email: "
                + email + "}";
    }
}
