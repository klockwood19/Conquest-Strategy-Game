package com.kyle.galactic_conquest.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic extends JPanel implements MouseListener {

    private Line2D line2d;
    private Polygon pol;
    private Graphics2D _g2;
    

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.getContentPane().add(new Graphic());
        frame.pack();
        frame.setVisible(true);
    }

    public Graphic(){

        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        _g2 = (Graphics2D) g;
        _g2.setColor(Color.gray);
        _g2.setStroke(new BasicStroke(2.0F));
        int northBorderX[] = {334, 395, 404, 423, 496, 521};
        int topBorderY[] = {261, 276, 274, 284, 292, 306};
        int xPoints[] = {334, 395, 404, 423, 496, 521, 536, 533, 534, 541, 544, 504, 461, 417, 399, 396, 377, 354, 331, 338};
        int yPoints[] = {261, 276, 274, 284, 292, 306, 375, 383, 393, 396, 409, 403, 421, 431, 433, 404, 385, 363, 341, 291};
        pol = new Polygon(xPoints, yPoints, yPoints.length);
        _g2.draw(pol);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (pol.contains(e.getX(), e.getY())) {
        	_g2.setColor(Color.black);
        	_g2.fillPolygon(pol);
        	_g2.draw(pol);
        	System.out.println("clicked");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}