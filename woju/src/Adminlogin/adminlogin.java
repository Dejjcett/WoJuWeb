package Adminlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DB;

public class adminlogin extends HttpServlet {
	private static final long serialVersionUID= 8263971064846172436L;
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");  //���ø�ʽ����
		  request.setCharacterEncoding("UTF-8");            //���ø�ʽ����
		  PrintWriter out = response.getWriter();
		  String adminName; 
		  String passWord; 
		  adminName = request.getParameter("username");     //���ձ?���������û��˺�
		  passWord = request.getParameter("password");  //�û�����
		  if(confirmDate(adminName,passWord))
		  {	
			  out.println("<center><h1>登录成功</h1></center>");
			  HttpSession session = request.getSession();
		        session.setAttribute("loginUser", adminName);
		        session.setAttribute("passWord", passWord);
		        session.setAttribute("adminFlag", 1);
		        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		  }
		  else
			  {
			  		out.println("<center><h1>登录失败</h1></center>");
			  		out.print("<a href=\"/woju/admin.jsp\">返回登录</a>");
			  }
		 }	
	
	
		 private boolean confirmDate(String name,String password) {
			 if((name.equals("001")&&password.equals("111111"))||
					 (name.equals("002")&&password.equals("222222"))||
					 (name.equals("003")&&password.equals("333333"))||
					 (name.equals("004")&&password.equals("444444"))||
					 (name.equals("005")&&password.equals("555555")))
				 return true;
			 else
				 return false;
		 }	
	}


