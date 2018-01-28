package com.kyle.galactic_conquest.menus;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.List;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map_Menu extends JPanel {
	
	private JPanel map_panel = new JPanel();
	
	
	public Map_Menu(ArrayList<String> map_list) {
		
		
		for(String map : map_list) {
			JButton button = new JButton();
			
		}
		
		JLabel label = new JLabel("Select a map to play");
		label.setBounds(150, 150, 400, 200);
		label.setVisible(true);
		map_panel.add(new JButton("WHATEVER YOU DO, DON'T CLICK THIS BUT-"));
		map_panel.setBounds(0, 0, 1000, 600);
		map_panel.setBackground(Color.WHITE);
		
		map_panel.setVisible(true);
	}
	
	public JPanel getMapPanel() {
		return map_panel;
	}
    }
