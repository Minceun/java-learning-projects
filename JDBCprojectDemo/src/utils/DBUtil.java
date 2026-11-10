package utils;
import java.sql.*;

public class DBUtil {
	//工具类中的构造方法都是私有的
	//因为工具类的方法都是静态的，不需要new对象，直接采用类名调用

	private DBUtil() {}
		//静态代码块在类加载的时候执行，且只执行一次
	static {
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
        	//2.获取连接,返回连接对象
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
	}

	public static void close(Connection conn,Statement ps,ResultSet rs) {
		//6.释放资源
		if(rs != null) {
	 		try {
        	 		rs.close();
    	 		}catch(SQLException e) {
    	 			e.printStackTrace();
    	 		}
	 	}
	 	if(ps != null) {
	 		try {
        	 		ps.close();
    	 		}catch(SQLException e) {
    	 			e.printStackTrace();
    	 		}
	 	}
	 	if(conn != null) {
	 		try {
        	 		conn.close();
    	 		}catch(SQLException e) {
    	 			e.printStackTrace();
    	 		}
	 	}
	}
}
