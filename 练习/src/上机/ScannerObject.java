package 上机;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;
public class ScannerObject {
	private char []charLow="abcdefghijklmnopqrstuvwxyz".toCharArray();
	private char []charUP="abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
	private int count ;
	private Random r=new Random(67) ;
	public ScannerObject(int count){
	    this.count=count ;
	}
	public int getCount(){
	    return this.count ;
	}
	public String nextString(){
	    StringBuffer buf=new StringBuffer() ;
	    for(int i=0;i<10;i++){
	        buf.append(charLow[r.nextInt(26)] ) ;
	        buf.append(charUP[r.nextInt(26)]);
        }
	    return buf.toString();
	}
}
