package com.kyle.galactic_conquest.engagements;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kyle.galactic_conquest.agents.Agent;
import com.kyle.galactic_conquest.agents.Unit_Dictionary;

public class LoadUnits {
	
	private Hashtable<String,Integer> _attackers = new Hashtable<String,Integer>();
	private Hashtable<String,Integer> _defenders = new Hashtable<String,Integer>();
	
	private ArrayList<Agent> _attackingAgents = new ArrayList<Agent>();
	private ArrayList<Agent> _defendingAgents = new ArrayList<Agent>();
	
	
	public LoadUnits(Unit_Dictionary units, Scanner scanner) {
		
		System.out.println("enter attackers");
		Set<String> keys = (units.getUnit_dictionary()).keySet();
		for(String key : keys) {
			System.out.println("Input number of attacking unit-type '" + key +"':");
			
			int quant = scanner.nextInt();
			_attackers.put(key, quant);
		}
		
		System.out.println("enter defenders");
		Set<String> keys2 = (units.getUnit_dictionary()).keySet();
		for(String key : keys2) {
			System.out.println("Input number of defending unit-type '" + key +"':");
			int quant = scanner.nextInt();
			_defenders.put(key, quant);
		}
		
		//create Agent objects and load into _attacking and defending agents.
		Set<String> attacking_units = this._attackers.keySet();
		for(String name : attacking_units) {
			int count = this._attackers.get(name);
			ArrayList<Integer> stats = new ArrayList<Integer>();
			for(int i : units.getUnit_dictionary().get(name)) {
				stats.add(i);
			}
			Agent combatant = new Agent(name,null,stats.get(0), stats.get(1),stats.get(2),stats.get(3),stats.get(4),stats.get(5),null);
			for(int n = 0; n < count; n++) {
				this._attackingAgents.add(combatant);
			}
		}
		
		Set<String> defending_units = this._defenders.keySet();
		for(String name : attacking_units) {
			int count = this._defenders.get(name);
			ArrayList<Integer> stats2 = new ArrayList<Integer>();
			for(int i : units.getUnit_dictionary().get(name)) {
				stats2.add(i);
			}
			Agent combatant = new Agent(name,null,stats2.get(0), stats2.get(1),stats2.get(2),stats2.get(3),stats2.get(4),stats2.get(5),null);
			for(int n = 0; n < count; n++) {
				this._defendingAgents.add(combatant);
			}
		}
			
	}
	
	public Hashtable<String,Integer> getAttackers() {
		return this._attackers;
	}
	
	public Hashtable<String,Integer> getDefenders() {
		return this._defenders;
	}
	
	public ArrayList<Agent> getAttackingAgents() {
		return this._attackingAgents;
	}
	
	public ArrayList<Agent> getDefendingAgents() {
		return this._defendingAgents;
	}
	
	
	public void display_count() {
		System.out.println(this._attackers);
		System.out.println(this._defenders);
	}

}
