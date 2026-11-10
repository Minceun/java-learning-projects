package SERVICE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.BASEDAO;
import Entity.BACed;
import Entity.DOCed;
import Entity.MASed;
import Entity.News;
import Entity.admin;
import Encrypt.MD5;
import Entity.COR;
import Entity.FILE;



import Entity.participantMes;

public class parUser {

	

	public static int insertNews(News u) {
		//传入一个对象，然后将对象的属性值插入进来
		String sql="insert into news(newTitle,newText,newTime) values(?,?,?)";
		Object[] params= {
				u.getNewTitle(),
				u.getNewText(),
				u.getNewTime()
		};
		//问题句
		System.out.println(sql);
		return BASEDAO.exectuIUD(sql, params);
	}
	
	public static int insertAchievement(News u) {
		//传入一个对象，然后将对象的属性值插入进来
		String sql="insert into achievement(achievement_name,achievement_time,achievement_detail) values(?,?,?)";
		Object[] params= {
				u.getNewTitle(),
				u.getNewTime(),
				u.getNewText()
		};
		//问题句
		System.out.println(sql);
		return BASEDAO.exectuIUD(sql, params);
	}
	
	public static int insertBAC(BACed u) {
		//传入一个对象，然后将对象的属性值插入进来
		String sql="insert into baced(BACid,BACname,BACgender,status) values(?,?,?,?)";
		Object[] params= {
				u.getBACid(),
				u.getBACname(),
				u.getBACgender(),
				u.getstatus()
		};
		//问题句
		System.out.println(sql);
		return BASEDAO.exectuIUD(sql, params);
	}
	
	public static int insertMAS(MASed u) {
		//传入一个对象，然后将对象的属性值插入进来
		String sql="insert into mased(MASid,MASname,MASgender,status) values(?,?,?,?)";
		Object[] params= {
				u.getMASid(),
				u.getMASname(),
				u.getMASgender(),
				u.getstatus()
		};
		//问题句
		System.out.println(sql);
		return BASEDAO.exectuIUD(sql, params);
	}
	
	public static int insertDOC(DOCed u) {
		//传入一个对象，然后将对象的属性值插入进来
		String sql="insert into doced(DOCid,DOCname,DOCgender,status) values(?,?,?,?)";
		Object[] params= {
				u.getDOCid(),
				u.getDOCname(),
				u.getDOCgender(),
				u.getstatus()
		};
		//问题句
		System.out.println(sql);
		return BASEDAO.exectuIUD(sql, params);
	}


	public static ArrayList<DOCed> selectDoced() {
		ArrayList<DOCed> list=new ArrayList<DOCed>();
		//用户列表
		//声明结果集
		ResultSet rs=null;
		//获取链接对象
		Connection conn=BASEDAO.getconn();
		//
		PreparedStatement ps=null;
		try {
			
			String sql="";
			
			sql="select * from DOCed where status=1";				
			ps=conn.prepareStatement(sql);
			System.out.println(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				DOCed u=new DOCed(
						rs.getString("DOCid"),
						rs.getString("DOCname"),
						rs.getString("DOCgender"),
						rs.getString("DOCtele"),
						rs.getString("DOCfield"),
						rs.getString("DOCemail"),
						rs.getString("DOCMes"),
						rs.getString("DOCresult"),
						rs.getString("DOCpatent"),
						Integer.parseInt(rs.getString("status"))
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BASEDAO.closeall(rs, ps, conn);
		}
		
		return list;
	}

	public static ArrayList<MASed> selectMASed() {
		ArrayList<MASed> list=new ArrayList<MASed>();
		//用户列表
		//声明结果集
		ResultSet rs=null;
		//获取链接对象
		Connection conn=BASEDAO.getconn();
		//
		PreparedStatement ps=null;
		try {
			
			String sql="";
			
			sql="select * from MASed where status=1";				
			ps=conn.prepareStatement(sql);
			System.out.println(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				MASed u=new MASed(
						rs.getString("MASid"),
						rs.getString("MASname"),
						rs.getString("MASgender"),
						rs.getString("MAStele"),
						rs.getString("MASfield"),
						rs.getString("MASemail"),
						rs.getString("MASMes"),
						rs.getString("MASresult"),
						rs.getString("MASpatent"),
						Integer.parseInt(rs.getString("status"))
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BASEDAO.closeall(rs, ps, conn);
		}
		
		return list;
	}
	

	public static ArrayList<BACed> selectBACed() {
		ArrayList<BACed> list=new ArrayList<BACed>();
		//用户列表
		//声明结果集
		ResultSet rs=null;
		//获取链接对象
		Connection conn=BASEDAO.getconn();
		//
		PreparedStatement ps=null;
		try {
			
			String sql="";
			
			sql="select * from BACed where status=1";				
			ps=conn.prepareStatement(sql);
			System.out.println(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				BACed u=new BACed(
						rs.getString("BACid"),
						rs.getString("BACname"),
						rs.getString("BACgender"),
						rs.getString("BACtele"),
						rs.getString("BACemail"),
						rs.getString("BACMes"),
						Integer.parseInt(rs.getString("status"))
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BASEDAO.closeall(rs, ps, conn);
		}
		
		return list;
	}



public static ArrayList<News> selectNews() {
	ArrayList<News> list=new ArrayList<News>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from news";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			News u=new News(
					rs.getString("newTitle"),
					rs.getString("newText"),
					rs.getString("newTime")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}


public static ArrayList<News> selectAchievements() {
	ArrayList<News> list=new ArrayList<News>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from achievement";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			News u=new News(
					rs.getString("achievement_name"),
					rs.getString("achievement_detail"),
					rs.getString("achievement_time")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}


public static int insert1(participantMes u) {
	//传入一个对象，然后将对象的属性值插入进来
	String sql="insert into participantMes values(?,?,?,?,?,?,?,?,?)";
	Object[] params= {
			u.getParName(),
			u.getParGender(),
			u.getParAge(),
			u.getParDegree(),
			u.getParWork(),
			u.getParPerMes(),
			u.getParPrize(),
			u.getParReason(),
			u.getParTele()
	};
	//问题句
	System.out.println(sql);
	return BASEDAO.exectuIUD(sql, params);
}

public static ArrayList<participantMes> selectAll1() {
	ArrayList<participantMes> list=new ArrayList<participantMes>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from participantMes";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			participantMes u=new participantMes(
					rs.getString("parName"),
					rs.getString("parGender"),
					Integer.parseInt(rs.getString("parAge")),
					rs.getString("parTele"),
					rs.getString("parDegree"),
					rs.getString("parWork"),
					rs.getString("parPerMes"),
					rs.getString("parPrize"),
					rs.getString("parReason")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static ArrayList<DOCed> selectDoced1() {
	ArrayList<DOCed> list=new ArrayList<DOCed>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from DOCed where status=0";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			DOCed u=new DOCed(
					rs.getString("DOCid"),
					rs.getString("DOCname"),
					rs.getString("DOCgender"),
					rs.getString("DOCtele"),
					rs.getString("DOCfield"),
					rs.getString("DOCemail"),
					rs.getString("DOCMes"),
					rs.getString("DOCresult"),
					rs.getString("DOCpatent"),
					Integer.parseInt(rs.getString("status"))
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static ArrayList<MASed> selectMASed1() {
	ArrayList<MASed> list=new ArrayList<MASed>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from MASed where status=0";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			MASed u=new MASed(
					rs.getString("MASid"),
					rs.getString("MASname"),
					rs.getString("MASgender"),
					rs.getString("MAStele"),
					rs.getString("MASfield"),
					rs.getString("MASemail"),
					rs.getString("MASMes"),
					rs.getString("MASresult"),
					rs.getString("MASpatent"),
					Integer.parseInt(rs.getString("status"))
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static ArrayList<BACed> selectBACed1() {
	ArrayList<BACed> list=new ArrayList<BACed>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from BACed where status=0";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			BACed u=new BACed(
					rs.getString("BACid"),
					rs.getString("BACname"),
					rs.getString("BACgender"),
					rs.getString("BACtele"),
					rs.getString("BACemail"),
					rs.getString("BACMes"),
					Integer.parseInt(rs.getString("status"))
					);
			System.out.println(u);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static int insertFILE1(FILE file1) {
	//传入一个对象，然后将对象的属性值插入进来
			String sql="insert into file values(?,?,?,?)";
			Object[] params= {
					file1.getFileName(),
					file1.getFileCon(),
					file1.getFilePath(),
					file1.getFileOwner()
			};
			//问题句
			System.out.println(sql);
			return BASEDAO.exectuIUD(sql, params);
}

public static ArrayList<FILE> selectFILE1() {
	ArrayList<FILE> list=new ArrayList<FILE>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from FILE";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			FILE u=new FILE(
					rs.getString("fileName"),
					rs.getString("fileCon"),
					rs.getString("filePath"),
					rs.getString("fileOwner")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static int insertCOR1(COR cor) {
	//传入一个对象，然后将对象的属性值插入进来
	String sql="insert into COR values(?,?,?,?,?)";
	Object[] params= {
			cor.getCORname(),
			cor.getCORgender(),
			cor.getCORage(),
			cor.getCORidea(),
			cor.getCORtele()
	};
	//问题句
	System.out.println(sql);
	return BASEDAO.exectuIUD(sql, params);
}

public static ArrayList<COR> selectCOR1() {
	ArrayList<COR> list=new ArrayList<COR>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from COR";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			COR u=new COR(
					rs.getString("CORname"),
					rs.getString("CORgender"),
					Integer.parseInt(rs.getString("CORage")),
					rs.getString("CORidea"),
					rs.getString("CORtele")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static ArrayList<admin> selectAdmin1(String keywordString) {
	ArrayList<admin> list=new ArrayList<admin>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		if(keywordString!=null)
		{
			sql="select * from admin where admin_name='"+keywordString+"'";
			System.out.println(sql);
			ps=conn.prepareStatement(sql);

		}
		else {
			sql="select * from admin";				
			ps=conn.prepareStatement(sql);
			
		}
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			admin u=new admin(
				rs.getString("id"),
				rs.getString("admin_num"),
				rs.getString("admin_name"),
				rs.getString("admin_password").replaceAll(" ", "")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static admin selectById1(String adminID) {
	admin u=null;
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from admin where id='"+adminID+"'";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			u=new admin(
					rs.getString("id"),
					rs.getString("admin_num"),
					rs.getString("admin_name"),
					rs.getString("admin_password"),
					Integer.parseInt(rs.getString("status"))
						);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return u;
}

public static int delete1(admin ad1) {
	int count=0;
	String userID=ad1.getId();
	ResultSet rs=null;
	Connection conn=BASEDAO.getconn();
	PreparedStatement ps=null;
	try {
		
		String sql="";
		sql="delete from admin where id='"+userID+"'";				
	
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		count=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return count;
}

public static int update1(admin user) {
	  int count=0;
	  String id=user.getId();
	  String num=user.getAdmin_num();
	  String name=user.getAdmin_name();
	  String psw=user.getAdmin_password();
	  String psw1=MD5.MD5_Test(psw);
	  int status=user.getStatus();
	  ResultSet rs=null;
	  Connection conn=BASEDAO.getconn();
	  PreparedStatement ps=null;
	  try {
	   
	   String sql="";
	   sql="update admin set admin_num='"+num+"',admin_name='"+name+"',admin_password='"+psw1+"',status='"+status+"' where id='"+id+"'";    
	   System.out.println(sql);
	   ps=conn.prepareStatement(sql);
	   System.out.println(sql);
	   count=ps.executeUpdate();
	   
	  } catch (SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }finally {
	   BASEDAO.closeall(rs, ps, conn);
	  }
	  return count;
	 }

public static int insertAdmin1(admin u) {
	//传入一个对象，然后将对象的属性值插入进来
			String sql="insert into admin values(?,?,?,?,?)";
			String pswMD5=MD5.MD5_Test(u.getAdmin_password());
			Object[] params= {
					u.getId(),
					u.getAdmin_num(),
					u.getAdmin_name(),
					pswMD5,u.getStatus()
			};
			//问题句
			System.out.println(sql);
			return BASEDAO.exectuIUD(sql, params);
}

public static int selectPsw1(String userNum, String userPassword) {
	int count=0;
	 Connection conn=BASEDAO.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String Password=MD5.MD5_Test(userPassword);
		String sql="select count(*) from admin where admin_num='"+userNum+"' and admin_password='"+Password+"'";
		System.out.println(sql);
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BASEDAO.closeall(rs, ps, conn);}
	return count;
}

public static admin selectAdmin1(String userNum, String userPassword) {
	//通过用户名加密码获取用户所有信息
			admin u=null;
			//用户列表
			//声明结果集
			ResultSet rs=null;
			//获取链接对象
			Connection conn=BASEDAO.getconn();
			//
			PreparedStatement ps=null;
			String Password=MD5.MD5_Test(userPassword);
			try {
				
				String sql="";
				sql="select * from admin where admin_num='"+userNum+"' and admin_password='"+Password+"'";
				ps=conn.prepareStatement(sql);
				System.out.println(sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					u=new admin(
							rs.getString("id"),
							rs.getString("admin_num"),
							rs.getString("admin_name"),
							rs.getString("admin_password")
								);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				BASEDAO.closeall(rs, ps, conn);
			}
			return u;
}

public static ArrayList<DOCed> selectDoced1(String docnameString) {
	ArrayList<DOCed> list=new ArrayList<DOCed>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from DOCed where status=0 and DOCname='"+docnameString+"'";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			DOCed u=new DOCed(
					rs.getString("DOCid"),
					rs.getString("DOCname"),
					rs.getString("DOCgender"),
					rs.getString("DOCtele"),
					rs.getString("DOCfield"),
					rs.getString("DOCemail"),
					rs.getString("DOCMes"),
					rs.getString("DOCresult"),
					rs.getString("DOCpatent"),
					Integer.parseInt(rs.getString("status"))
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static ArrayList<MASed> selectMASed1(String masnameString) {
	ArrayList<MASed> list=new ArrayList<MASed>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from MASed where status=0 and MASname='"+masnameString+"'";					
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			MASed u=new MASed(
					rs.getString("MASid"),
					rs.getString("MASname"),
					rs.getString("MASgender"),
					rs.getString("MAStele"),
					rs.getString("MASfield"),
					rs.getString("MASemail"),
					rs.getString("MASMes"),
					rs.getString("MASresult"),
					rs.getString("MASpatent"),
					Integer.parseInt(rs.getString("status"))
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}

public static BACed selectBACById1(String bACid) {
	BACed u=null;
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from BACed where BACid='"+bACid+"'";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			u=new BACed(
					rs.getString("BACid"),
					rs.getString("BACname"),
					rs.getString("BACgender"),
					rs.getString("BACtele"),
					rs.getString("BACemail"),
					rs.getString("BACMes"),
					Integer.parseInt(rs.getString("status"))
					);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return u;
}

public static int deleteBAC1(BACed bac) {
	int count=0;
	String userID=bac.getBACid();
	ResultSet rs=null;
	Connection conn=BASEDAO.getconn();
	PreparedStatement ps=null;
	try {
		
		String sql="";
		sql="delete from BACed where BACid='"+userID+"'";				
	
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		count=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return count;
}

public static MASed selectMASById1(String MASid) {
	MASed u=null;
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from MASed where MASid='"+MASid+"'";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			u=new MASed(
					rs.getString("MASid"),
					rs.getString("MASname"),
					rs.getString("MASgender"),
					rs.getString("MAStele"),
					rs.getString("MASfield"),
					rs.getString("MASemail"),
					rs.getString("MASMes"),
					rs.getString("MASresult"),
					rs.getString("MASpatent"),
					Integer.parseInt(rs.getString("status"))
					);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return u;
}

public static int deleteMAS1(MASed mas) {
	int count=0;
	String userID=mas.getMASid();
	ResultSet rs=null;
	Connection conn=BASEDAO.getconn();
	PreparedStatement ps=null;
	try {
		
		String sql="";
		sql="delete from MASed where MASid='"+userID+"'";				
	
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		count=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return count;
}

public static DOCed selectDOCById1(String DOCid) {
	DOCed u=null;
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		
		sql="select * from DOCed where DOCid='"+DOCid+"'";				
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			u=new DOCed(
					rs.getString("DOCid"),
					rs.getString("DOCname"),
					rs.getString("DOCgender"),
					rs.getString("DOCtele"),
					rs.getString("DOCfield"),
					rs.getString("DOCemail"),
					rs.getString("DOCMes"),
					rs.getString("DOCresult"),
					rs.getString("DOCpatent"),
					Integer.parseInt(rs.getString("status"))
					);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return u;
}

public static int deleteDOC1(DOCed doc) {
	int count=0;
	String userID=doc.getDOCid();
	ResultSet rs=null;
	Connection conn=BASEDAO.getconn();
	PreparedStatement ps=null;
	try {
		
		String sql="";
		sql="delete from DOCed where DOCid='"+userID+"'";				
	
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		count=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	return count;
}

public static int insertDOC1(DOCed doc) {
	//传入一个对象，然后将对象的属性值插入进来
	String sql="insert into DOCed values(?,?,?,?,?,?,?,?,?,?)";
	Object[] params= {
			doc.getDOCid(),
			doc.getDOCname(),
			doc.getDOCgender(),
			doc.getDOCtele(),
			doc.getDOCfield(),
			doc.getDOCemail(),
			doc.getDOCMes(),
			doc.getDOCresult(),
			doc.getDOCpatent(),
			doc.getstatus()
	};
	//问题句
	System.out.println(sql);
	return BASEDAO.exectuIUD(sql, params);
}

public static int insertMAS1(MASed mas) {
	//传入一个对象，然后将对象的属性值插入进来
			String sql="insert into MASed values(?,?,?,?,?,?,?,?,?,?)";
			Object[] params= {
					mas.getMASid(),
					mas.getMASname(),
					mas.getMASgender(),
					mas.getMAStele(),
					mas.getMASfield(),
					mas.getMASemail(),
					mas.getMASMes(),
					mas.getMASresult(),
					mas.getMASpatent(),
					mas.getstatus()
			};
			//问题句
			System.out.println(sql);
			return BASEDAO.exectuIUD(sql, params);
}

public static int insertBAC1(BACed bac) {
	//传入一个对象，然后将对象的属性值插入进来
	String sql="insert into BACed values(?,?,?,?,?,?,?)";
	Object[] params= {
			bac.getBACid(),
			bac.getBACname(),
			bac.getBACgender(),
			bac.getBACtele(),
			bac.getBACemail(),
			bac.getBACMes(),
			bac.getstatus()
	};
	//问题句
	System.out.println(sql);
	return BASEDAO.exectuIUD(sql, params);
}

public static ArrayList<admin> selectHigher1(int i) {
	ArrayList<admin> list=new ArrayList<admin>();
	//用户列表
	//声明结果集
	ResultSet rs=null;
	//获取链接对象
	Connection conn=BASEDAO.getconn();
	//
	PreparedStatement ps=null;
	try {
		
		String sql="";
		//i=1的时候，是高级权限，被提取出来
		sql="select * from admin where status='"+i+"'";		
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			admin u=new admin(
				rs.getString("id"),
				rs.getString("admin_num"),
				rs.getString("admin_name"),
				rs.getString("admin_password").replaceAll(" ", "")
					);
			list.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BASEDAO.closeall(rs, ps, conn);
	}
	
	return list;
}
}
