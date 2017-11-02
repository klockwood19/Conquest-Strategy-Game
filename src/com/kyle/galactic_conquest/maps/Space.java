package com.kyle.galactic_conquest.maps;


import java.util.Set;


public class Space extends Vertex {
	
	private Set<String> _neighbors;
	private Set<String> _portNeighbors;
	private String _name;
	private Object _contents;
	private String _region;
	private String _allegiance;
	private String _capital;
	private String _fortress;
	private String _port;
	private int _pointValue;
	
	

	public Space(String name, Object contents) {
		super(contents);
		this.set_name(name);
		
	}
	
	public Set<String> get_neighbors() {
		return this._neighbors;
	}
	
	public void set_neighbors(Set<String> neighbors) {
		this._neighbors = neighbors;
	}

	public Set<String> get_portNeighbors() {
		return _portNeighbors;
	}

	public void set_portNeighbors(Set<String> _portNeighbors) {
		this._portNeighbors = _portNeighbors;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Object get_contents() {
		return _contents;
	}

	public void set_contents(Object _contents) {
		this._contents = _contents;
	}

	public String get_region() {
		return _region;
	}

	public void set_region(String _region) {
		this._region = _region;
	}

	public String get_allegiance() {
		return _allegiance;
	}

	public void set_allegiance(String _allegiance) {
		this._allegiance = _allegiance;
	}

	public String get_capital() {
		return _capital;
	}

	public void set_capital(String _capital) {
		this._capital = _capital;
	}

	public String get_fortress() {
		return _fortress;
	}

	public void set_fortress(String _fortress) {
		this._fortress = _fortress;
	}

	public String get_port() {
		return _port;
	}

	public void set_port(String _port) {
		this._port = _port;
	}

	public int get_pointValue() {
		return _pointValue;
	}

	public void set_pointValue(int _pointValue) {
		this._pointValue = _pointValue;
	}
	
	

}
