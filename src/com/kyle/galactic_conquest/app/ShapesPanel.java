package com.kyle.galactic_conquest.app;

import javax.swing.*;

import com.kyle.galactic_conquest.maps.GameOfThrones;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;


public class ShapesPanel extends JPanel implements MouseListener, KeyListener {
    private Color _color;
    private GameOfThrones _got;
    private ArrayList<Territory> _territories = new ArrayList<Territory>();
    private Boolean _transformMap = false;
    
    // Constructor iterates through Game of thrones map, constructing all territories and adding them to the territories list.
    public ShapesPanel() {
    	_territories = new ArrayList<Territory>();
    	_got = new GameOfThrones();
    	ArrayList<ArrayList<String>> territories = Collections.list(_got.getTerritories().keys());
    	
    	for (ArrayList<String> territory : territories) {
    		ArrayList<int[]> coords = (ArrayList<int[]>) _got.getTerritories().get(territory);
        	int[] xPoints = coords.get(0);
        	int[] yPoints = coords.get(1);
        	int[] labelCoords = coords.get(2);
        	String region = territory.get(1);
        	BufferedImage symbol = this._got.getSymbols().get(territory.get(1));
            Territory terr = new Territory(xPoints,yPoints, labelCoords, territory, region, symbol);
            _territories.add(terr);
    		
    	}
    	addMouseListener(this);
    	addKeyListener(this);
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
            Font font = new Font("Colonna MT", Font.BOLD, 15);
            aBetterBrush.setFont(font);
            aBetterBrush.setColor(java.awt.Color.BLACK);
            if (this._color.equals(java.awt.Color.BLACK)) {
            	aBetterBrush.setColor(java.awt.Color.WHITE);
            }
            
         // Draws territory symbols
            int[] labelCoords = territory.get_labelCoords();
            aBetterBrush.drawImage(territory.get_symbol(), labelCoords[0] + territory.getId().get(0).length()*4, labelCoords[1] - 50, null);
            
        // Draws territory labels. These values are updated by the translate function, and the labels are redrawn each time. 
            aBetterBrush.drawString(territory.getId().get(0), labelCoords[0], labelCoords[1]);
            //this.resizeMap(2, aBetterBrush, territory);
        
            
    		
    	}

        
    }
    
    // Use to scale the size of the image
    public void resizeMap(double scaleFactor, Graphics2D aBetterBrush, Territory territory) {
    	AffineTransform saveTransform = aBetterBrush.getTransform();
        try {
            AffineTransform scaleMatrix = new AffineTransform();
            scaleMatrix.scale(scaleFactor, scaleFactor);
            aBetterBrush.setTransform(scaleMatrix); 
            this._color = (Color) _got.getRegionalColors().get(territory.getRegion());
            territory.colorPolygon(_color, aBetterBrush);
            aBetterBrush.setColor(java.awt.Color.BLACK);
            int[] labelCoords = territory.get_labelCoords();
            aBetterBrush.drawString(territory.getId().get(0), labelCoords[0], labelCoords[1]);
        } finally {
            aBetterBrush.setTransform(saveTransform);
        }
    	
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	//System.out.println("the length of territories is " + this._territories.size());
    	for (Territory territory: this._territories) {
    		if(territory.getTerritory().contains(e.getX(), e.getY())) {
    			territory.setRegion("The North");
    			territory.set_symbol(_got.getSymbols().get("The North"));
    	    	this.repaint();
    	    	break;
    		}
    	}
    }
    
    // Function called for moving map
    public void translateMap(int x, int y) {
    	for (Territory t : this._territories) {
    		t.getTerritory().translate(x, y); 
    	}
    	// updates x and y values for the purpose of moving the territory labels
    	for (Territory t : this._territories) {
    		for (int i = 0; i < t.getXValues().length; i++) {
    			t.getXValues()[i] += x;
    			t.getYValues()[i] += y;
    		}
    		//System.out.println(t.getId() + " had its label coords changed from: " + t.get_labelCoords()[0] + ", " + t.get_labelCoords()[1] + " to");
    		t.get_labelCoords()[0] += x;
    		t.get_labelCoords()[1] += y;
    		//System.out.println(t.get_labelCoords()[0] + ", " + t.get_labelCoords()[1]);
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



	@Override
	public void keyPressed(KeyEvent k) {
		// Left key Arrow
		if (k.getKeyCode() == 37) {
			this.translateMap(-10,0);
		}
		
		// Up key Arrow
		if (k.getKeyCode() == 38) {
			this.translateMap(0,-10);	
		}
		
		// Right key Arrow
		if (k.getKeyCode() == 39) {
			this.translateMap(10,0);		
		}
		
		// Down key Arrow
		if (k.getKeyCode() == 40) {
			this.translateMap(0,10);		
		}
		
	}
	 
	// This method is necessary to get focus for the ShapesPanel Class. This focus is needed for KeyListener to work. 
	 public void addNotify() {
	        super.addNotify();
	        requestFocus();
	    }



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
