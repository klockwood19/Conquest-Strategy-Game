package com.kyle.galactic_conquest.agents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

// NOTE THAT YOU MUST CREATE A UNIT_DICTIONARY IN THE MAIN METHOD OR YOU GET AN INPUT EXCEPTION ERROR

public class Unit_Dictionary {
	
	private Hashtable<String,ArrayList<Integer>> unit_dictionary = new Hashtable<String, ArrayList<Integer>>();
	@SuppressWarnings("rawtypes")
	private ArrayList<ArrayList> unit_list = new ArrayList<ArrayList>();
	
	/**
	 * The constructor opens and reads the csv file containing all units and their statistics. 
	 * It then loads these unit names and statistics into a hashtable: unit_dictionary, which 
	 * is organized by key:value --> unit_name:statistics where unit_name is a string corresponding
	 * to the unit name, and statistics is a list of integers.
	 * @throws IOException
	 */
	public Unit_Dictionary() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("/C:/Galactic_Conquest/units.csv"));
		String line = null;
		while((line = reader.readLine()) != null) {
			ArrayList<String> one_line = new ArrayList<String>();
			one_line.add(line);
			this.unit_list.add((ArrayList<String>) one_line);
		}
		int line_num = 0;
		for(ArrayList<?> a : this.unit_list) {
			if(line_num == 0) {}
			else {
				String[] b = ((String) a.get(0)).split(",");
				ArrayList<Integer> stats = new ArrayList<Integer>();
				String name = null;
				for(int n = 0; n < b.length; n = n + 1) {
					if(n == 0) {name = (String) b[n];}
					else {
						stats.add(Integer.parseInt(b[n]));
					}
				}
				unit_dictionary.put(name, stats);
			}
			line_num = 1;
		}
	}
	

	public Hashtable<String, ArrayList<Integer>> getUnit_dictionary() {
		return unit_dictionary;
	}

	public void setUnit_dictionary(Hashtable<String,ArrayList<Integer>> unit_dictionary) {
		this.unit_dictionary = unit_dictionary;
	}
	
	public void display_units() {
		System.out.println(this.unit_dictionary);
	}

}
