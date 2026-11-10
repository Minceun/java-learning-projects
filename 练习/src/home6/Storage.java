package home6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Storage {
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
          Iterator it = (Iterator) ss.keySet().iterator();//迭代器
          //Gayest:此映射中包含的键的集合视图
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