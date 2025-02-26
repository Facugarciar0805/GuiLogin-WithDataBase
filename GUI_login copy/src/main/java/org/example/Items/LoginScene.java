package org.example.Items;
 
import javax.swing.*;

import org.example.GUI;

public class LoginScene {
    public JPanel loginPanel;
    public JLabel userLabel;
    public JTextField userText;
    public JLabel passwordLabel;
    public JPasswordField passwordText;
    public JTextField surnameText;
    public Button loginButton;
    public Button createButton;
    public JLabel success;
    public LoginScene(){
        loginPanel = new JPanel();
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

        loginButton = new Button("Login", 10, 80, 80, 25);
        loginPanel.add(loginButton.button);
        loginButton.addListener(new GUI());

        createButton = new Button("Create Account", 100, 80, 120, 25);
        loginPanel.add(createButton.button);
        createButton.addListener(new GUI());

        success = new JLabel("");
        success.setBounds(10,110,300,25);
        loginPanel.add(success);
    }
}
