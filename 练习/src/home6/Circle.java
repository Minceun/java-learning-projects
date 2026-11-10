package home6;

import java.io.Serializable;

class Circle extends GeometricObject implements Serializable{  //圆形	private double radius;
	
	private double radius;
	private String name;
	public Circle(double r,String na) {
		this.radius=r;
		this.name=na;
	}
	public String getname()
	{
		return this.name;
	}
    public double getArea()
	{
		return Math.PI*radius*radius;
	}
	public double getPerimeter()
	{
		return 2*Math.PI*radius;
	}
	public String toString()//重写toString()函数，输出数据成员覆盖java.lang.Object.toString
	{
		return " circle:\nradius: "+radius+"\n";
	}
	class CircleAreaComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
			{
				return -1;
			}
			else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
			{
				return 1;
			}else
			{
				return 0;
			}
		}
	}
}