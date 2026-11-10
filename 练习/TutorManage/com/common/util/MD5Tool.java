package com.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {
	public static String getMessageDigest(String message){
		
		try {
			return new String(MessageDigest.getInstance("MD5").digest(message.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "null";
		}
	}
}
