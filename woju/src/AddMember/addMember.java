package AddMember;

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

import com.mysql.jdbc.Statement;

import DB.DB;

public class addMember extends HttpServlet {
	private static final long serialVersionUID= 6263971064846372434L;
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

		 response.setContentType("text/html;charset=UTF-8");  //���ø�ʽ����
		  request.setCharacterEncoding("UTF-8");            //���ø�ʽ����
		  PrintWriter out = response.getWriter();
		
		  HttpSession session = request.getSession();
		int  colnum=0;
		String actId = session.getAttribute("id").toString();
		String username = session.getAttribute("loginUser").toString();
				
		try
		  {
			colnum = 4+Integer.parseInt(session.getAttribute("Col").toString());
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}		
		String s =  "m"+Integer.toString(colnum-4);
		
		changeMember(actId,username,colnum,s);
		
		session.setAttribute("actID", actId);
		request.getRequestDispatcher("/addSucceed.jsp").forward(request, response);
		
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
		
		  HttpSession session = request.getSession();
		int  colnum=0;
		String actId = session.getAttribute("id").toString();
		String username = session.getAttribute("loginUser").toString();
				
		try
		  {
			colnum = 4+Integer.parseInt(session.getAttribute("Col").toString());
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}		
		String s =  "m"+Integer.toString(colnum-4);
		
		changeMember(actId,username,colnum,s);
		
		session.setAttribute("actID", actId);
		request.getRequestDispatcher("detial1").forward(request, response);
	}
	
	//不能改成addMember  -------就是不能和servlet重名
		public boolean changeMember(String id,String newMember,int  colNum,String col)
		{
			boolean b=false;
			try
			{
				 Connection conn = null;  
				  conn = (Connection) DB.getcon(conn);
					java.sql.Statement st = conn.createStatement();
					
		//////////**************************!!!!!!!!!!!!!!  col   和    newMember  和 id   的添加区别很大!!!!!!!!!!!!!!!!**************************///
	//   https://zhidao.baidu.com/question/190572413.html			
				int n=st.executeUpdate("update actMember set "+col+"='"+newMember+"' where actId="+id);
				if(n==1)
				{b=true;}
			}
			catch(Exception ex)
				{ex.printStackTrace();}
			return b;
		}
	
	
}


