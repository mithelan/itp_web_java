package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.supplier;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out = response.getWriter();
			String search = request.getParameter("search");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ITP","root","root");
			String Query="select * from requests where uname='"+request.getParameter("search")+"'";
			Statement s=(Statement) con.createStatement();
			ResultSet rs = s.executeQuery(Query);
			
			out.println("<table>");
			out.println("<tr><td>S1No</td><td>uname</td><td>password</td><td>comname</td><td>address</td><td>email</td></tr></td><td>mobnumber</td></tr>");
			while(rs.next()){
				out.println("<tr><td>'"+rs.getString(1)+"'</td><td>'"+rs.getString(2)+"'</td><td>'"+rs.getString(3)+"'</td><td>'"+rs.getString(4)+"'</td><td>'"+rs.getString(5)+"'</td><td>'"+rs.getString(6)+"'</td><td>'"+rs.getString(7)+"'</td>");
		
				
			}
			out.println("</table>");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	}

