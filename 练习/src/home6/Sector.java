package home6;

import java.io.Serializable;

public class Sector extends GeometricObject implements Serializable {

	private String name;
	private double radius;
	private double Angle;
	public Sector() {}
	public Sector(double r,double ang,String na) {
		this.radius=r;
		this.Angle=ang;
		this.name=na;
	}
	public String getname()
	{
		return this.name;
	}
	public double getArea()
	{
		double ar=(Angle/360)*(3.14*radius*radius);
		return ar;
	}
	public double getPerimeter()
	{
		double zhou=(Angle/360)*(3.14*radius*2);
		return zhou;
	}
	public String toString()//输出数据成员
	{
		return "Sector:\nradius:"+radius+"\nAngle:"+Angle+"\n";
	}
	

}
