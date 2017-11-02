package com.kyle.galactic_conquest.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.kyle.galactic_conquest.game.Game;
import com.kyle.galactic_conquest.game.Window;

public class Start_Menu extends Window {
	
	public Start_Menu (Game game) {
		super(1000, 600, "Neptune.io", game);
		
		// create buttons
		JButton new_game = new JButton("NEW GAME");
		new_game.setBackground(Color.green);
		new_game.setFont(new Font("Courier",Font.BOLD, 12));
		new_game.setBorder(BorderFactory.createEtchedBorder());
		JButton load_game = new JButton("LOAD GAME");
		JButton help = new JButton("HELP");
		
		// add buttons
		this._frame.add(new_game);
		this._frame.add(load_game);
		this._frame.add(help);
		
		// format buttons
		new_game.setSize(125,25);
		load_game.setSize(125,25);
		help.setSize(125,25);
		
		new_game.setLocation(437,300);
		load_game.setLocation(437,335);
		help.setLocation(437,370);
		
		new_game.setVisible(true);
		load_game.setVisible(true);
		help.setVisible(true);
		
	}

	{}

}
