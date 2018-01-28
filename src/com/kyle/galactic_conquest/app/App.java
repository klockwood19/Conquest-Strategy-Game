package com.kyle.galactic_conquest.app;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame{
    
    public App(String title){
        super(title);
        this.setBackground(java.awt.Color.BLACK);
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new ShapesPanel());
        this.setVisible(true);
    }
}