package 上机;
import java.util.Comparator;
public class AreaComparator1 implements Comparator<circle>{
	@Override
	public int compare(circle c0, circle c1) {
		if(c0.area() > c1.area())
			return 1;
		else if(c0.area() < c1.area())
			return -1;
		else
			return 0;
	}
}
