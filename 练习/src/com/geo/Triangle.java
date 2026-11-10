package com.geo;

import java.util.Random;

public class Triangle extends Geo {
	private int a;
	private int b;
	private int c;
	public Triangle() {
		name = "三角形";
		boolean yn = true;
		while(yn) {
			Random n = new Random();
			a = n.nextInt(20)+1;
			b = n.nextInt(20)+1;
			c = n.nextInt(20)+1;
			if(a+b>c && a+c>b && b+c>a) {
			    yn=false;
			}
		}
	}

	@Override
	public double Area() {
		double p=(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public double Perimeter() {
		// TODO Auto-generated method stub
		return a+b+c;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String toString() {
		return "名称："+this.name+"\n"+"三边分别为："+this.a+" "+this.b+" "+this.c+"\n"+"周长为："+Perimeter()+"\n"+"面积为："+Area();
	}

}
