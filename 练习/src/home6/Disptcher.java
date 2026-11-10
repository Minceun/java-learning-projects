package home6;

public class Disptcher extends Thread implements Runnable{

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

}
