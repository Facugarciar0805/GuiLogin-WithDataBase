package org.example.Items;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.example.GUI;

public class CreateScene {
    public JPanel createPanel;
    public JLabel createDniLabel;
    public JLabel createNameLabel;
    public JLabel createPasswordLabel;
    public JLabel createSurnameLabel;
    public JTextField createDniText;
    public JTextField createNameText;
    public JTextField createPasswordText;
    public JTextField createSurnameText;
    public JLabel createTitle;
    public Button newCreateButton;
    public CreateScene(){
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

        newCreateButton = new Button("Create your Account", 10, 160, 165, 25);
        createPanel.add(newCreateButton.button);
        newCreateButton.addListener(new GUI());
    }
    
}
