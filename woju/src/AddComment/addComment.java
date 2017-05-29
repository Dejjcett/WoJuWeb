package AddComment;

import DB.DB;
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

import DB.DB;

public class addComment extends HttpServlet {
	private static final long serialVersionUID= 6261971064846372434L;
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
		 doPost(request, response);
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
		  
		  String actid=session.getAttribute("id").toString();
		  String reviewer=session.getAttribute("loginUser").toString();
		  String Comm = request.getParameter("comment");
		  int total = DB.numComm(actid);
		  out.println(Comm);
		  out.println("<br>");
		  out.println(reviewer);
		  out.println("<br>");
		  out.println(actid);
		  out.println("<br>");
		  out.println(total);
		  out.println("<br>");
		  out.println("您的评论发表成功！");
		  insertComment( actid,reviewer, total,Comm);
//		  request.removeAttribute("comment");
		  /*
		   * request.getRequestDispatcher  这条语句跳转回去刷新后会出现表单重复提交
		   * 为什么？？？？？？？？？？？？？？？？？？？？？？？？？？？
		   */
	  request.getRequestDispatcher("/comment.jsp").forward(request, response);  
		  
	}
	 private void insertComment( String actid,String reviewer,int totalNum, String comment) {
		  Connection con = null;  
		  String cId =  Integer.toString(totalNum+1);
		  con = (Connection) DB.getcon(con);  
		  PreparedStatement ps = null;
		  String sql = "insert into  commit_info values(?,?,?,?)";  
		  ps = (PreparedStatement) DB.getpsta(con, sql);
		  try {
			  ps.setString(1, cId);
			  ps.setString(2, reviewer);
			  ps.setString(3, actid);
			  ps.setString(4, comment);
		   ps.executeUpdate();
		   ps.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }	
}
