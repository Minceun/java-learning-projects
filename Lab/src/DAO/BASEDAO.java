package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BASEDAO {
	static {
		//加载驱动
		//当下面的语句不出现错误，才说明找到了jar包
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//8.16是其他的版本
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getconn() {
		//创建一个连接对象
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root", "CZXmylove124121/");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("连接成功");
		return conn;
		//现在就可以进行增删改操作了
	}
	public static int exectuIUD(String sql,Object[] params) {
		int count=0;
		System.out.println("到执行函数");
		Connection conn=BASEDAO.getconn();
		//准备SQL语句去执行
		PreparedStatement ps=null;
		try {
			//准备SQL
			ps=conn.prepareStatement(sql);
			//绑定参数
			for (int i = 0; i < params.length; i++) {
				System.out.println("第"+i+"个参数 = "+params[i]);
				ps.setObject(i+1, params[i]);
			}
			//执行
			count=ps.executeUpdate();
			//count是影响的行数
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			BASEDAO.closeall(null,ps,conn);
		}
		System.out.println("更改之后的count = "+count);
		return count;
		
	}
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		//关闭的方法--资源空的话，不用关闭
		if(rs!=null)
		{//下面不要用括号转型
			 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
