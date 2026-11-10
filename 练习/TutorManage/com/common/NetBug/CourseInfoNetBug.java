package com.common.NetBug;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseInfoNetBug {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static CloseableHttpResponse loginModel() throws UnsupportedOperationException, IOException {
		String loginUrl = "http://202.199.96.30/ACTIONLOGON.APPPROCESS?mode=3";//教务在线主页
		URL url = new URL(loginUrl);
		Document loginDocument = Jsoup.parse(url, 2000);
		String src = loginDocument.getElementsByTag("img").get(0).attr("src");
		HttpGet httpGet = new HttpGet("http://202.199.96.30/" + src);//请求下载图片
		CloseableHttpClient myHttpClient = HttpClients.createDefault();
		CloseableHttpResponse response = myHttpClient.execute(httpGet);
		InputStream inputStream = response.getEntity().getContent();
		String filePath = "WebRoot/file/verifiedCodeImg.jpg";
		WriteFile(inputStream,filePath);
		String verifiedCode = VerifiedCode.getVerifiedCode(new File(filePath));
		String loginFormUrl = "http://202.199.96.30/ACTIONLOGON.APPPROCESS?mode=4";
		HttpPost httpPost = new HttpPost(loginFormUrl);//登录
		List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();  
		valuePairs.add(new BasicNameValuePair("WebUserNO", "150405110"));
		valuePairs.add(new BasicNameValuePair("Password", "102679"));
		valuePairs.add(new BasicNameValuePair("Agnomen", "verifiedCode"));
		UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
		httpPost.setEntity(uefe);
		response = myHttpClient.execute(httpGet);
		return response;
	}
	@SuppressWarnings("finally")
	public static boolean WriteFile(InputStream is,String filePath) {
		boolean returnValue = true;
		File imgFile = new File(filePath);
		if(!imgFile.exists()) { 
			try {
				imgFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(imgFile);
			byte b[] = new byte[1024*256];
			int len;
			while((len = is.read(b)) >= 0) {
				fos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			returnValue = false;
		} catch (IOException e) {
			returnValue = false;
		} finally {
			try {
				is.close();
				fos.close();
			} catch (IOException e) {
				return false;
			}
			return returnValue;
		}
	}
	
	public static Map<Integer,Object> getCourseInfo(String tno,String termNo,Date beginDate) throws UnsupportedOperationException, ClientProtocolException, IOException {
		CloseableHttpClient myHttpClient = HttpClients.createDefault();
		String queryUrl = "http://jwc.sut.edu.cn/ACTIONQUERYTEACHERSCHEDULEBYPUBLIC.APPPROCESS";
		HttpPost httpPost = new HttpPost(queryUrl);
		List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();  
		valuePairs.add(new BasicNameValuePair("TeacherNO", tno));
		valuePairs.add(new BasicNameValuePair("YearTermNO", termNo));
		UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
		httpPost.setEntity(uefe);
		Document ResultDocument = Jsoup.parse(myHttpClient.execute(httpPost).getEntity().getContent(), "GBK", "");
		Elements tds = ResultDocument.select("table[frame='box'] td[valign='top']");
		Map<Integer,Object> result = new HashMap<Integer,Object>();
		int i = 0;
		int index = 0;
		//System.out.println(tds.size());
		for(Element e:tds) {
			index = (i%7)*6+i/7;
			result.put(index, PatternMatch(e.text()));
			i++;
		}
		return infoTransform(result,beginDate);
	}
	
	public static Map<String,Object> PatternMatch(String info) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(info.equals("")) {			
			result.put("cName", null);
			result.put("weekNo", null);
		}else {
			ArrayList<Integer> weekNo = new ArrayList<Integer>();
			String cName = info.substring(0,info.indexOf(" "));
			result.put("cName", cName);
			String weekInfo = info.substring(info.indexOf("*")+2,info.lastIndexOf("整")-1).trim();
			String[] weekArray = weekInfo.split("\\.");
			for(int i=0;i<weekArray.length;i++) {
				if(weekArray[i].contains("-")) {
					String[] week = weekArray[i].split("-");
					for(int j=Integer.parseInt(week[0]);j<=Integer.parseInt(week[1]);j++) {
						weekNo.add(j);
					}
				}else {
					weekNo.add(Integer.parseInt(weekArray[i]));
				}
			}
			result.put("weekNo", weekNo);
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static Map<Integer,Object> infoTransform(Map<Integer,Object> result,Date beginDate) {
		Map<Integer,Object> _result = new HashMap<Integer,Object>();
		for(int i=1;i<=20;i++) {//周数
			Map<Integer,Object> weekInfo = new HashMap<Integer,Object>();//每周的课程信息
			if(i!=1) {
				beginDate.setTime(beginDate.getTime()+24*7*3600*1000);
			}
			for(int j=0;j<result.size();j++) {
				Map<String,Object> courseInfo = (Map<String,Object>)result.get(j);//每节课的信息
				weekInfo.put(-j-1, new Date(beginDate.getTime()+j/6*24*3600*1000));
				if(courseInfo.get("cName") == null) {
					weekInfo.put(j, null);
				}else {
					if(((ArrayList<Integer>)courseInfo.get("weekNo")).contains(i)) {
						weekInfo.put(j, ((Map<String,Object>)result.get(j)).get("cName"));
					}else {
						weekInfo.put(j, null);
					}
				}
			}
			_result.put(i, weekInfo);
		}
		return _result;
	}
}
