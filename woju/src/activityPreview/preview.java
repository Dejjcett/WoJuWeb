package activityPreview;
import DB.DB;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class preview extends HttpServlet {
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

		response.setContentType("text/html;charset=utf-8");  
		  request.setCharacterEncoding("utf-8");         
		  PrintWriter out = response.getWriter();
		  
		  
		  
		  out.println("<HTML>");
		  out.println("  <BODY>");
		  
		  out.println("<head><title>活动预览</title></head>");
		  out.println("<h1>活动预览</h1>");
		  String Content = request.getParameter("content");
		  out.println(Content);
		  
		  out.println("<a href=\"/wjw/myactivity.jsp\">关闭预览</a>");
		  
			out.println("  </BODY>");
			out.println("</HTML>");
          out.flush();
  		out.close();
		  
	}

	
}
