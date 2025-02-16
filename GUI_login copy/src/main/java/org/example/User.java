package org.example;

public class User {
    String name;
    String password;
    String surname;
    public User(String name, String password, String surname){
        this.name = name;
        this.password = password;
        this.surname = surname;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public String getSurname(){
        return surname;
    }
}