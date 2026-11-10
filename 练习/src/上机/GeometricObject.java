/*(1)改写第2次上机的GeometricObject类及其子类 
 * a)改写抽象类，将计算面积和计算周长的方法改写为抽象方法； 
 * b)如前面的UML图，改写Circle和Triangle类实现Comparable接口（报告中重新绘制UML图）； 
 * c)如下页UML图，定义AreaComparator比较器，实现图形的面积比较功能；（可定义多个比较并定义为内部类) 
 * d)编写测试类（可定义为内部类）和测试方法：每种图形至少创建两个实例，根据图形面积进行排序，输出排序结果。 
 */
package 上机;
import java.util.Comparator;

public abstract class GeometricObject implements Comparator<Object>{
	public String name;
	public abstract double area();
	public abstract int perimeter(); 
	
	
	public double compareTo(double d1) {
		return this.area()>d1?1:0;
	}
	public int compare(Object o1, Object o2) {
		GeometricObject g1 = (GeometricObject) o1;
		GeometricObject g2 = (GeometricObject) o2;
		if(g1.compareTo(g2.area())>0)
			return -1; 
		if(g1.compareTo(g2.area())<0)
			return 1; 
		return 0;
	}
}
