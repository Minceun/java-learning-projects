package com.geo;

import java.util.Random;

public class Sector extends Geo {
	private int radius;
	private int angle;
	public Sector() {
		name = "扇形";
		Random n = new Random();
		radius = n.nextInt(20)+1;
		angle = n.nextInt(359)+1;
	}
	@Override
	public double Area() {
		return ((radius*radius*3.14*angle)/180);
	}

	@Override
	public double Perimeter() {
		return (2*radius)+((radius*3.14*angle)/180);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String toString() {
		return "名称："+this.name+"\n"+"半径为："+this.radius+"\n"+"圆心角为："+angle+"\n"+"周长为："+this.Perimeter()+"\n"+"面积为："+this.Area();
	}
}
