package com.gui;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class Triangle extends Geo {
	//int x1,y1,x2,y2;
		int a =50;
		int b =50;
		public Triangle(Color color, int aa, int bb) {
			super(color);
			a = aa; 
			b = bb;
		}
		public Triangle(int x, int y, Color color, int aa,int bb) {
			super(x, y, color);
			a = aa; 
			b = bb;
		
		}
		public void setLocation(int x, int y) {
			this.x = x; this.y = y;
		}
		@Override
		public void rotate(int x, int y, int radian) {
			
		}

		@Override
		public void scale(double xScale, double yScale) {
			this.a = (int) (this.a * xScale);
			this.b = (int) (this.b * yScale);
		}

		@Override
		public void draw(Graphics g) {
			Color tColor = g.getColor();
			g.setColor(this.color);
			Random r = new Random();
			//g.drawPolygon(new int[] {x1,x2,x2,x1},new int[]{y1,y1,y2,y2},4);
			//g.drawPolygon(new int[] {100,200,200,100},new int[] {100,100,300,300},4);	
			g.fillPolygon(new int[] {x+5*a,x-3*b,x-(2*a+b)/2},new int[] {y,y-b/2,y-(a+4*b)/2},3);
			//g.drawOval(this.x-radius, this.y-radius, 2*radius, 2*radius);	
			g.setColor(tColor);
		}
		public void setParams(int aa, int bb) {
			this.a  = aa;
			this.b  = bb;
		}
		/*
		public void setP1(int x, int y) {
			x1 = x; y1 = y;
		}
		public void setP2(int x, int y) {
			x2 = x; y2 = y;
		}*/
		public String toString() {
			return "Tri[a="+a+", b="+b+"]";
		}

}
