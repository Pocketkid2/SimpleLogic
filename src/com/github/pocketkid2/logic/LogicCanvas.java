package com.github.pocketkid2.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class LogicCanvas extends JPanel implements MouseListener {
	
	// For completeness
	private static final long serialVersionUID = -2199087572689809886L;
	
	private List<Ellipse2D> spots;
	
	// Perform panel setup here
	public LogicCanvas() {
		
		setBackground(Color.LIGHT_GRAY);
		
		spots = new ArrayList<Ellipse2D>();
		
		addMouseListener(this);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		// For completeness
		super.paintComponent(g);
		
		// The 2D version has more stuff
		Graphics2D g2d = (Graphics2D) g;

		for (Ellipse2D el : spots) {
			g2d.fill(el);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Ellipse2D el = new Ellipse2D.Double(e.getX() - 25, e.getY() - 25, 50, 50);
		spots.add(el);
		repaint();
		System.out.println("Clicked");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
