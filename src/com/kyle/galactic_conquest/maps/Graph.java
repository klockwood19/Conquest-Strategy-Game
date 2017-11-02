package com.kyle.galactic_conquest.maps;


import java.util.Set;

public class Graph {
	
	private Set<Vertex> vertices;
	
	public Graph() {
		
	}
	
	private void add_vertex(Vertex v) {
		
		this.vertices.add(v);
		
	}
	
	private void remove_vertex(Vertex v) {
		v._remove();
	}
	

}
