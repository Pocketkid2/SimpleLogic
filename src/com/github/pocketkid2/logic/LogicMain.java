package com.github.pocketkid2.logic;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class LogicMain extends JFrame {

	// For completeness
	private static final long serialVersionUID = 467559411097471576L;
	
	// Perform frame setup here
	public LogicMain() {

		LogicCanvas lc = new LogicCanvas();
		
		add(lc);

		pack();

		// Give it a name and a preferred size
		setTitle("Simple Logic");
		setSize(1600, 900);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		
		// Pass a lambda expression
		EventQueue.invokeLater(() -> {
			
			// Create an instance of the frame
			LogicMain main = new LogicMain();
			
			// And make it alive!
			main.setVisible(true);
		});
	}
	
}
