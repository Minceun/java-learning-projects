package com.gui;

import java.awt.Color;
import java.awt.Graphics;
public class Sector extends Geo {
	int radius;
	int angle;
	public Sector(Color c, int r, int an) {
		super(c);
		radius = r;
		angle = an;
	}
	public Sector(int x, int y, Color c, int r, int an) {
		super(x, y, c);
		radius = r;
		angle = an;
	}
	public void setLocation(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	@Override
	public void draw(Graphics g) {
		Color tColor = g.getColor();
		g.setColor(this.color);
		//g.drawOval(this.x-radius, this.y-radius, 2*radius, 2*radius);	       //daiding
		g.fillArc(x/6, y/6, 2*radius, 2*radius, 90, 60);
		g.setColor(tColor);
	}
	@Override
	public void rotate(int x, int y, int radian) {
		
	}
	@Override
	public void scale(double xScale, double yScale) {//yScale means nothing to a circle.
		this.radius = (int)(this.radius * xScale);
	}
	public String toString() {
		return "Sector[radius="+radius+", angle="+angle+"]";
	}
}
