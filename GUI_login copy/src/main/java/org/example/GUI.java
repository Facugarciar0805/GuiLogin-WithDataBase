package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.example.Items.CreateScene;
import org.example.Items.LoginScene;
import org.example.Items.MainMenuScene;

public class GUI implements ActionListener {

    private static Menu menu;   
    private static JFrame frame;
    private static LoginScene loginScene;                                    //Class that contains items for the login scene
    private static CreateScene createScene;                                 //Class that contains items for the create scene
    private static MainMenuScene mainMenuScene;                            //Class that contains items for the main menu scene
    private static InputValidator inputValidator = new InputValidator();  //Class to validate inputs

    public static void main(String[] args) {

        menu = new Menu();          //No se para que esta esta linea pero por las dudas la dejo ahi
        
        
        frame = new JFrame();                                               //Create tha frame, the window that will open on screen
        frame.setSize(500,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //>>>>>>>>>> LOGIN SCENE  >>>>>>>>>>
        loginScene = new LoginScene();
        frame.add(loginScene.loginPanel);                                   //Adds the loginScene to the frame.
        
        //>>>>>>>>>>>>> CREATE SCENE >>>>>>>>>>>>
        createScene = new CreateScene();                                    //Initialize the create scene

        //>>>>>>>>>>>>> MAIN MENU SCENE >>>>>>>>
        mainMenuScene = new MainMenuScene();
        
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
        
        String name, password, surname, dni, dateBorn, facultad, stack;
        name = "null";
        surname = "null";
        dateBorn = "null";
        facultad = "null";
        stack = "null";
        dni = "null";
        
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
                    ProcessBuilder processBuilder = new ProcessBuilder(pythonString, "GUI_login copy/src/main/resources/mainCopy.py", arg, dni, name, surname, password, dateBorn, facultad, stack);
                    processBuilder.redirectErrorStream(true);
                    Process process = processBuilder.start();
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String line;
                        boolean found = true;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);  // Print Python script output
                            if(line.equals("False")){
                                found = false;
                            }
                        }
                        if(!found){
                            loginScene.success.setText("Contraseña Incorrecta");
                            break;
                        }
                        // if(line.equals("False")){
                        //     loginScene.success.setText("Contraseña Incorrecta");
                        //     break;
                        // }
                        int exitCode = process.waitFor();
                        System.out.println("Python script finished with exit code: " + exitCode);
                    }catch(IOException | InterruptedException exception){
                        System.out.print("FALLAAA");
                    }
                }

                catch(IOException exception){
                    System.out.print("FALLAAA");
                }
                loginScene.userText.setText("");
                loginScene.passwordText.setText("");
                loginScene.success.setText("");
                switchScene(frame, mainMenuScene.mainMenuPanel);
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
                    ProcessBuilder processBuilder = new ProcessBuilder(pythonString, "GUI_login copy/src/main/resources/mainCopy.py", arg, dni, name, surname, password, dateBorn, facultad, stack);
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
            case "Back to Menu":
                switchScene(frame, loginScene.loginPanel);
                break;
            case "Back to Log In":
                switchScene(frame, loginScene.loginPanel);
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

