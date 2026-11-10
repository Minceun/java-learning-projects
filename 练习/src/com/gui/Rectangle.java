package com.gui;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Geo{
	//int x1,y1,x2,y2;
	int width;
	int height;
	public Rectangle(int x, int y, Color color, int w, int h) {
		super(x,y,color);
		width = w; height = h;
	}
	@Override
	public void rotate(int x, int y, int radian) {
		
	}

	@Override
	public void scale(double xScale, double yScale) {
		this.width = (int) (this.width * xScale);
		this.height = (int) (this.height * yScale);
	}

	@Override
	public void draw(Graphics g) {
		Color tColor = g.getColor();
		g.setColor(this.color);
		//g.drawPolygon(new int[] {x1,x2,x2,x1},new int[]{y1,y1,y2,y2},4);
		//g.drawPolygon(new int[] {100,200,200,100},new int[] {100,100,300,300},4);	
		g.fillRect(x-width/2,y-height/2,width,height);
		g.setColor(tColor);
	}
	public void setParams(int w, int h) {
		this.width  = w;
		this.height  = h;
	}
	/*
	public void setP1(int x, int y) {
		x1 = x; y1 = y;
	}
	public void setP2(int x, int y) {
		x2 = x; y2 = y;
	}*/
	public String toString() {
		return "Rect[width="+width+", height="+height+"]";
	}
}