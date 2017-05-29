package detial1Servlet;

import entity.Member;
import AddMember.addMember;
import DB.DB;
import java.sql.*;
		
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		  
/*		  HttpSession session = request.getSession();
		  actID = session.getAttribute("actId").toString();
		  if(actID!=null||actID!="")
			  session.removeAttribute("actId");
		  else
*/		  actID = request.getParameter("id");
			    
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
		  HttpSession session = request.getSession();
		  String name = "";
	    	if(session.getAttribute("loginUser")!=null)
	    		name = session.getAttribute("loginUser").toString();
		  
		  boolean flag=false;
		  int num=0;
		  out.println("<br><br><br><br><br>");
		  out.println("参与成员:");
		  getMember(actID);
		  String col=null;
		  if(Member.getM1()!=null) {
			  num++;
			  out.println(Member.getM1());
			 if(Member.getM1().equals(name))
				 flag=true;
		  }
		  else  if(col==null)  col="1";
		  if(Member.getM2()!=null) {
			  num++;
			  out.println(Member.getM2());
			  if(Member.getM2().equals(name))
					 flag=true;
		  }
		  else  if(col==null)  col="2";
		  if(Member.getM3()!=null) {
			  num++;
			  out.println(Member.getM3());
			  if(Member.getM3().equals(name))
					 flag=true;
		  }
		  else  if(col==null)  col="3";
		  if(Member.getM4()!=null) {
			  num++;
			  out.println(Member.getM4());
			  if(Member.getM4().equals(name))
					 flag=true;
		  }
		  else  if(col==null)  col="4";
		  if(Member.getM5()!=null) {
			  num++;
			  out.println(Member.getM5());
			  if(Member.getM5().equals(name))
					 flag=true;
		  }
		  else  if(col==null)  col="5";
		  if(Member.getM6()!=null) {
			  num++;
			  out.println(Member.getM6());
			  if(Member.getM6().equals(name))
					 flag=true;
		  }
		  else  if(col==null)  col="6";
		  out.print("<br>");
		  out.print("总计");
		  out.print(num);
		  out.println("人参与");
		  out.print("报名上限：");
		  out.print(Member.getTotalNum());
		  out.println("人");
		  out.print("<br>");
		 // if(Member.getNowNum()<Member.getTotalNum())
		  session.setAttribute("id", actID);
		  session.setAttribute("Col", col);
			  if(name!=null&&name!="")
			  {  				  
				  if(num<Member.getTotalNum())
				  {					  
					  if(flag)
						  out.println("您已报名");
					  else
						  out.println("<a href=\"/woju/servlet/addMember\">我要报名</a>");
					  }
				  else
				  {
					  out.println("名额已满，无法报名");
				  }
			  }
			  else 
				  {
				  	out.println("<a href=\"/woju/login.jsp\">尚未登录，无法报名,去登录</a><br>");
//				  	out.println("<a href=\"/woju/login.jsp\">尚未登录，无法评论</a>");
				  }
			  out.println("<br>");		  
			  out.println("<a href=\"/woju/comment.jsp\">查看评论</a>");	
			  //*********************!!!!!!!!!!!!!!!!!!**********************////
			  //  out.println("<a href='f_index.jsp?id="+rs.getInt("id")+"'>修改</a>");
			  //输出修改按钮，每当点击记录的时候，系统就把对应的id值传到修改所在的页面。
		 
		 }
		
	private void getMember(String actId) {		 
		  Connection con = null;  //һ�����Ӷ���
		  con = (Connection) DB.getcon(con);   //�õ�һ������
		  PreparedStatement ps = null;    //���ڲ������
		  String sql = "select * from actMember where actId ="+actId; 
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
		   ResultSet rs = null;
		   rs = ps.executeQuery();		   
	        if(rs.next()) 
	        {
	        	Member.setTotalNum(rs.getInt(3));
	        	Member.setNowNum(rs.getInt(4));
	        	Member.setM1(rs.getString("m1"));
	        	Member.setM2(rs.getString("m2"));
	        	Member.setM3(rs.getString("m3"));
	        	Member.setM4(rs.getString("m4"));
	        	Member.setM5(rs.getString("m5"));
	        	Member.setM6(rs.getString("m6"));
	        	ps.close();
	       }
	        else 
	        {
	        	ps.close();
	        }
		  } catch (SQLException e) {
		   e.printStackTrace();
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





