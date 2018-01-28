package com.kyle.galactic_conquest.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kyle.galactic_conquest.game.Game;
import com.kyle.galactic_conquest.game.Window;

public class Start_Panel extends Window {
	
	JPanel start_panel = new JPanel();
	
	public Start_Panel (Game game) {
		super(1000, 600, "Conquest", game);
		
		// create buttons
		JButton new_game = new JButton("NEW GAME");
		JButton load_game = new JButton("LOAD GAME");
		JButton help = new JButton("HELP");
		
		// create and add JPanels
		start_panel.setBounds(0, 0, 1000, 600);
		start_panel.setBackground(Color.BLACK);
		
		start_panel.add(new_game);
		start_panel.add(load_game);
		start_panel.add(help);
		start_panel.setVisible(true);
		
		
		new_game.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("New Game pressed");
				start_panel.setVisible(false);
				ArrayList<String> maps = new ArrayList<String>();
				Map_Menu map_menu = new Map_Menu(maps);
				JPanel map_panel = map_menu.getMapPanel();
				map_panel.setVisible(true);
				
				
				System.out.println("Made it here");
				
				
			}
		});
		
		load_game.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						System.out.println("Load Game button was pressed!!!");
						
					}
				});

		help.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Help button was pressed!!!");
				
			}
		});
		
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

	public JPanel getPanel() {
		return this.start_panel;
	}

}
