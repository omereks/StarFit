package com.example.starfittwo.Loggin;

public class User {
    private String name;
    private String email;
    private int YellowStarAllowed = 10;

    public int getYellowStarAllowed() {
        return YellowStarAllowed;
    }

    public void setYellowStarAllowed(int yellowStarAllowed) {
        YellowStarAllowed = yellowStarAllowed;
    }

    public int getRedStarAllowed() {
        return RedStarAllowed;
    }

    public void setRedStarAllowed(int redStarAllowed) {
        RedStarAllowed = redStarAllowed;
    }

    private int RedStarAllowed = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
