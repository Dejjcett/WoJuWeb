package activitySubmit;
import DB.DB;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class activitySubmit extends HttpServlet {
	private static final long serialVersionUID= 8263971064846072434L;
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("text/html;charset=utf-8");  
		  request.setCharacterEncoding("utf-8");         
		  PrintWriter out = response.getWriter();
			String Content=null; 
			String releaser=null; 
			String actabstract=null;
	//		String Username=null;
			String deadtime=null;
			String starttime=null;
			String actName=null;
			String type=null;
			int member = 0;
		  out.println("<head><title>活动发布</title></head>");
		  out.println("<h1>活动已发布</h1>");
		  Content = request.getParameter("content");
		  releaser = request.getParameter("releaser");
		  actabstract = request.getParameter("actabstract");
		  actName = request.getParameter("acttivityName");
		  type = request.getParameter("activitytype");
		  deadtime = request.getParameter("deadtime");
		  starttime = request.getParameter("starttime");
		  
		  try {
		      member = Integer.valueOf(request.getParameter("member")).intValue();
		  } catch (NumberFormatException e) {
		      e.printStackTrace();
		  }
		  out.println("<b>活动名：<b>");
		  out.println(actName);
		  out.println("<br>");
		  out.println("<b>发布人：<b>");
		  out.println(releaser);
		  out.println("<br>");
		  out.println("活动类型：");
		  out.println(type);
		  out.println("<br>");
		  out.println("报名截止时间：");
		  out.println(deadtime);
		  out.println("<br>");
		  out.println("活动开始时间：");
		  out.println(starttime);
		  out.println("<br>");
		  out.println("成员数：");
		  out.println(member);
		  out.println("<br>");
		  out.println("活动简介：");
		  out.println(actabstract);
		  out.println("<br>"); out.println("<br>");  out.println("<br>");
		  out.println("活动详情：");
		  out.println(Content);
		  out.println("<br>");
		  
		  int actID = DB.numData("activity_info");   //必须是静态成员函数  
		  out.print("<b>该活动Id为:</b>");
		  out.println(actID+1);
		  out.println("<br><br>");
		  
		  insertDate(actID,actName,deadtime,starttime,type,member,actabstract,Content,releaser);
	  insertMember(actID,releaser,member);
		  out.println("<a href=\"/woju/activity.jsp\">查看活动</a>");
	}
	
	 private void insertDate( int id,String actname,String deadtime,String starttime,String type,int member, String actabstract,String content,String releaser) {
		  Connection con = null;  
		  String sId =  Integer.toString(id+1);
		  con = (Connection) DB.getcon(con);  
		  PreparedStatement ps = null;
		  String sql = "insert into  activity_info values(?,?,?,?,?,?,?,?,?)";  
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
			  ps.setString(1, sId);
			  ps.setString(2, actname);
			   ps.setString(3, deadtime);
			   ps.setString(4, starttime);
			   ps.setString(5, type);
			   ps.setInt(6, member);
			   ps.setString(7, actabstract);
			   ps.setString(8, content);
			   ps.setString(9, releaser);
		   ps.executeUpdate();
		   ps.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }	
	 private void insertMember( int id,String releaser, int totalNum) {
		  Connection con = null;  
		  String sId =  Integer.toString(id+1);
		  con = (Connection) DB.getcon(con);  
		  PreparedStatement ps = null;
		  String sql = "insert into  actMember values(?,?,?,?,?,?,?,?,?,?)";  
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
			  ps.setString(1, sId);
			  ps.setString(2, releaser);
			   ps.setInt(3, totalNum);
			   ps.setInt(4, 0);
			   ps.setString(5, null);
			   ps.setString(6, null);
			   ps.setString(7, null);
			   ps.setString(8, null);
			   ps.setString(9, null);
			   ps.setString(10, null);
		   ps.executeUpdate();
		   ps.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }	
}
