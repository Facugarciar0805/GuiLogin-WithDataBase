package org.example.Items;

import javax.swing.JPanel;

import org.example.GUI;

public class MainMenuScene {
    public JPanel mainMenuPanel;
    public Button backToLogIn;
    public MainMenuScene(){

        mainMenuPanel = new JPanel();
        backToLogIn = new Button("Back to Log In", 10, 200, 170, 25);
        mainMenuPanel.add(backToLogIn.button);
        backToLogIn.addListener(new GUI());
    }
}
