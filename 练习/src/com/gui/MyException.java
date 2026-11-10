package com.gui;

public class MyException extends Exception {
	public MyException() {
		super("圆的半径不能小于0");
	}
		public static class Circle{
		double r;
		public Circle(double r) throws MyException{
		if(r<0){
		throw new MyException();
		}
		this.r =r;
		}
		public static void main(String[] args) {
		try {
		Circle c=new Circle(-1);
		} catch (MyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
	}
}
