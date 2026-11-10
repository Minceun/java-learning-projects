package 上机;
import java.util.Arrays;
public class circle extends GeometricObject implements Comparable<circle>{
	private int r;  //圆的半径
	
	public circle(int rr) {
		super.name = "circle";
		this.r = rr;
	}
	public double area() {
		return Math.PI*r*r;
	}
	
	public int perimeter() {
		return  (int) ((int)2*Math.PI*r);
	}
	public String toString() {
		return "名称："+name+"\n"+"半径为："+r+"\n"+"周长为："+perimeter()+"\n"+"面积为："+area();
	}
	@Override
	public int compareTo(circle c) {
		// TODO Auto-generated method stub
		if(this.r > c.r)
			return 1;
		else if(this.r < c.r)
			return -1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		circle[] t = new circle[3];
		t[0] = new circle(3);
		t[1] = new circle(4);
		t[2] = new circle(1);
		Arrays.sort(t);
		for(int i=0;i<3;i++)
		    System.out.println(t[i].toString());
	}
}
