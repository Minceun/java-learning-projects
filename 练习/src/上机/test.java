package 上机;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		circle[] c = new circle[3];
		c[0] = new circle(3);
		c[1] = new circle(4);
		c[2] = new circle(1);
		Arrays.sort(c,new AreaComparator1());
		for(int i=0;i<3;i++)
		    System.out.println(c[i].toString());
		
		System.out.println();
		triangle[] t = new triangle[3];
		t[0] = new triangle(3,6,5,5);
		t[1] = new triangle(5,8,5,9);
		t[2] = new triangle(1,5,4,4);
		Arrays.sort(c,new AreaComparator1());
		for(int i=0;i<3;i++)
		    System.out.println(c[i].toString());
	}
}