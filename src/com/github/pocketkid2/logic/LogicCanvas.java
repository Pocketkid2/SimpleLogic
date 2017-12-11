package com.github.pocketkid2.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class LogicCanvas extends JPanel implements MouseListener {
	
	// For completeness
	private static final long serialVersionUID = -2199087572689809886L;
	
	private List<Shape> shape;
	
	// Perform panel setup here
	public LogicCanvas() {
		
		setBackground(Color.LIGHT_GRAY);
		
		shape = new ArrayList<Shape>();
		
		addMouseListener(this);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		// For completeness
		super.paintComponent(g);
		
		// The 2D version has more stuff
		Graphics2D g2d = (Graphics2D) g;

		for (Shape s : shape) {
			g2d.fill(s);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Shape s;

		switch (LogicPalette.selection) {
			case CIRCLE:
				s = new Ellipse2D.Double(e.getX() - 25, e.getY() - 25, 50, 50);
				break;
			case SQUARE:
				s = new Rectangle2D.Double(e.getX() - 25, e.getY() - 25, 50, 50);
				break;
			case TRIANGLE:
				s = new Path2D.Double();
				((Path2D) s).moveTo(e.getX(), e.getY() - 25);
				((Path2D) s).lineTo(e.getX() - 25, e.getY() + 25);
				((Path2D) s).lineTo(e.getX() + 25, e.getY() + 25);
				break;
			default:
				return;
			
		}
		
		shape.add(s);
		repaint();
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
