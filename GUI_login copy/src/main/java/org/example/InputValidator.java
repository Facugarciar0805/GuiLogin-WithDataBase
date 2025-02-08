package org.example;

public class InputValidator {
    public boolean validateUsername(String name){
        String USERNAME_REGEX = "^[A-Za-z0-9!@#\\$%\\^&\\*\\-_+=<>?]{3,20}$";
        return name.matches(USERNAME_REGEX);
    }
}
