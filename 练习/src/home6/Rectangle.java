package home6;

public class Rectangle extends GeometricObject implements Serializable{//矩形
		private String name;
		private double length;
		private double width;
		public Rectangle() {}
		public Rectangle(double l,double w,String na) {
			this.length=l;
			this.width=w;
			this.name=na;
		}
		public String getname()
		{
			return this.name;
		}
		public double getArea()
		{
			return length*width;
		}
		public double getPerimeter()
		{
			return 2*(length+width);
		}
		public String toString()//输出数据成员
		{
			return "rectangle:\nlength:"+length+"\nwidth: "+width+"\n";
		}
		
}
