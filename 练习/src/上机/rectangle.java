package 上机;

import java.lang.String;
public class rectangle extends GeometricObject {
	int a;  //矩形的长
	int b;  //矩形的宽
	
	public rectangle(int aa,int bb) {
		name = "rectangle";
		a = aa;
		b = bb;
	}
	public double area() {
		return a*b;
	}
	
	public int perimeter() {
		return a+a+b+b;
	}
	@Override
	public String toString() {
		return "名称："+name+"\n"+"长和宽分别为："+a+" "+b+"\n"+"周长为："+perimeter()+"\n"+"面积为："+area();
	}
}
