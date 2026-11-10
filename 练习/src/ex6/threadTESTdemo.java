package ex6;

import java.io.Serializable;
import java.util.*;


public class threadTESTdemo {
	 public static void main(String[] args) {
	        Storage storage = new Storage();//存储对象
	        Disptcher input=new Disptcher(storage);
	        input.start();
	        Inserter output=new Inserter(storage);
	        output.start();
	        //创建线程对象 调用开始函数
	    }
}

class Storage {
    private final int MAX_SIZE = 4; // 最大长度
    List<GeometricObject> geoMore=new ArrayList<GeometricObject>();
    List<GeometricObject> saveAll=new ArrayList<GeometricObject>();
    public Storage() {}
    
    public static Map<String,ArrayList>  sort(List<GeometricObject> geoMore){
        HashMap map=new HashMap();//sort函数，用于分类
        for(int i=0;i<geoMore.size();i++){
        	GeometricObject s=(GeometricObject)geoMore.get(i);
            if(map.containsKey(s.getname())){//
             ArrayList l11=(ArrayList)map.get(s.getname());
             l11.add(s);
            }else{
             ArrayList tem=new ArrayList();
                tem.add(s);
                map.put(s.getname(), tem);//map的添加函数将<key,value>键值对写入tem列表中
            } 
        }
        return map;
    }
    
    public void push() {
       synchronized (this) {
            // 容量不足，则等待
            while (geoMore.size()>MAX_SIZE) {
                System.out.println("产生图形量已经达到上限 \n");
                System.out.println("此时产生的图形量为："+geoMore.size());
                try {
                    wait(); // 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            //从此处开始进行随机添加
            int result=(new Random().nextInt(4))+1;
    		//System.out.println("\n"+result);
    	if(result==1)
    	{
    		System.out.print("添加圆");
    		geoMore.add(new Circle(new Random().nextInt(10)+1,"circle"));
    	}
    	else if(result==2)
    	{
    		System.out.print("添加矩形");
    		geoMore.add(new Rectangle(new Random().nextInt(10)+1,new Random().nextInt(10)+1,"Rectangle"));
    	}
    	else if(result==3)
    	{
    		System.out.print("添加三角形");
    		int a=0;int b=0;int c=0;
    		while(!((a+b)>c&&(a+c)>b&&(b+c)>a))
    		{
    		a=new Random().nextInt(50)+1;
    		b=new Random().nextInt(50)+1;
    		c=new Random().nextInt(50)+1;
    		}
    		geoMore.add(new Triangle(a,b,c,"Triangle"));
    	}
    	else if(result==4)
    	{
    		System.out.print("添加扇形");
    		geoMore.add(new Sector(new Random().nextInt(10)+1,new Random().nextInt(360)+1,"Sector"));
    	}
            
            System.out.println("\n此时图形量为："+geoMore.size());

            // 通知消费者消费 可以开始删除图形
           notify();
        }
    }

    
    public void pop() {
       synchronized (this) {
            // 库存量不足
            while ( geoMore.size()<=0) {
                System.out.println("集合中无对象");
                try {
                    wait(); // 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 消费条件满足 则消费图形 就是删除图形
            System.out.println("开始删除");
           System.out.println("删除的集合中的图形有："+geoMore);
           List<GeometricObject> removelist=new ArrayList<GeometricObject>();
           for(GeometricObject i:geoMore)//全部删除 删除之前存在removelist中
           {
        	   //HashMap map=new HashMap();
        	   removelist.add(i);
           }
           saveAll.addAll(removelist);
           
          System.out.println("显示所有被删除的"+saveAll);
          
          //下面进行分类
          Map<String,ArrayList> ss =sort(saveAll);
          Iterator it = ss.keySet().iterator();//迭代器
          //keyset:此映射中包含的键的集合视图
          while(it.hasNext()){
          	//System.out.println("key的值是："+it.hasNext()+"中止");
           String key = (String)it.next();
           
           System.out.print("\n"+key+":\n");
           ArrayList list1 = ss.get(key);
           
      	 //Collections.sort(list1,new AreaComparator());
      	 //实现ComParator接口，来对ArrayList列表中的图形进行排序，其中重写方法的时候，实现的就是图形之间面积的比较
           for(int i=0; i<list1.size(); i++){
          	 GeometricObject sb = (GeometricObject)list1.get(i);
            System.out.print(" "+sb.getname()+" "+sb.toString());
           }}
          //下面进行删除
           geoMore.removeAll(removelist);
            // 通知生产者生产
            notify();
        }
    }
}
class Disptcher extends Thread implements Runnable{
	
	 private Storage storage; 

	    public Disptcher(Storage storage) {
	        this.storage = storage;
	       // new Thread(this).start();
	    }
			public void run() {
				
				 while (true) {
	    	        	System.out.println("消费者名字："+Thread.currentThread().getName());
	    	            storage.pop(); 
	    	            try {
	    	                Thread.sleep((int) (Math.random() * 1000));
	    	            } catch (InterruptedException e) {
	    	                e.printStackTrace();
	    	            }
	    	        }
				
				
		      
		    }
	}



class Inserter extends Thread implements Runnable{
	private Storage storage; // 消费时从仓库中获取资源

    public Inserter(Storage storage) {
        this.storage = storage;
        //new Thread(this).start();
    }
    	    public void run() {
    	    	  while (true) {
  		        	System.out.println("生产者名字："+Thread.currentThread().getName());
  		            storage.push(); 

  		            try {
  		                Thread.sleep((int) (Math.random() * 1000));
  		            } catch (InterruptedException e) {
  		                e.printStackTrace();
  		            }
  		        }
}
}
//在其下加入一些图形类创建的类
	//矩形，三角形，扇形，圆形
	abstract class GeometricObject {//抽象类,
		//声明面积和周长，抽象函数
		public abstract double getArea();
		public abstract String getname();
		public abstract double getPerimeter();
	}
	class Circle extends GeometricObject implements Serializable{  //圆形	private double radius;
		
		private double radius;
		private String name;
		public Circle(double r,String na) {
			this.radius=r;
			this.name=na;
		}
		public String getname()
		{
			return this.name;
		}
	    public double getArea()
		{
			return Math.PI*radius*radius;
		}
		public double getPerimeter()
		{
			return 2*Math.PI*radius;
		}
		public String toString()//重写toString()函数，输出数据成员覆盖java.lang.Object.toString
		{
			return " circle:\nradius: "+radius+"\n";
		}
		class CircleAreaComparator implements Comparator{

			@Override
			public int compare(Object o1, Object o2) {
				if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
				{
					return -1;
				}
				else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
				{
					return 1;
				}else
				{
					return 0;
				}
			}
		}
	}
	class Rectangle extends GeometricObject implements Serializable{//矩形
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
		
		class RectangleAreaComparator implements Comparator{

			@Override
			public int compare(Object o1, Object o2) {
				if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
				{
					return -1;
				}
				else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
				{
					return 1;
				}else
				{
					return 0;
				}
			}
		}
	}


	class Sector extends GeometricObject implements Serializable{//矩形
		private String name;
		private double radius;
		private double Angle;
		public Sector() {}
		public Sector(double r,double ang,String na) {
			this.radius=r;
			this.Angle=ang;
			this.name=na;
		}
		public String getname()
		{
			return this.name;
		}
		public double getArea()
		{
			double ar=(Angle/360)*(3.14*radius*radius);
			return ar;
		}
		public double getPerimeter()
		{
			double zhou=(Angle/360)*(3.14*radius*2);
			return zhou;
		}
		public String toString()//输出数据成员
		{
			return "Sector:\nradius:"+radius+"\nAngle:"+Angle+"\n";
		}
		
		class SectorAreaComparator implements Comparator{

			@Override
			public int compare(Object o1, Object o2) {
				if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
				{
					return -1;
				}
				else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
				{
					return 1;
				}else
				{
					return 0;
				}
			}
		}
	}

	class Triangle  extends GeometricObject implements Serializable{//三角形
		String name;
		private double edgea;
		private double edgeb;
		private double edgec;
		public Triangle(double a,double b,double c,String na) {//构造函数
			this.edgea=a;
			this.edgeb=b;
			this.edgec=c;
			this.name=na;
		}
		public String getname()
		{
			return this.name;
		}
	    public double getArea()
		//利用海伦公式计算已知三角形三边，从而计算三角形面积
		{
			double p=(edgea+edgeb+edgec)/2;
			return Math.sqrt(p*(p-edgea)*(p-edgeb)*(p-edgec));
		}
		public double getPerimeter()
		{
			return edgea+edgeb+edgec;
		}
		public String toString()//输出数据成员
		{
			return "triangle:\nedgea: "+edgea+"\nedgeb: "+edgeb+"\nedgec: "+edgec+"\n";
		}
		
		class TriangleAreaComparator implements Comparator{

			@Override
			public int compare(Object o1, Object o2) {
				if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
				{
					return -1;
				}
				else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
				{
					return 1;
				}else
				{
					return 0;
				}
			}
		}
	}
	
	class AreaComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
			{
				return -1;
			}
			else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
			{
				return 1;
			}else
			{
				return 0;
			}
		}
	}
