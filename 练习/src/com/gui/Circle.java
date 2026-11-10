package com.gui;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geo{
	int radius;
	public Circle(Color c, int r) {
		super(c);
		radius = r;
	}
	public Circle(int x, int y, Color c, int r) {
		super(x, y, c);
		radius = r;
	}
	public void setLocation(int x, int y) {
		this.x = x; this.y = y;
	}
	@Override
	public void draw(Graphics g) {
		Color tColor = g.getColor();
		g.setColor(this.color);
		g.fillOval(this.x-radius, this.y-radius, 2*radius, 2*radius);	
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
		return "Circle[radius="+radius+"]";
	}
	public void setParams(int r) {
		this.radius  = r;
	}
}
