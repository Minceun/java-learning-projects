package projectDemo;
import java.sql.*;
import java.util.*;

/*
 * JDBC事务机制
 * 1.JDBC中的事务是自动提交的
 * 		只要执行任意一条DML语句，则自动提交一次，这是JDBC默认的事务机制
 * 		但是在实际业务中，通常都是N条DML语句共同联合才能完成的，
 * 		必须保证他们这些DML语句在同一个事务中同时成功或者同时失败
 * 
 * (不安全，如银行转账时，两个事务（转出和转入）必须同时成功或同事失败，否则容易丢失数据或结果异常)
 * 
 * 2.以下为验证JDBC自动提交机制
 * 
 * connect.setAutoCommit()
 * connect.rollback()
 * connect.commit();
 */
public class JDBCtest07 {

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
            
            //将自动提交机制改为手动提交机制
            connect.setAutoCommit(false);
            
            //3.获取预编译的数据库操作对象
            String sql = "update dept set dname=? where deptno=?";
            ps = connect.prepareStatement(sql);

            //4.执行sql
            ps.setString(1, "x部门");
            ps.setInt(2, 30);
            int count = ps.executeUpdate();
            System.out.println(count);
            
            //重新给占位符传值
            ps.setString(1, "y部门");
            ps.setInt(2, 30);
            count = ps.executeUpdate();
            System.out.println(count);
            
            //5.处理查询结果
            //手动提交结果
            connect.commit();
         }  
         catch (Exception e){
        	 	    //回滚事务
        	 		if(connect!=null) {
        	 			try {
        	 				connect.rollback();
        	 			}catch(SQLException e1) {
        	 				e1.printStackTrace();
        	 			}
        	 		}
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