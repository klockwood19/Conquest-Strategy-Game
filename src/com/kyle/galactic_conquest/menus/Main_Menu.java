package com.kyle.galactic_conquest.menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kyle.galactic_conquest.game.Game;
import com.kyle.galactic_conquest.game.Window;

public class Main_Menu extends Window {
	
	
	public Main_Menu (Game game, JPanel panel) {
		super(1000, 600, "Conquest", game);
		
	}
	
	public JFrame getFrame() {
		return this._frame;
	}
	
	public void setFrame(JFrame frame) {
		this._frame = frame;
	}

}
