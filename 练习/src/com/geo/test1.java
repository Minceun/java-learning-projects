package com.geo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
目标：体会并掌握Java集合框架类的使用，掌握文件流使用的一般过程，掌握异常处理的使用 
内容 
（1）编写程序，随机创建至少10个图形对象（圆形、矩形、三角形、扇形等），图形由ArrayList管理（或使用第4次上机的图形管理类） 
（2）根据图形的类型进行分类，分类结果写入HashMap>，如map.put("Circle", new ArrayList()) 
（3）对每一种分类中的图形按照面积进行排序 
（4）所有图形信息写入文件保存，并可以再次读取并显示所有图形信息，或直接在第4次上机中的绘图程序中显示
 */

public class test1 {
	public static void main(String[] args) {
		ArrayList<Object> List = new ArrayList<Object>(); //存放建立的图形
		//随机建立图形
		for (int i=0;i<10;i++){
			int number = new Random().nextInt(4);
			switch(number) {
				case 0:
					Circle c = new Circle();
					List.add(c);
					break;
				case 1:
					Rectangle r = new Rectangle();
					List.add(r);
					break;
				case 2:
					Triangle t = new Triangle();
					List.add(t);
					break;
				case 3:
					Sector s = new Sector();
					List.add(s);
					break;
			}
		}
		
		//分类
		HashMap<String,ArrayList> map = new HashMap<String,ArrayList>();
		ArrayList<Circle> circuleList = new ArrayList<Circle>();
		ArrayList<Triangle> triangleList = new ArrayList<Triangle>();
		ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
		ArrayList<Sector> sectorList = new ArrayList<Sector>();
		for(int i=0;i<List.size();i++) {
			Geo g = (Geo)List.get(i);
			if(g.getName()=="圆形") {
				circuleList.add((Circle)g);
			}
			if(g.getName()=="三角形") {
				triangleList.add((Triangle)g);
			}
			if(g.getName()=="矩形") {
				rectangleList.add((Rectangle)g);
			}
			if(g.getName()=="扇形") {
				sectorList.add((Sector)g);
			}
		}
		map.put("Circle", circuleList);
		map.put("Triangle", triangleList);
		map.put("Rectangle", rectangleList);
		map.put("Sector", sectorList);
		
		//按面积排序
		Collections.sort(map.get("Circle"), new AreaComparator());
		Collections.sort(map.get("Triangle"), new AreaComparator());
		Collections.sort(map.get("Rectangle"), new AreaComparator());
		Collections.sort(map.get("Sector"), new AreaComparator());
		for(int i=0;i<circuleList.size();i++) {
			System.out.println(circuleList.get(i).toString());
		}
		for(int i=0;i<triangleList.size();i++) {
			System.out.println(triangleList.get(i).toString());
		}
		for(int i=0;i<rectangleList.size();i++) {
			System.out.println(rectangleList.get(i).toString());
		}
		for(int i=0;i<sectorList.size();i++) {
			System.out.println(sectorList.get(i).toString());
		}
		
		//写入文件
			try {
		      	FileOutputStream fout = new FileOutputStream("Geo.txt");
			    ObjectOutputStream sout = new  ObjectOutputStream(fout);
			    sout.writeObject(List);
			    sout.close();
			    fout.close();
		    }catch(IOException e) {
			    e.printStackTrace();
		    }
		
		//读出文件
			try {
				FileInputStream fout=new FileInputStream("Geo.txt");
				ObjectInputStream sout=new ObjectInputStream(fout);
				@SuppressWarnings("unchecked")
				ArrayList<Geo> n=(ArrayList<Geo>)sout.readObject();
				sout.close();
				fout.close();
				System.out.println(n.toString());
			}catch(IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
	}
}
