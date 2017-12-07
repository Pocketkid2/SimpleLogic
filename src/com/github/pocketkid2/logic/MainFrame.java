package com.github.pocketkid2.logic;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	// This removes eclipse warnings
	private static final long serialVersionUID = -7568131660030995565L;
	
	// Constructor for the frame
	public MainFrame() {
		initUI();
	}
	
	// Method to handle initialization
	private void initUI() {

		setTitle("Simple logic");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Program starts here
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			MainFrame mf = new MainFrame();
			mf.setVisible(true);
		});
	}

}
