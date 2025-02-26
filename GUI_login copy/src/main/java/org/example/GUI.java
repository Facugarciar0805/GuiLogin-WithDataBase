package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.TextField;
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
    private static JPanel loginPanel;

    //login scene
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JTextField surnameText;
    private static  JButton loginButton;
    private static JButton createButton;
    private static JLabel success;

    //create scene
    private static JPanel createPanel;
    private static JLabel createDniLabel;
    private static JLabel createNameLabel;
    private static JLabel createPasswordLabel;
    private static JLabel createSurnameLabel;
    private static JTextField createDniText;
    private static JTextField createNameText;
    private static JTextField createPasswordText;
    private static JTextField createSurnameText;
    private static JLabel createTitle;
    private static JButton newCreateButton;


    private static List<User> users = new ArrayList<>();
    private static InputValidator inputValidator = new InputValidator();

    public static void main(String[] args) {

        menu = new Menu();

        //>>>>>>>>>> LOGIN SCENE  >>>>>>>>>>
frame = new JFrame();
loginPanel = new JPanel();
frame.setSize(500,350);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(loginPanel);
loginPanel.setLayout(null);

userLabel = new JLabel("DNI: ");
userLabel.setBounds(10,20,80,25);
loginPanel.add(userLabel);

userText = new JTextField();
userText.setBounds(100,20,165,25);
loginPanel.add(userText);

passwordLabel = new JLabel("Password: ");
passwordLabel.setBounds(10,50,80,20);
loginPanel.add(passwordLabel);

passwordText = new JPasswordField();
passwordText.setBounds(100,50,165,25);
loginPanel.add(passwordText);

loginButton = new JButton("Login");
loginButton.setBounds(10, 80, 80, 25);
loginButton.setForeground(Color.WHITE);
loginButton.setBackground(new Color(30, 144, 255)); // Dodger blue
loginButton.setFocusPainted(false);
loginButton.setBorderPainted(false);
loginButton.setContentAreaFilled(true);
loginButton.setBorder(new LineBorder(new Color(30, 144, 255), 2, true)); // Bordes redondeados
loginButton.setOpaque(true);
loginPanel.add(loginButton);
loginButton.addActionListener(new GUI());
loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(0, 102, 204)); // Azul más oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(30, 144, 255)); // Azul original
            }
        });

createButton = new JButton("Create Account");
createButton.setBounds(100, 80, 120, 25);
createButton.setForeground(Color.WHITE);
createButton.setBackground(new Color(30, 144, 255)); // Dodger blue
createButton.setFocusPainted(false);
createButton.setBorderPainted(false);
createButton.setContentAreaFilled(true);
createButton.setBorder(new LineBorder(new Color(30, 144, 255), 2, true)); // Bordes redondeados
createButton.setOpaque(true);
loginPanel.add(createButton);
createButton.addActionListener(new GUI());
createButton.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        createButton.setBackground(new Color(0, 102, 204)); // Azul más oscuro
    }

    @Override
    public void mouseExited(MouseEvent e) {
        createButton.setBackground(new Color(30, 144, 255)); // Azul original
    }
});

success = new JLabel("");
success.setBounds(10,110,300,25);
loginPanel.add(success);

//>>>>>>>>>>>>> CREATE SCENE >>>>>>>>>>>>
createPanel = new JPanel();
createPanel.setLayout(null);

createTitle = new JLabel("Enter the information to create an account");
createTitle.setBounds(10, 10, 300, 25);
createPanel.add(createTitle);

createDniLabel = new JLabel("DNI: ");
createDniLabel.setBounds(10,40,80,25);
createPanel.add(createDniLabel);

createDniText = new JTextField();
createDniText.setBounds(100, 40, 165, 25);
createPanel.add(createDniText);

createNameLabel = new JLabel("Name: ");
createNameLabel.setBounds(10, 70, 80, 25);
createPanel.add(createNameLabel);

createNameText = new JTextField();
createNameText.setBounds(100, 70, 165, 25);
createPanel.add(createNameText);

createSurnameLabel = new JLabel("Surname: ");
createSurnameLabel.setBounds(10, 100, 80, 25); // Ajustado para que no se superponga
createPanel.add(createSurnameLabel);

createSurnameText = new JTextField();
createSurnameText.setBounds(100, 100, 165, 25); // Ajustado
createPanel.add(createSurnameText);

createPasswordLabel = new JLabel("Password: ");
createPasswordLabel.setBounds(10, 130, 80, 25); // Ajustado para que no se superponga
createPanel.add(createPasswordLabel);

createPasswordText = new JPasswordField();
createPasswordText.setBounds(100, 130, 165, 25);
createPanel.add(createPasswordText);

newCreateButton = new JButton("Create your Account");
newCreateButton.setBounds(10, 160, 165,25);
newCreateButton.setForeground(Color.WHITE);
newCreateButton.setBackground(new Color(30, 144, 255)); // Dodger blue
newCreateButton.setFocusPainted(false);
newCreateButton.setBorderPainted(false);
newCreateButton.setContentAreaFilled(true);
newCreateButton.setBorder(new LineBorder(new Color(30, 144, 255), 2, true)); // Bordes redondeados
newCreateButton.setOpaque(true);
createPanel.add(newCreateButton);
newCreateButton.addActionListener(new GUI());
newCreateButton.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        newCreateButton.setBackground(new Color(0, 102, 204)); // Azul más oscuro
    }

    @Override
    public void mouseExited(MouseEvent e) {
        newCreateButton.setBackground(new Color(30, 144, 255)); // Azul original
    }
});



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
        switch (command){
            case "Login":
                dni = userText.getText();
                password = passwordText.getText();
                if(dni.isEmpty()){
                    success.setText("Please enter a username");
                    break;
                }
                // else if (password.isEmpty()) {
                //     success.setText("Please enter a password");
                //     break;
                // }
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
                break;
            case "Create Account":
                switchScene(frame, createPanel);
                userText.setText("");
                passwordText.setText("");
                surnameText.setText("");
                break;
            case "Create your Account":
                System.out.println("creando cuenta");
                    dni = createDniText.getText();
                    name = createNameText.getText();
                    password = createPasswordText.getText();
                    surname = createSurnameText.getText();
                    if(dni.isEmpty()){
                        createTitle.setText("Please enter a DNI");
                    }
                    else if(name.isEmpty()){
                        createTitle.setText("Please enter a username");
                        break;
                    }
                    else if (password.isEmpty()) {
                        createTitle.setText("Please enter a password");
                        break;
                    }
                    else if(!inputValidator.validatePassword(password)){
                        createTitle.setText("Enter a strong password");
                        break;
                    }
                    else if(surname.isEmpty()){
                        createTitle.setText("Please enter a surname");
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

                
                switchScene(frame, loginPanel);
                createDniText.setText("");
                createNameText.setText("");
                createPasswordText.setText("");
                createSurnameText.setText("");
                success.setText("Account created succesfully");
                    

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

