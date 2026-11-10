package projectDemo;
import java.sql.*;
import java.util.*;


public class JDBCtest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		Statement stmt = null;
		try 
        {
			//1.注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver(); //多态，父类型引用指向子类型
			DriverManager.registerDriver(driver);
//              Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序      
              System.out.println("Success loading Mysql Driver!");  
         }  
         catch (Exception e) 
        {  
              System.out.print("Error loading Mysql Driver!");  
              e.printStackTrace();  
        }  
        try 
        {
               System.out.println("start connecting");
               //连接URL为jdbc:mysql//服务器地址/数据库名，后面的2个参数分别是登陆用户名和密码 
               //2.获取连接
               connect = DriverManager.getConnection(  
                       "jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
               System.out.println("Success connect Mysql server!"); 
               System.out.print("数据库连接对象=" + connect);
              
       		   //3.获取数据库操作对象（statement专门执行sql语句的）
               stmt = connect.createStatement();  
            
               //4.执行sql
               //String sql = "insert into dept(deptno,dname,loc) value(60,'人事部','北京')";
               //String sql = "delete from dept where deptno = 60";
               //String sql = "update dept set dname = '销售部',loc = '天津' where deptno=20";
               //专门执行DML语句的(update,delete,insert)
               //返回影响数据库中的记录条数
//               int count = stmt.executeUpdate(sql);
//               System.out.print(count == 1 ? "成功" : "失败");
               
               //5.处理查询结果
         }  
         catch (Exception e) 
         {  
              System.out.print("get data error!");  
              e.printStackTrace();  
         }  finally {
        	 		//6.释放资源
        	 		//为了保证资源一定释放，在finally语句块中关闭资源
        	 		//并且要遵循从小到大依次关闭
        	 		//分别对其try catch
        	 		try {
        	 			if(stmt != null) {
            	 			stmt.close();
            	 		}
        	 		}catch(SQLException e) {
        	 			e.printStackTrace();
        	 		}
        	 		try {
        	 			if(connect != null) {
            	 			connect.close();
            	 		}
        	 		}catch(SQLException e) {
        	 			e.printStackTrace();
        	 		}
         }
	}
}
