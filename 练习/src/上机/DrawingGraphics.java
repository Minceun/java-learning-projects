package 上机;
import java.lang.String;
public class DrawingGraphics {
	public GeometricObject[] geometries; //包含各种图形
	public void add(int num,GeometricObject a) {
		// TODO Auto-generated constructor stub
		geometries[num] = a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeometricObject a = new triangle(1,2,3,4);
		GeometricObject b = new rectangle(2,3);
		GeometricObject c = new circle(4);
		DrawingGraphics graph = new DrawingGraphics();
		graph.add(0, a);
		graph.add(1, b);
		graph.add(2, c);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}
}
