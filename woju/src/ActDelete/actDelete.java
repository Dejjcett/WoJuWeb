package ActDelete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DB;

public class actDelete extends HttpServlet {
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
		
		  String actId = request.getParameter("id");
		  
		delete(actId);
		
		request.getRequestDispatcher("/activity.jsp").forward(request, response);
		
	}

	public boolean delete(String id)
	{
		boolean b=false;
		try
		{
			 Connection conn = null;  
			  conn = (Connection) DB.getcon(conn);
				java.sql.Statement st = conn.createStatement();
				
			String sql1="delete from activity_info where activityID="+id;
			String sql2="delete from actMember where actId="+id;
			String sql3="delete from commit_info where actId="+id;
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
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
