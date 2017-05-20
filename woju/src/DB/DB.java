package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.ActivityInfor;

/*
 * http://blog.csdn.net/hhhccckkk/article/details/8927766
 * �ο�������
 */
public class DB {
	public static Connection getcon(Connection con) {
		String dbname = "user_info"; // �㴴������ݿ�����
		String username = "root"; // ��½��ݿ���˺ţ�Ĭ��Ϊroot
		String password = "18796014763"; // ��½����
		String url = "jdbc:mysql://120.76.112.76:3306/" + dbname + "?user="
				+ username + "&password=" + password + "&useUnicode=true&characterEncoding=gbk";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // ������ذ�
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	public static void closecon(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}

	public static Statement getsta(Connection con) {
		Statement sta = null;
		try {
			sta = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sta;
	}

	public static void closesta(Statement sta) {
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sta = null;
		}
	}

	public static PreparedStatement getpsta(Connection con, String sql)

	{
		PreparedStatement psta = null;
		try {
			psta = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psta;

	}

	public static ResultSet getrs(Statement sta, String sql)

	{
		ResultSet rs = null;
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void closers(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}

	public static void executeUpdate(Connection con, String sql) {
		Statement sta = null;
		try {
			sta = con.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static int numData(String url)
	{
		Connection con = null; 
		  con = (Connection) getcon(con);  
		  PreparedStatement ps = null;
		 String sql = "select *  from "+url;//从数据库中查询
		 ps = (PreparedStatement) getpsta(con, sql);
		 ResultSet rs = null;
		 int num = 0;
		 
		 try {
			 
			 rs = ps.executeQuery();			
//*****method 1********//
			 while(rs.next()){
				 num++;
			 }
/*
 * http://bbs.csdn.net/topics/390936237?page=1
 *method3
    String sql = "select count(*) rec from (select * from worker) ww";  
    ResultSet rs = st.executeQuery(sql);  
    int rowCount = 0;  
    while (rs.next()) {  
        rowCount = rs.getInt("rec");  	
 */
			 
			   ps.close();
			  } catch (SQLException e) {
				  num = -1;
			   e.printStackTrace();
			  }		 
		 
		 return num;
	}
	
	public static boolean searchData(String name)
	{
		Connection con = null; 
		  con = (Connection) getcon(con);  
		  PreparedStatement ps = null;
		 String sql = "select count(*)  from user1_info where username="+"\""+name+"\"";//从数据库中查询
		 //mysql语句中加入变量的方法！！！！！！！！
		 ps = (PreparedStatement) getpsta(con, sql);
		 ResultSet rs = null;
		 try {
			 rs = ps.executeQuery();	
			 if(rs.next()){
				 if(rs.getInt(1)>0)
				 {
					 ps.close();
					 return true;
				 }
			 }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }		
			 return false;
	}
	
	public static void  displayData(int id)
	{
		String sId = Integer.toString(id);
		Connection con = null; 
		  con = (Connection) getcon(con);  
		  PreparedStatement ps = null;
		 String sql = "select *  from activity_info where activityID="+"\""+sId+"\"";//从数据库中查询
		 //mysql语句中加入变量的方法！！！！！！！！
		 ps = (PreparedStatement) getpsta(con, sql);
		 ResultSet rs = null;
		 try {
			 rs = ps.executeQuery();
			 if(rs.next()){
				 ActivityInfor.setActivityID(null);
				 ActivityInfor.setActName(null);
				 ActivityInfor.setDeadtime(null);
				 ActivityInfor.setStarttime(null);
				 ActivityInfor.setType(null);
				 ActivityInfor.setMember(2);
				 ActivityInfor.setActabstract(null);
				 ActivityInfor.setReleaser(null);
//				 ActivityInfor.setContent(null);
				 ActivityInfor.setActivityID(sId);
				 ActivityInfor.setActName(rs.getString("actname"));
				 ActivityInfor.setDeadtime(rs.getString("deadtime"));
				 ActivityInfor.setStarttime(rs.getString("starttime"));
				 ActivityInfor.setType(rs.getString("type"));
				 ActivityInfor.setActabstract(rs.getString("actabstract"));
				 ActivityInfor.setReleaser(rs.getString("releaser"));
				 ActivityInfor.setMember(rs.getInt("memeber"));				 
//				 ActivityInfor.setContent(rs.getString("content"));
			 }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }	
	}
}