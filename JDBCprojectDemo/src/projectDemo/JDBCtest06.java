package projectDemo;
import java.sql.*;
import java.util.*;

/*
 * PreparedStatement完成insert、delete、update
 */
public class JDBCtest06 {

	public static void main(String[] args) {
		//JDBC代码
		Connection connect = null;
		PreparedStatement ps = null; //预编译的数据库操作对象
        try 
        {
        		//1.注册驱动
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		//2.获取连接
            connect = DriverManager.getConnection(  
                 "jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
            System.out.println("Success connect Mysql server!"); 
            //3.获取预编译的数据库操作对象
//            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
//            String sql = "update dept set dname=?,loc=? where deptno=?";
//            String sql = "delete from dept where deptno=?";
//            ps = connect.prepareStatement(sql);
            //给占位符传值（第1个？下标是1，第2个下标是2）
//            ps.setInt(1,60);
//            ps.setString(2,"销售部");
//            ps.setString(3,"beijing");
            
//            ps.setString(1,"研发一部");
//            ps.setString(2,"beijing");
//            ps.setInt(3,60);
            
//            ps.setInt(1,60);

            //4.执行sql
            //专门执行DQL语句，返回ResultSet
            int count = ps.executeUpdate();
            System.out.println(count);
            //5.处理查询结果
         }  
         catch (Exception e){  
              e.printStackTrace();  
         }finally{
        	 	//6.释放资源
        	 	if(ps != null) {
        	 		try {
                	 	ps.close();
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