package projectDemo;
import java.sql.*;
import java.util.*;

//注册驱动的另一种方式
public class JDBCtest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用资源绑定器绑定属性配置文件
//		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
//		String driver = bundle.getString("driver");
//		String url = bundle.getString("url");
//		String user = bundle.getString("user");
//		String password = bundle.getString("password");
		Connection connect = null;
		Statement stmt = null;
		try 
        {
			
			//1.注册驱动
			//(1)第一种方法
			//Driver driver = new com.mysql.cj.jdbc.Driver(); //多态，父类型引用指向子类型
			//DriverManager.registerDriver(driver);    
			
			//(2)第二种方法
			//参数是一个字符串，字符串可以写到xxx.properties文件中
			//以下方法不需要接收返回值，因为我们只想用他的类加载动作
			Class.forName("com.mysql.cj.jdbc.Driver");
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
                 "jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
            System.out.println("Success connect Mysql server!"); 
         }catch(SQLException e){
        	 	e.printStackTrace();
         }
	}
}