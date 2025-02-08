package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    JFrame frame;
    JPanel panel;
    public Menu(){
        frame = new JFrame();
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(false);
    }

    public JFrame getFrame(){
        return frame;
    }
    public void setFrame(boolean b){
        frame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
