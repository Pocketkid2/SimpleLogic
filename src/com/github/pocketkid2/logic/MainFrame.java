package com.github.pocketkid2.logic;

import java.awt.EventQueue;

import javax.swing.JFrame;

// Top level window container
public class MainFrame extends JFrame {
	
	// This removes eclipse warnings
	private static final long serialVersionUID = -7568131660030995565L;

	// Constructor for the frame
	public MainFrame() {
		initUI();
	}

	// Method to handle initialization
	private void initUI() {
		
		// Give ourselves a title
		setTitle("Simple logic");
		
		// And a starting size (can be resized)
		setSize(800, 600);
		
		// This will center the window
		setLocationRelativeTo(null);
		
		// And this will make sure the X button works correctly
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Program starts here
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			
			// Create an instance of the frame
			MainFrame mf = new MainFrame();
			
			// And make it visible on screen
			mf.setVisible(true);
		});
	}
	
}
