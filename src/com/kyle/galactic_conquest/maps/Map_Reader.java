package com.kyle.galactic_conquest.maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

// NOTE THAT YOU MUST CREATE A UNIT_DICTIONARY IN THE MAIN METHOD OR YOU GET AN INPUT EXCEPTION ERROR

public class Map_Reader {
	
	private Hashtable<String,ArrayList<Integer>> map = new Hashtable<String, ArrayList<Integer>>();
	@SuppressWarnings("rawtypes")
	
	private ArrayList<ArrayList> territory_list = new ArrayList<ArrayList>(); // used for loading only
	private Hashtable<String,Space> territory_map = new Hashtable<String,Space>(); // hash map for storing territories. Primary storage format
	
	/**
	 * The constructor opens and reads the csv file containing all territories and their stats.
	 * Loads the territories into a hashMap called territory_map which is the main storage device for the game board.
	 */
	public Map_Reader() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("/C:/Galactic_Conquest/Maps/Westeros.csv")); 
		String line = null;
		while((line = reader.readLine()) != null) {
			ArrayList<String> one_line = new ArrayList<String>();
			one_line.add(line);
			this.territory_list.add((ArrayList<String>) one_line);
		}
		// Construct spaces and assign properties except for neighbors. Spaces must be built before this.
		this.territory_list.remove(0);
		for (ArrayList<String> space : this.territory_list) {
			String spaceString = space.get(0);
			String[] spaceArray = spaceString.split(",");
			if (spaceArray.length != 0 && spaceArray[0] != "") {
				Space territory = new Space(spaceArray[2],null);
				territory.set_region(spaceArray[0]);
				territory.set_allegiance(spaceArray[1]);
				int i = 12;
				HashSet<String> neighbors = new HashSet<String>();
				while (i > 2) {
					neighbors.add(spaceArray[i]);
					i--;
				}
				neighbors.remove("");
				territory.set_neighbors(neighbors);
				territory.set_capital(spaceArray[13]);
				territory.set_fortress(spaceArray[14]);
				territory.set_port(spaceArray[15]);
				territory.set_pointValue(Integer.parseInt(spaceArray[16]));
				i = spaceArray.length - 1;
				HashSet<String> portNeighbors = new HashSet<String>();
				while (i > 16) {
					portNeighbors.add(spaceArray[i]);
					i--;
				}
				territory.set_portNeighbors(portNeighbors);
				this.territory_map.put(spaceArray[2], territory);
			}
		}
	}
	
	public ArrayList<ArrayList> getTerritoryList() {
		return this.territory_list;
	}
	
	public Hashtable<String,Space> getTerritoryMap() {
		return this.territory_map;
	}
	

	public Hashtable<String, ArrayList<Integer>> getUnit_dictionary() {
		return this.map;
	}

	public void setUnit_dictionary(Hashtable<String,ArrayList<Integer>> unit_dictionary) {
		this.map = unit_dictionary;
	}
	
	public void display_units() {
		System.out.println(this.map);
	}

}
