package com.kyle.galactic_conquest.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.kyle.galactic_conquest.agents.Agent;
import com.kyle.galactic_conquest.agents.Unit_Dictionary;
import com.kyle.galactic_conquest.app.App;
import com.kyle.galactic_conquest.engagements.Battle;
import com.kyle.galactic_conquest.engagements.LoadUnits;
import com.kyle.galactic_conquest.maps.Map_Reader;
import com.kyle.galactic_conquest.maps.Space;
import com.kyle.galactic_conquest.menus.Main_Menu;
import com.kyle.galactic_conquest.menus.Start_Menu;
import com.kyle.galactic_conquest.menus.Start_Panel;
import com.kyle.galactic_conquest.graphics.Graphic;
import java.awt.geom.*;

public class Game extends Canvas implements Runnable{
	
	private boolean NEW_GAME;
	private boolean LOAD_GAME;
	private boolean QUIT;

	@Override
	public void run() {
		
		App app = new App("War of the Five Kings");
		
			
	}
	 
	public static void main(String args[]) throws InterruptedException, IOException {
		Game game = new Game();
		game.run();
		
//		while(true) {
//
//			Map_Reader mr = new Map_Reader();
//			System.out.println(mr.getTerritoryMap().get("Harrenhall").get_neighbors());
//			Agent Arya = new Agent("Arya", mr.getTerritoryMap().get("The Trident"), 8, 4, 2, 15, 2, 2,mr);
//			System.out.println(Arya.get_moves());
//			Arya.move("Harrenhall");
//			Arya.move("King's Landing");
//		}

		
	}
	

}
