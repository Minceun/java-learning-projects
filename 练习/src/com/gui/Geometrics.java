package com.gui;

import java.awt.Graphics;

public class Geometrics{
	public static final int MAX = 10;
	public static int count = 0;
	public Geo[] geometrics = new Geo[MAX];
	public Geo add(Geo o) {
		if(count<MAX) {
			geometrics[count++] = o;
			return geometrics[count-1];
		}
		else {
			return null;
		}
	}
	public void draw(Graphics g) {
		for(Geo o: geometrics) {
			if(o != null) {
				o.draw(g);
			}
		}
	}
}