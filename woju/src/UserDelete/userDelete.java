package UserDelete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DB;

public class userDelete extends HttpServlet {
	private static final long serialVersionUID= 6263271064846372434L;
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
		
		  String userName = request.getParameter("name");
		  
		 if( deleteName(userName))
			 request.getRequestDispatcher("/allusers.jsp").forward(request, response);
		 else 
			 out.print("用户");
			 out.print(userName);
			 out.print("删除失败！！");
		
	}

	public boolean deleteName(String name)
	{
		boolean b=false;
		try
		{
			 Connection conn = null;  
			  conn = (Connection) DB.getcon(conn);
				java.sql.Statement st = conn.createStatement();
				
			String sql="delete from user1_info where username="+"\""+name+"\"";
			
			st.executeUpdate(sql);
			b=true;
		}
		catch(Exception ex)
			{ex.printStackTrace();}
		return b;
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
