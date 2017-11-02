package com.kyle.galactic_conquest.maps;


import java.util.Set;

public class Vertex {
	
	private Object _data;
	private Set<Vertex> _neighbors;
	
	public Vertex(Object data) {
		
		this._data = data;
		
	}
	
	private void add_neighbor(Vertex v) {
		
		_neighbors.add(v);
		v._neighbors.add(this);
		
	}
	
	void _remove() {
		
		for (Vertex v : _neighbors) {
			v._neighbors.remove(this);
			this._neighbors.remove(v);
		}
		
	}
	
	private void remove_neighbor(Vertex v) { // remove a single neighbor, and remove self as a neighbor from that vertex.
		
		_neighbors.remove(v);
		v._neighbors.remove(this);
		
	}
	
	

}
