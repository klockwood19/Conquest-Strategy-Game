package com.kyle.galactic_conquest.app;

import javax.swing.*;

import com.kyle.galactic_conquest.maps.GameOfThrones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;


public class ShapesPanel extends JPanel implements MouseListener{
    private Color _color;
    private GameOfThrones _got;
    private ArrayList<Territory> _territories = new ArrayList<Territory>();
    
    // Constructor iterates through Game of thrones map, constructing all territories and adding them to the territories list.
    public ShapesPanel() {
    	_territories = new ArrayList<Territory>();
    	_got = new GameOfThrones();
    	ArrayList<ArrayList<String>> territories = Collections.list(_got.getTerritories().keys());
    	
    	for (ArrayList<String> territory : territories) {
    		ArrayList<int[]> coords = (ArrayList<int[]>) _got.getTerritories().get(territory);
        	int[] xPoints = coords.get(0);
        	int[] yPoints = coords.get(1);
        	String region = territory.get(1);
            Territory terr = new Territory(xPoints,yPoints, territory, region);
            _territories.add(terr);
    		
    	}
    	addMouseListener(this);
    }
    
    
    
    // Paint map using modified paintComponent method. This is called automatically. Goes through territories list and paints them.  
    public void paintComponent(java.awt.Graphics aBrush) {
        super.paintComponent(aBrush);
        java.awt.Graphics2D aBetterBrush = (java.awt.Graphics2D) aBrush;
        this.setOpaque(true);
        Color c = new Color(110,113,171);
        this.setBackground(c);
        
        // Create new GameOfThrones object which has map details. Store territories in a list
        this._got = new GameOfThrones();
    	ArrayList<ArrayList<String>> territories = Collections.list(_got.getTerritories().keys());
    	
    	// Iterate over all territories in the map dictionary, add them to the map, add mouse listener, and color them appropriately
    	for (Territory territory : this._territories) {
    		
    		this._color = (Color) _got.getRegionalColors().get(territory.getRegion());
            territory.colorPolygon(_color, aBetterBrush);
            
//             //Use to scale the size of the image
//            AffineTransform saveTransform = aBetterBrush.getTransform();
//            try {
//                AffineTransform scaleMatrix = new AffineTransform();
//                scaleMatrix.scale(2, 2);
//                
//
//                aBetterBrush.setTransform(scaleMatrix);
//                _territory.colorPolygon(_color, aBetterBrush);
//            } finally {
//                aBetterBrush.setTransform(saveTransform);
//            }
            
    		
    	}

        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	//System.out.println("the length of territories is " + this._territories.size());
    	for (Territory territory: this._territories) {
    		if(territory.getTerritory().contains(e.getX(), e.getY())) {
    			territory.setRegion("The Westerlands");
    	    	this.repaint();
    	    	break;
    		}
    	}
    	this.translateMap(0, 20);
    }
    
    public void translateMap(int x, int y) {
    	
    	
    	for (Territory t : this._territories) {
    		
    		t.getTerritory().translate(x, y);
    	
    		
    	}
    	this.repaint();
    }
    
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
