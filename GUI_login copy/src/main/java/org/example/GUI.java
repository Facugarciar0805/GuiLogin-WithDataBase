package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    private static Menu menu;

    private static JFrame frame;
    private static JPanel loginPanel;

    //login scene
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton createButton;
    private static JLabel success;

    //create scene
    private static JPanel createPanel;
    private static JLabel createNameLabel;
    private static JLabel createPasswordLabel;
    private static JTextField createNameText;
    private static JTextField createPasswordText;
    private static JLabel createTitle;
    private static JButton newCreateButton;


    private static List<User> users = new ArrayList<>();
    private static InputValidator inputValidator = new InputValidator();

    public static void main(String[] args) {

        menu = new Menu();

        //>>>>>>>>>> LOGIN SCENE  >>>>>>>>>>
        frame = new JFrame();
        loginPanel = new JPanel();
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(loginPanel);
        loginPanel.setLayout(null);

        userLabel = new JLabel("User: ");
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
        loginButton.setBounds(10,80,80,25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(new GUI());

        createButton = new JButton("Create Account");
        createButton.setBounds(100, 80, 120, 25);
        loginPanel.add(createButton);
        createButton.addActionListener((new GUI()));

        success = new JLabel("");
        success.setBounds(10,110,300,25);
        loginPanel.add(success);

        //>>>>>>>>>>>>> CREATE SCENE >>>>>>>>>>>>
        createPanel = new JPanel();
        createPanel.setLayout(null);
        createTitle = new JLabel("Enter the information to create an account");
        createTitle.setBounds(10, 10, 300, 25);
        createPanel.add(createTitle);

        createNameLabel = new JLabel("Username: ");
        createNameLabel.setBounds(10, 40, 80, 25);
        createPanel.add(createNameLabel);

        createNameText = new JTextField();
        createNameText.setBounds(100, 40, 165, 25);
        createPanel.add(createNameText);

        createPasswordLabel = new JLabel("Password: ");
        createPasswordLabel.setBounds(10, 80, 80, 25);
        createPanel.add(createPasswordLabel);

        createPasswordText = new JPasswordField();
        createPasswordText.setBounds(100, 80, 165, 25);
        createPanel.add(createPasswordText);

        newCreateButton = new JButton("Create your Account");
        newCreateButton.addActionListener(new GUI());
        newCreateButton.setBounds(10, 110, 165,25);
        createPanel.add(newCreateButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command){
            case "Login":
                String name = userText.getText();
                String password = passwordText.getText();
                try {
                    String arg = "2";
                    ProcessBuilder processBuilder = new ProcessBuilder("python3", "GUI_login copy/src/main/resources/mainCopy.py", arg, name);
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
                        System.out.print("FALLooo");
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
                break;
            case "Create your Account":
                System.out.println("creando cuenta");
                String nombre = createNameText.getText();
                String contrasena = createPasswordText.getText();
                if(nombre.isEmpty()){
                    createTitle.setText("Please enter a username");
                }
                else if (contrasena.isEmpty()) {
                    createTitle.setText("Please enter a password");
                }
                else{
                    if(inputValidator.validateUsername(nombre)){
                        boolean found1 = false;
                        for(User u: users){
                            if(u.getName().equals(nombre)){
                                found1 = true;
                                break;
                            }
                        }
                        if(!found1){
                            User user = new User(nombre, contrasena);
                            users.add(user);
                            switchScene(frame, loginPanel);
                            createNameText.setText("");
                            createPasswordText.setText("");
                            success.setText("Account created succesfully");
                        }
                        else{
                            createTitle.setText("That username is taken");
                        }
                    }
                    else{
                        createTitle.setText("That username is invalid");

                    }
                }


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

//try {
//String arg = "Hello world!";
// Define the command to run the Python script
//ProcessBuilder processBuilder = new ProcessBuilder("python3", "src/main/resources/Python/intento.py", arg);
          //  processBuilder.redirectErrorStream(true);  // Merge error and output streams

// Start the process
//Process process = processBuilder.start();

// Read the output of the Python script
           // try (
//BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//String line;
              //  while ((line = reader.readLine()) != null) {
       // System.out.println(line);  // Print Python script output
             //   }
                    //    }

// Wait for the process to finish
//int exitCode = process.waitFor();
            //System.out.println("Python script finished with exit code: " + exitCode);

      //  } catch (IOException | InterruptedException e) {
       // e.printStackTrace();
       // }