package 上机;

import java.io.IOException;
import java.nio.CharBuffer;

public class ScannerAdapter extends ScannerObject implements Readable{

	public ScannerAdapter(int count) {
		super(count); //因为基类没有默认构造器所以必须添加
	}
	@Override
	public int read(CharBuffer cb) throws IOException{ //Scanner会调用传递这个方法    CharBuffer是Scanner类的内部成员buf 有Scanner传递进去
		String str="";
		for(int i=0;i<getCount();i++)
		   str+=nextString() ;
	    str+=' ' ;   //Scanner的next在遇到空字符或者 '\n'的时候结束扫描
        cb.put(str);
		return str.length();
	}

}
