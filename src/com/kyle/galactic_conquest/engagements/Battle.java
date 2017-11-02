package com.kyle.galactic_conquest.engagements;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.kyle.galactic_conquest.agents.Agent;
import com.kyle.galactic_conquest.agents.Unit_Dictionary;

public class Battle {
	
	private List<Agent> _attackers;
	private List<Agent> _defenders;
	private Scanner _scanner;
	
	
	public Battle(List<Agent> attackers, List<Agent> defenders, Scanner scanner) {
		
		this._attackers = attackers;
		this._defenders = defenders;
		this._scanner = scanner;
		
	}
	
	// one attack for attackers and one defense for defenders. 
	// Returns two integer array [attacker hits, defender hits].
	public int[] battle() {  
		int[] hits = new int[2];
		for(Agent a :_attackers) {
			if (a.attack()) {
				hits[0] += 1;
				// Attacker hits are stored in hits[0]
			}
		}
		for(Agent b : _defenders) {
			if (b.defend()) {
				hits[1] += 1;
				// Defender hits are stored in hits[1]
			}
		}
		return hits;
	}
	
	public void destroy(int hits,List<Agent> combatants, Scanner sc, String team) {
		while(hits > 0) {
			if(combatants.isEmpty()) {System.out.println("All " + team + " destroyed");return;}
			System.out.println(team + " are:");  this.show_combatants(combatants);
			System.out.println("Destroy " + hits + " more units. Enter unit name to destroy: ");
			
			String unit = sc.nextLine();
			
			Boolean hit = false;
			for(Agent combatant : combatants) {
				if(combatant.get_name().equals(unit)) {
					combatants.remove(combatant);
					hits -= 1;
					System.out.println(unit + " destroyed. Remaining units: ");
					this.show_combatants(combatants);
					System.out.println("Remaining hits: " + hits);
					hit = true;
					break;
				}
			if(!hit) {
				System.out.println("This unit is not present. Please select another unit");
			}
			}
			
		}
	}
	
	public String userInput() {
		String input = this._scanner.next();
		System.out.println("the user input was: " + input);
		return input;
	}
	
	public void show_combatants(List<Agent> combatants) {
		if (combatants == null) {System.out.println("No units remaining"); return;}
		List<String> names= new ArrayList<String>();
		for(Agent a : combatants) {
			names.add(a.get_name());
		}
		System.out.println(names);
	}
	
	
	public Boolean engagement(Scanner sc) {
		Boolean victor = false; //True if the attacker wins.
		Boolean retreat = false;
		while(!retreat) {
			int[] hits = this.battle();
			this.destroy(hits[0], this._defenders,sc, "defenders");
			this.destroy(hits[1], this._attackers,sc, "attackers");
			if (this._attackers.isEmpty()) {victor = false; System.out.println("All attacking forces destroyed");break; }
			if (this._defenders.isEmpty()) {victor = true; System.out.println("All defending forces destroyed");break; }
			else {
				System.out.print("Would you like to retreat? Y/N");
				String input = sc.nextLine();
				if(input.equals("Y") || input.equals("y")) {
					retreat = true;
				}
				else if(input.equals("N") || input.equals("n")) {
				}
				else {
					System.out.print("Typo results in miscommunication. Attack continues regardless.");
				}
			}
		}
		if (victor) {System.out.println("Attacker victory");}
		else {System.out.println("Defender victory");}
		return victor;
	}
	

	

}
