package com.kyle.galactic_conquest.engagements;

public class Team {
	
	private String _name;
	private Boolean _alignment; //True = attacker, False = defender
	private Boolean _victor = false;
	
	public Team(String name,Boolean alignment) {
		this._name = name;
		this._alignment = alignment;
	}

}
