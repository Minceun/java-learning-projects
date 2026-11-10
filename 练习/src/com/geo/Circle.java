package com.geo;

import java.util.Random;
public class Circle extends Geo {
	private int radius;
	public Circle() {
		name = "圆形";
		Random n = new Random();
		radius = n.nextInt(20)+1;
	}
	@Override
	public double Area() {
		return radius*radius*3.14;
	}
	@Override
	public double Perimeter() {
		return 6.28*radius;
	}

	@Override
	public String getName() {
		return name;
	}

	public String toString() {
		return "名称："+this.name+"\n"+"半径为："+this.radius+"\n"+"周长为："+this.Perimeter()+"\n"+"面积为："+this.Area();
	}

}
