package home6;

import java.io.Serializable;

public class Triangle extends GeometricObject implements Serializable {
	String name;
	private double edgea;
	private double edgeb;
	private double edgec;
	public Triangle(double a,double b,double c,String na) {//构造函数
		this.edgea=a;
		this.edgeb=b;
		this.edgec=c;
		this.name=na;
	}
	public String getname()
	{
		return this.name;
	}
    public double getArea()
	//利用海伦公式计算已知三角形三边，从而计算三角形面积
	{
		double p=(edgea+edgeb+edgec)/2;
		return Math.sqrt(p*(p-edgea)*(p-edgeb)*(p-edgec));
	}
	public double getPerimeter()
	{
		return edgea+edgeb+edgec;
	}
	public String toString()//输出数据成员
	{
		return "triangle:\nedgea: "+edgea+"\nedgeb: "+edgeb+"\nedgec: "+edgec+"\n";
	}

}
