package com.gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Geo implements GeoTransformation, GeoMoving{
	Color color = new Color(0,0,0);
	protected int x; 	//protected可在子类中使用
	protected int y;
	public Geo() {}
	public Geo(Color c) {
		color =  c;
	}
	public Geo(int x, int y, Color c) {
		color = c; this.x = x; this.y = y;
	}
	public abstract void draw(Graphics g);
	@Override
	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}
	@Override
	public void toRight(int x) {
		this.x += x;
	}
	@Override
	public void toLeft(int x) {
		this.x -= x;
	}
	@Override
	public void toUp(int y) {
		this.y -= y;
	}
	@Override
	public void toDown(int y) {
		this.y += y;
	}
}