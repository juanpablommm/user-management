package com.challenge.ecommerce.tps.user_management.users.domain;


import java.util.Objects;

public class User {

    private String names;
    private String surnames;
    private String username;
    private String password;
    private String email;
    private Boolean enabled;

    public User() {
    }

    public User(String names, String surnames, String username, String password, String email, Boolean enabled) {
        this.names = names;
        this.surnames = surnames;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getNames(), user.getNames()) && Objects.equals(getSurnames(), user.getSurnames()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getEnabled(), user.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNames(), getSurnames(), getUsername(), getPassword(), getEmail(), getEnabled());
    }
}
