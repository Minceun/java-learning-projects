package com.geo;
import java.util.Comparator;

class AreaComparator implements Comparator<Object>{
	public int compare(Object o1,Object o2) {
		Geo a=(Geo) o1;
		Geo b=(Geo) o2;
		if(a.Area()>b.Area()) {
			return 1;
			}
		if(a.Area()<b.Area()) {
			return -1;
		}
		return 0;
	}
}
