package com.github.pocketkid2.logic;

import java.awt.Shape;
import java.util.List;

public class Logic {
	
	private static Logic singleton = new Logic();
	
	private static Logic getInstance() {
		return singleton;
	}

	private List<Shape> shapes;

	public List<Shape> getShapes() {
		return shapes;
	}
}
