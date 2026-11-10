package 上机;

import java.util.Comparator;

public class AreaComparator2 implements Comparator<triangle> {
	@Override
	public int compare(triangle t0, triangle t1) {
		if(t0.area() > t1.area())
			return 1;
		else if(t0.area() < t1.area())
			return -1;
		else
			return 0;
	}
}
