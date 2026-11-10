package projectDemo;
import java.sql.*;
import java.util.*;

/*
 * 1.需求：模拟用户登录
 * 2.业务描述：
 * 	程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码，返回是否登录成功
 * 3.当前程序存在的问题
 * 		用户名：aaa
 * 		密码：aaa' or '1'='1
 * 		登录成功
 * 		这种现象称为SQL注入
 * 4.SQL注入原因：
 * select * from t_user where loginName = 'aaa' and loginPwd = 'aaa' or '1' = '1';
 * 		
 */
public class JDBCtest04 {

	public static void main(String[] args) {
		//初始化一个界面
		Map<String,String> userLoginInfo = initUI();
		//验证用户名和密码
		boolean loginsuccess = login(userLoginInfo);
		System.out.println(loginsuccess?"登录成功":"登录失败");
	}

	private static boolean login(Map<String, String> userLoginInfo) {
		boolean loginsuccess = false;
		String loginName = userLoginInfo.get("loginName");
		String loginPwd = userLoginInfo.get("loginPwd");
		//JDBC代码
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs= null;
        try 
        {
        		//1.注册驱动
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		//2.获取连接
            connect = DriverManager.getConnection(  
                 "jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
            System.out.println("Success connect Mysql server!"); 
            //3.获取数据库操作对象（statement专门执行sql语句的）
            stmt = connect.createStatement();
            //4.执行sql
            String sql = "select * from t_user where loginName = '"+loginName+"' and loginPwd = '"+loginPwd+"'";            
            //专门执行DQL语句，返回ResultSet
            rs = stmt.executeQuery(sql);
            //5.处理查询结果
            if(rs.next())
            {
            		loginsuccess = true;
            }
         }  
         catch (Exception e){  
              e.printStackTrace();  
         }finally{
        	 	//6.释放资源
        	 	if(rs != null) {
        	 		try {
                	 	rs.close();
            	 	}catch(SQLException e) {
            	 		e.printStackTrace();
            	 	}
        	 	}
        	 	if(stmt != null) {
        	 		try {
                	 	stmt.close();
            	 	}catch(SQLException e) {
            	 		e.printStackTrace();
            	 	}
        	 	}
        	 	if(connect != null) {
        	 		try {
                	 	connect.close();
            	 	}catch(SQLException e) {
            	 		e.printStackTrace();
            	 	}
        	 	}
         }
        return loginsuccess;
	}

	private static Map<String, String> initUI() {
		Scanner s = new Scanner(System.in);
		System.out.print("用户名：");
		String loginName = s.nextLine();
		
		System.out.print("密码：");
		String loginPwd = s.nextLine();
		
		Map<String, String> userLoginInfo = new HashMap<>();
		userLoginInfo.put("loginName", loginName);
		userLoginInfo.put("loginPwd", loginPwd);
		
		return userLoginInfo;
	}
	
	
}