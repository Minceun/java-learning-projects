package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class jdbcOperation {
	public static void main(String[] args) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs= null;
		try 
        {
			//1.注册驱动
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
            System.out.println("Success loading Mysql Driver!");  
        }
        catch (Exception e) 
        {
            System.out.print("Error loading Mysql Driver!");  
            e.printStackTrace();  
        }
        try 
        {
        		//2.获取连接
            System.out.println("start connecting");
            connect = DriverManager.getConnection(  
                 "jdbc:mysql://127.0.0.1:3306/JDBC","root","CZXmylove124121/");
            System.out.println("Success connect Mysql server!"); 
            
            //3.获取数据库操作对象（statement专门执行sql语句的）
            stmt = connect.createStatement();
            
            //4.执行sql
            String sql = "insert into ";
    			rs = stmt.executeQuery(sql);
    		//5.遍历结果集，获取查询数据
    		while(rs.next()) {
    			int id = rs.getInt(1); //行数
    			String name = rs.getString("name");
    			String psw = rs.getString(3);
    			String email = rs.getString("email");
    			Date birth = rs.getDate("birth");
    			System.out.println(id+" "+name+" "+psw+" "+email+" "+birth);
    		}
            
            
            
            
         }  
         catch (Exception e) 
         {  
              System.out.print("get data error!");  
              e.printStackTrace();  
         }finally{
        	 	//6.释放资源
        	 	//为了保证资源一定释放，在finally语句块中关闭资源
        	 	//并且要遵循从小到大依次关闭
        	 	//分别对其try catch
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
	}
}