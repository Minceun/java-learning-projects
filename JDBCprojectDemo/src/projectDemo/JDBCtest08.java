package projectDemo;
import java.sql.*;
import java.util.*;

import utils.DBUtil;
/*
 * 1.测试DBUtil
 * 2.模糊查询
 */
public class JDBCtest08 {
	public static void main(String[] args) {
		//JDBC代码
		Connection connect = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
        try {
        		connect = DBUtil.getConnection();
        		//获取预编译的数据库操作对象
        		String sql = "select ename from emp where ename like ?";
        		ps = connect.prepareStatement(sql);
        		ps.setString(1, "_A%");
        		rs = ps.executeQuery();
        		while(rs.next()) {
        			System.out.println(rs.getString("ename"));
        		}
        }catch(Exception e) {
        		e.printStackTrace();
        }finally {
        		DBUtil.close(connect, ps, rs);
        }
        		
	}	
}