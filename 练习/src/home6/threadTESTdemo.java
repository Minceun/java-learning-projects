package home6;

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