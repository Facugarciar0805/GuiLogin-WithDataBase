package org.example;

import javax.swing.*;


import org.example.Items.Button;
import org.example.Items.CreateScene;
import org.example.Items.LoginScene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GUI implements ActionListener {

    private static Menu menu;

    private static JFrame frame;

    //login scene
    private static LoginScene loginScene;

    //create scene
    private static CreateScene createScene;

    private static InputValidator inputValidator = new InputValidator();

    public static void main(String[] args) {

        menu = new Menu();
        loginScene = new LoginScene();
        
        frame = new JFrame();
        frame.setSize(500,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //>>>>>>>>>> LOGIN SCENE  >>>>>>>>>>
        frame.add(loginScene.loginPanel);


        //>>>>>>>>>>>>> CREATE SCENE >>>>>>>>>>>>
        createScene = new CreateScene();
        

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String os = System.getProperty("os.name").toLowerCase();
        String pythonString = "python3";
        if(os.contains("win")){
            pythonString = "py";
        }else if(os.contains("mac")){
            pythonString = "python3";
        }
        
        String name;
        String password;
        String surname;
        String dni;
        
        String command = e.getActionCommand();
        System.out.println(command);
        switch (command){
            case "Login":
                dni = loginScene.userText.getText();
                password = loginScene.passwordText.getText();
                if(dni.isEmpty()){
                    loginScene.success.setText("Please enter a username");
                    break;
                }
                try {
                    String arg = "2";
                    ProcessBuilder processBuilder = new ProcessBuilder(pythonString, "GUI_login copy/src/main/resources/mainCopy.py", arg, dni, "No hace falta", "No hace falta", password);
                    processBuilder.redirectErrorStream(true);
                    Process process = processBuilder.start();
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);  // Print Python script output
                        }
                        int exitCode = process.waitFor();
                        System.out.println("Python script finished with exit code: " + exitCode);
                    }catch(IOException | InterruptedException exception){
                        System.out.print("FALLAAA");
                    }
                }

                catch(IOException exception){
                    System.out.print("FALLAAA");
                }
                loginScene.success.setText("Usuario ingresado correctamente");
                break;
            case "Create Account":
                switchScene(frame, createScene.createPanel);
                loginScene.userText.setText("");
                loginScene.passwordText.setText("");
                loginScene.surnameText.setText("");
                break;
            case "Create your Account":
                System.out.println("creando cuenta");
                    dni = createScene.createDniText.getText();
                    name = createScene.createNameText.getText();
                    password = createScene.createPasswordText.getText();
                    surname = createScene.createSurnameText.getText();
                    if(dni.isEmpty()){
                        createScene.createTitle.setText("Please enter a DNI");
                        break;
                    }
                    else if(name.isEmpty()){
                        createScene.createTitle.setText("Please enter a username");
                        break;
                    }
                    else if (password.isEmpty()) {
                        createScene.createTitle.setText("Please enter a password");
                        break;
                    }
                    else if(!inputValidator.validatePassword(password)){
                        createScene.createTitle.setText("Enter a strong password");
                        break;
                    }
                    else if(surname.isEmpty()){
                        createScene.createTitle.setText("Please enter a surname");
                        break;
                    }
                
            
                try {
                    String arg = "1";
                    ProcessBuilder processBuilder = new ProcessBuilder(pythonString, "GUI_login copy/src/main/resources/mainCopy.py", arg, dni, name, surname, password);
                    processBuilder.redirectErrorStream(true);
                    Process process = processBuilder.start();
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);  // Print Python script output
                        }
                        int exitCode = process.waitFor();
                        System.out.println("Python script finished with exit code: " + exitCode);
                    }catch(IOException | InterruptedException exception){
                        System.out.print("FALLAAA");
                    }
                }
                catch(IOException exception){
                    System.out.print("FALLooo");
                }

                
                switchScene(frame, loginScene.loginPanel);
                createScene.createDniText.setText("");
                createScene.createNameText.setText("");
                createScene.createPasswordText.setText("");
                createScene.createSurnameText.setText("");
                loginScene.success.setText("Account created succesfully");
                    

                break;
            default:
                throw new IllegalStateException("Que mierda es eso?");

        }

    }
    private static void switchScene(JFrame frame, JPanel newScene) {
        frame.getContentPane().removeAll(); // Remove current content
        frame.add(newScene);               // Add new content
        frame.revalidate();                // Revalidate the frame
        frame.repaint();                   // Repaint to apply changes
    }
}

