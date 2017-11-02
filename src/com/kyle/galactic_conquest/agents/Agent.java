package com.kyle.galactic_conquest.agents;
import java.util.Hashtable;
import java.util.Set;

import com.kyle.galactic_conquest.maps.Map_Reader;
import com.kyle.galactic_conquest.maps.Space;
import com.kyle.galactic_conquest.maps.Vertex;


public class Agent {
	
	private String _name;
	private Space _location;
	private int _range;
	private int _attack;
	private int _defense;
	private int _cost;
	private int _special_attack;
	private int _special_defense;
	private Hashtable<String,Space> _map;
	
	private int _moves;
	
	public Agent(String name, Space location, int attack, int defense, int range, int cost, int specAttack, int specDefense, Map_Reader map) {
		this._name = name;
		this._location = location;
		this._range = range;
		this._attack = attack;
		this._defense = defense;
		this.set_cost(cost);
		this._moves = range;
		this.set_special_attack(specAttack);
		this.set_special_defense(specDefense);
		this._map = map.getTerritoryMap();
	}
	
	public void move(String destination) {
		Set<String> neighbors = this._location.get_neighbors();
		if (this._moves > 0 && neighbors.contains(destination)) {
			String origin = this._location.get_name();
			this._location = this._map.get(destination);
			this._moves -= 1;
			System.out.println(this._name + " moved from " + origin + " to " + this._location.get_name());
		}
		else
			System.out.println("Invalid move");
	}
	
	public void displayAgent() {
		Object[] Agent_specs = new Object[8];
		Agent_specs[0] = this._name;
		Agent_specs[1] = this._attack;
		Agent_specs[2] = this._defense;
		Agent_specs[3] = this._range;
		Agent_specs[4] = this._cost;
		Agent_specs[5] = this._special_attack;
		Agent_specs[6] = this._special_defense;
		Agent_specs[7] = this._location;
		for(Object o : Agent_specs) {
			if(o != null) {
				System.out.println(o.toString());
			}
		}
	}
	
	public String get_name() {
		return this._name;
	}
	
	public int get_attack() {
		return this._attack;
	}
	
	public int get_defense() {
		return this._defense;
	}
	
	public int get_range() {
		return this._range;
	}
	public int get_moves() {
		return this._moves;
	}
	
	public void new_turn() {
		this._moves = this._range;
	}
	
	public Boolean attack() {
		int roll = (int) (Math.random() * 10 + 1);
		if (roll <= this._attack) {
			System.out.println("Attacking " + this._name + " scored a hit");
			return true;
		}
		else {
			System.out.println("Attacking " + this._name + " missed");
			return false;
		}
	}
	
	public Boolean defend() {
		int roll = (int) (Math.random() * 10 + 1);
		if (roll <= this._defense) {
			System.out.println("Defending " + this._name + " scored a hit");
			return true;
		}
		else {
			System.out.println("Defending " + this._name + " missed");
			return false;
		}
	}

	public int get_cost() {
		return _cost;
	}

	public void set_cost(int _cost) {
		this._cost = _cost;
	}

	public int get_special_attack() {
		return _special_attack;
	}

	public void set_special_attack(int _special_attack) {
		this._special_attack = _special_attack;
	}

	public int get_special_defense() {
		return _special_defense;
	}

	public void set_special_defense(int _special_defense) {
		this._special_defense = _special_defense;
	}

}
