package org.example;

public class InputValidator {
    public boolean validateUsername(String name){
        String USERNAME_REGEX = "^[A-Za-z0-9!@#\\$%\\^&\\*\\-_+=<>?]{3,20}$";
        return name.matches(USERNAME_REGEX);
    }
    public boolean validatePassword(String password){
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(regex);
    }
}
