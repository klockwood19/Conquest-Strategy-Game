package com.kyle.galactic_conquest.game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.color.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {
	
	protected JFrame _frame;

	public Window(int w, int h, String title, Game game) {
		
		game.setPreferredSize(new Dimension(w,h));
		game.setMaximumSize(new Dimension(w,h));
		game.setMinimumSize(new Dimension(w,h));
		
		_frame = new JFrame(title);
		_frame.setSize(1000, 600);
		_frame.setLayout(null);
		_frame.setBackground(Color.BLACK);
		_frame.setTitle(title);
		_frame.setLocationRelativeTo(null);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setVisible(true);		
		
	}
	
	public void addButton(JButton button) {
		_frame.add(button);
	}
	
	public JFrame getFrame() {
		return this._frame;
	}
	

	public void setFrameVisibility() {
		_frame.setVisible(true);
		
	}

}