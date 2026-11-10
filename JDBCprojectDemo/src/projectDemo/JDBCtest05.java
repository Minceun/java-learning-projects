package projectDemo;
import java.sql.*;
import java.util.*;

/*
 * 1.解决SQL注入
 * 		只要用户提供的信息不参与SQL语句的编译过程，问题就解决了
 * 		即使用户提供的信息中含有SQL语句的关键字，但没有参与编译，就不起作用
 * 		那么就必须使用java.sql.PreparedStatement
 * 		PreparedStatement是属于预编译的数据库操作对象
 * 		PreparedStatement的原理是：预先对SQL语句的框架进行编译，然后再给SQL语句传“值”
 * 2.Statement和PreparedStatement区别
 * （1）PreparedStatement解决了SQL注入问题
 * （2）Statement执行一次编译一次，PreparedStatement编译一次可执行多次，直接替换语句中的‘？’即可
 * 所以PreparedStatement的效率比Statement高
 * （3）而且PreparedStatement会在编译阶段进行类型的安全检查
 * 3.什么时候必须使用Statement
 * 业务方面需要SQL语句注入
 */
public class JDBCtest05 {

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
		PreparedStatement ps = null; //预编译的数据库操作对象
		ResultSet rs= null;
        try 
        {
        		//1.注册驱动
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		//2.获取连接
            connect = DriverManager.getConnection(  
                 "jdbc:mysql://127.0.0.1:3306/bjpowernode","root","CZXmylove124121/");
            System.out.println("Success connect Mysql server!"); 
            //3.获取预编译的数据库操作对象（statement专门执行sql语句的）
            //先写sql语句框，其中一个？表示一个占位符，一个？将来接收一个值，注意：占位符不能用单引号括起来
            String sql = "select * from t_user where loginName = ? and loginPwd = ? ";
            //程序执行到此处，会发送sql语句框给DBMS，然后DBMS进行sql语句预编译
            ps = connect.prepareStatement(sql);
            //给占位符传值（第1个？下标是1，第2个下标是2）
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //4.执行sql
            //专门执行DQL语句，返回ResultSet
            rs = ps.executeQuery();
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