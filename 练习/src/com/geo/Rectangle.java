package com.geo;

import java.util.Random;

public class Rectangle extends Geo {
	private int length;
	private int wideth;
	public Rectangle() {
		name = "矩形";
		Random n = new Random();
		length = n.nextInt(20)+1;
		wideth = n.nextInt(20)+1;
		if(length < wideth) {
			int temp = length;
			length = wideth;
			wideth = temp;
		}
	}
	@Override
	public double Area() {
		return length*wideth;
	}

	@Override
	public double Perimeter() {
		return (length+wideth)*2;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "名称："+this.name+"\n"+"长和宽分别为："+this.length+" "+this.wideth+"\n"+"周长为："+this.Perimeter()+"\n"+"面积为："+this.Area();
	}

}
