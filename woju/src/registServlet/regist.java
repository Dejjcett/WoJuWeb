package registServlet;
import DB.DB;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class regist extends HttpServlet {
	private static final long serialVersionUID= 8263961064846072436L;
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */

	private String userName;    //���ձ?�ύ�������˻�
	private String passWord;     //����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");  //���ø�ʽ����
		  request.setCharacterEncoding("UTF-8");            //���ø�ʽ����
		  PrintWriter out = response.getWriter();
		  userName = request.getParameter("username");     //���ձ?���������û��˺�
		  passWord = request.getParameter("password");  //�û����
		  if(DB.searchData(userName))
		  {		  
				out.println("该用户已被注册");
				out.println("<a href=\"/woju/regist.jsp\">重新注册</a>");
		  }
		  else
		  {
			  insertDate();   
			  HttpSession session = request.getSession();
		        session.setAttribute("loginUser", userName);
		        session.setAttribute("passWord", passWord);
		        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		//        response.sendRedirect("/regist_succeed.jsp");
		  }
		 }
		 private void insertDate() {
		  Connection con = null;  
		  con = (Connection) DB.getcon(con);  
		  PreparedStatement ps = null;    
		  String sql = "insert into  user1_info values(?,?,?)";   
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
		   ps.setString(1, userName);
		   ps.setString(2, passWord);
		   ps.setString(3, null);                        //  如果没有   插入不了   操作无效
		   ps.executeUpdate();
		   ps.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }	
	       
		 
		 
/*		
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        String driverName = "com.mysql.jdbc.Driver";         
	        String userName = "root";
	        String userPwd = "18796014763";
	        String dbName = "user_info";
	        String url1 = "jdbc:mysql://120.76.112.76:3306/" + dbName;
	        String url2 = "?user=" + userName + "&password=" + userPwd;
	        String url3 = "&useUnicode=true&characterEncoding=UTF-8";
	        String url = url1 + url2 + url3;
	        request.setCharacterEncoding("UTF-8");
	       
	        Class.forName(driverName);
	        conn = DriverManager.getConnection(url);
	    //��ݿ�����Ӵ��룬drivername����ݿ������ƣ�URL��url1��url2��url3�ϳɣ�����ݿ����ӵ��û���˿ڵ����ӵ���Ϣ��UTF-8����ݿ⴫��ĸ�ʽ���룬conn�����ǻ������/
	       
	        String sql = "insert into  wow values(?,?)";
	        pstmt = conn.prepareStatement(sql);
	        String user = request.getParameter("username");
	        String password = request.getParameter("password");
	        pstmt.setString(1,user);
	        pstmt.setString(2,password);
	        pstmt.executeUpdate();
	       
	            pstmt.close();
	     
	            conn.close();
	            */
		  
}
