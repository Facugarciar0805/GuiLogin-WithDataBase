package org.example;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.MouseEvent;
import java.awt.Color;

public class Button extends Component{


    public JButton button;
    public int nose;


    public Button(String tag, int x, int y, int width, int height){
        button = new JButton(tag);
        button.setBounds(x,y,width,height);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 255)); // Dodger blue
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setBorder(new LineBorder(new Color(30, 144, 255), 2, true)); // Bordes redondeados
        button.setOpaque(true);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                  button.setBackground(new Color(0, 102, 204)); // Azul más oscuro
            }
            @Override
            public void mouseExited(MouseEvent e) {
                 button.setBackground(new Color(30, 144, 255)); // Azul original
            }
        });
    }
    public void addListener(ActionListener act){
        button.addActionListener(act);
    }
    
}
