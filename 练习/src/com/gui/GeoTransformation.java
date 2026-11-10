package com.gui;

public interface GeoTransformation {
	void translate(int x, int y);
	void rotate(int x, int y, int radian);
	void scale(double xScale, double yScale);
}
