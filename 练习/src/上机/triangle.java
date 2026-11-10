package 上机;

import java.util.Arrays;

public class triangle extends GeometricObject implements Comparable<triangle>{
	int a;  //三角形的底
	int b;  //三角形的高
	int c;  
	int d;  //其余两边
	public triangle(int aa,int bb,int cc,int dd) {
		super.name = "triangle";
		this.a = aa;
		this.b = bb;
		this.c = cc;
		this.d = dd;
	}
	public double area() {
		return (a*b)/2;
	}
	public int perimeter() {
		return a+c+d;
	}
	@Override
	public String toString() {
		return "名称："+name+"\n"+"三边分别为："+a+" "+c+" "+d+" ;高为："+b+"\n"+"周长为："+perimeter()+"\n"+"面积为："+area();
	}
    @Override
    	public int compareTo(triangle c) {
    		if(this.b > c.b)
    			return 1;
    		else if(this.b < c.b)
    			return -1;
    		else
    			return 0;
    }

    public static void main(String[] args) {
    		triangle[] t = new triangle[3];
    		t[0] = new triangle(3,2,3,4);
    		t[1] = new triangle(4,1,3,3);
    		t[2] = new triangle(1,4,5,2);
    		Arrays.sort(t);
    		for(int i=0;i<3;i++)
    			System.out.println(t[i].toString());
    }
}
