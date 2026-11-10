package home6;

public Inserter extends Thread implements Runnable{
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
//在其下加入一些图形类创建的类
	//矩形，三角形，扇形，圆形
	abstract class GeometricObject {//抽象类,
		//声明面积和周长，抽象函数
		public abstract double getArea();
		public abstract String getname();
		public abstract double getPerimeter();
	}
}
