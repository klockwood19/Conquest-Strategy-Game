package com.kyle.galactic_conquest.app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Territory extends Polygon{
	
	private int[] _xValues;
	private int[] _yValues;
	private Polygon _territory;
	private ArrayList<String> _identifier;
	private String _region;
	private int[] _labelCoords;
	private Image _symbol;
	
	public Territory(int[] xValues, int[] yValues, int[] labelCoords, ArrayList<String> identifier, String region, BufferedImage symbol) {
		
		_xValues = xValues;
		_yValues = yValues;
		_territory = new Polygon(_xValues, _yValues, _yValues.length);
		_identifier = identifier;
		_region = region;
		set_symbol(symbol);
		set_labelCoords(labelCoords);
		
		
	}
	
	public String getRegion() {
		return this._region;
	}
	
	public void setRegion(String s) {
		this._region = s;
		this._identifier.set(1, s);
	}
	
	public Polygon getTerritory() {
		return this._territory;
	}
	
	public void setTerritory(Polygon p) {
		_territory = p;
	}
	
	public void colorPolygon(Color c, Graphics2D g) {
		g.setColor(java.awt.Color.BLACK);
		g.setStroke(new BasicStroke(4));
		if (c.equals(java.awt.Color.BLACK)) {
			g.setColor(java.awt.Color.WHITE);
		}
		g.drawPolygon(_territory);
		g.setColor(c);
		g.fillPolygon(_territory);
	}
	
	public void clearTerritory() {
		this._territory.reset();
	}
	
	public int[] getXValues() {
		return this._xValues;
	}
	
	public void displayXValues() {
		for (int x : _xValues) {
			System.out.println(x);
		}
	}
	
	public void setXValues(int[] values) {
		this._xValues = values;
	}
	
	public int[] getYValues() {
		return this._yValues;
	}
	
	public ArrayList<String> getId() {
		return this._identifier;
	}

	public int[] get_labelCoords() {
		return _labelCoords;
	}

	public void set_labelCoords(int[] _labelCoords) {
		this._labelCoords = _labelCoords;
	}

	public Image get_symbol() {
		return _symbol;
	}

	public void set_symbol(Image _symbol) {
		this._symbol = _symbol;
	}

}
