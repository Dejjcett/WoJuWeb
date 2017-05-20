package loginServlet;
import DB.DB;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class login extends HttpServlet {
	private static final long serialVersionUID= 8263971064846072436L;
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
		  passWord = request.getParameter("password");  //�û�����
		  if(insertDate())
		  {	
			  out.println("<center><h1>登录成功</h1></center>");
			  HttpSession session = request.getSession();
		        session.setAttribute("loginUser", userName);
		        session.setAttribute("passWord", passWord);
		        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		  }
		  else
			  {
			  		out.println("<center><h1>登录失败</h1></center>");
			  		out.print("<a href=\"/woju/login.jsp\">返回登录</a>");
			  }
		 }	
	
	
		 private boolean insertDate() {
		  Connection con = null;  //һ�����Ӷ���
		  con = (Connection) DB.getcon(con);   //�õ�һ������
		  PreparedStatement ps = null;    //���ڲ������
		  //sql��䣬���user���棬����name��pass��ֵ
		  String sql = "select * from user1_info where username=? and password=?";   
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
		   ps.setString(1, userName);
		   ps.setString(2, passWord);
		   ResultSet rs = null;
		   rs = ps.executeQuery();
	        if(rs.next()) 
	        {
	        	ps.close();
	           return true;
	       }
	        else 
	        {
	        	ps.close();
	        }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return false;
		 }	
}
