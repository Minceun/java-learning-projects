package Encrypt;

import java.security.MessageDigest;

public class MD5 {
	public static void main(String[] args) {
		System.out.println(MD5.MD5_Test("lixucheng"));

	}
	 public final static String MD5_Test(String oldStr) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		//System.out.println("原始字符串为："+oldStr);
		try {
		byte[] oldBytes = oldStr.getBytes();
		
		for(byte b:oldBytes)
		{
		System.out.print(b+" ");
		}
		System.out.println();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(oldBytes);
		byte[] newBytes = md.digest();
		for(byte b:newBytes)
		{
			System.out.print(b+" ");
		}
		System.out.println();
		char newStr[] = new char[32];
		for (int i = 0; i < 16; i++) {
		byte tmp = newBytes[i];
		newStr[2*i] = hexDigits[tmp >>> 4 & 0xf];
		newStr[2*i+1] = hexDigits[tmp & 0xf];
		}
		System.out.println(newStr);
		return new String(newStr);
		} catch (Exception e) {
		return null;
		}
}
}
