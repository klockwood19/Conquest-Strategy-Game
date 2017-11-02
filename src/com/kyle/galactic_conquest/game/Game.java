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
import com.kyle.galactic_conquest.engagements.Battle;
import com.kyle.galactic_conquest.engagements.LoadUnits;
import com.kyle.galactic_conquest.maps.Map_Reader;
import com.kyle.galactic_conquest.maps.Space;
import com.kyle.galactic_conquest.menus.Start_Menu;

public class Game extends Canvas implements Runnable{

	@Override
	public void run() {
		// load start menu
		Start_Menu start = new Start_Menu(this);
		start.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}
	 
	public static void main(String args[]) throws InterruptedException, IOException {
//		Game game = new Game();
//		game.run();
//		Agent battleship = new Agent("battleship",null,2,4,4,20);
//		Agent cruiser = new Agent("cruiser",null,2,3,3,12);
//		List<Agent> attackers = new ArrayList<Agent>();
//		attackers.add(battleship);
//		attackers.add(cruiser);
//		List<Agent> defenders = new ArrayList<Agent>();
//		defenders.add(battleship);
//		defenders.add(cruiser);
//		Battle battle = new Battle(attackers,defenders);
//		battle.engagement();
		Map_Reader mr = new Map_Reader();
		System.out.println(mr.getTerritoryMap().get("Harrenhall").get_neighbors());
		Agent Arya = new Agent("Arya", mr.getTerritoryMap().get("The Trident"), 8, 4, 2, 15, 2, 2,mr);
		System.out.println(Arya.get_moves());
		Arya.move("Harrenhall");
		Arya.move("King's Landing");
//		Unit_Dictionary units = new Unit_Dictionary();
//		units.display_units();
//		Scanner scanner = new Scanner(System.in);
//		LoadUnits unit_count = new LoadUnits(units,scanner);
//		List<Agent> attackers = unit_count.getAttackingAgents();
//		List<Agent> defenders = unit_count.getDefendingAgents();
//		System.out.println("attackers are:");
//		for(Agent a : attackers) {
//			a.displayAgent();
//		}
//		System.out.println("defenders are: ");
//		for(Agent a : defenders) {
//			a.displayAgent();
//		}
		//Battle battle = new Battle(attackers,defenders, scanner);
	    //battle.engagement(scanner);
		
	}
	

}
