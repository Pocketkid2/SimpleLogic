package com.github.pocketkid2.logic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class LogicMain extends JFrame {
	
	// For completeness
	private static final long serialVersionUID = 467559411097471576L;

	// Perform frame setup here
	public LogicMain() {

		createMenuBar();
		createToolBar();
		
		LogicCanvas lc = new LogicCanvas();

		add(lc);
		
		pack();
		
		// Give it a name and a preferred size
		setTitle("Simple Logic");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		
	}
	
	private void createMenuBar() {

		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		bar.add(file);
		setJMenuBar(bar);
	}
	
	private void createToolBar() {
		
		JToolBar bar = new JToolBar();
		JButton circle = new JButton("Circle");
		JButton square = new JButton("Square");
		JButton triangle = new JButton("Triangle");
		
		bar.add(circle);
		bar.add(square);
		bar.add(triangle);
		
		circle.addActionListener(e -> LogicPalette.selection = LogicPalette.SHAPE.CIRCLE);
		square.addActionListener(e -> LogicPalette.selection = LogicPalette.SHAPE.SQUARE);
		triangle.addActionListener(e -> LogicPalette.selection = LogicPalette.SHAPE.TRIANGLE);
		
		this.add(bar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		
		LogicPalette.selection = LogicPalette.SHAPE.CIRCLE;

		// Pass a lambda expression
		EventQueue.invokeLater(() -> {

			// Create an instance of the frame
			LogicMain main = new LogicMain();

			// And make it alive!
			main.setVisible(true);
		});
	}

}
