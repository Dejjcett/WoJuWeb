package detial1Servlet;

import DB.DB;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class detial1 extends HttpServlet {
	private static final long serialVersionUID= 6263971064846572434L;
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
		response.setContentType("text/html;charset=utf-8");  //���ø�ʽ����
		  request.setCharacterEncoding("utf-8");            //���ø�ʽ����
		doPost(request,response);
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
	private String actID=null;
	private String Content=null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=utf-8");  
		  request.setCharacterEncoding("utf-8");            
		  PrintWriter out = response.getWriter();
		  out.println("<head><title>活动详情</title></head>");
		  
		  
		  actID = request.getParameter("id");
			    
		  Content = searchDate();
		  if(Content==null||Content=="")
		  {	
			  out.println("<center><h1>无详情</h1></center>");
		  }
		  else 
			  {
				  out.println("<center><h1>活动详情</h1></center>");
				  out.println(Content);
			  }
		 }
		
	
		 private String searchDate() {
			 
		  Connection con = null;  //һ�����Ӷ���
		  con = (Connection) DB.getcon(con);   //�õ�һ������
		  PreparedStatement ps = null;    //���ڲ������
		  String cont = null;
		  String sql = "select * from activity_info where activityID ="+actID; 
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
		   ResultSet rs = null;
		   rs = ps.executeQuery();		   
	        if(rs.next()) 
	        {
	        	cont = rs.getString("content");
	        	ps.close();
	           return cont;
	       }
	        else 
	        {
	        	ps.close();
	        }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return cont;
		 }	
	}





