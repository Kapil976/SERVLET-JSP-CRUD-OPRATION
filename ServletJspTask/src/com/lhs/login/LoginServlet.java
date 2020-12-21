package com.lhs.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhs.databaseconnection.ConnectionManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet()");
		Connection connection = ConnectionManager.getConnection();
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		String check= "select username,password from test_trainee_reg where username = '" + username + "' and password = '" +password+ "'";
		try {
			ps = connection.prepareStatement(check);
			rs = ps.executeQuery();
			boolean flag = false;
			if (rs.next()) {
				flag = true;
			}
			if(flag) {
				out.println("<h1> Login Success</h1>");
				String query = "Select * from test_trainee_reg where username='" + username + "'";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				if (rs.next()) {
					String userName=rs.getString(1);
					String firstName=rs.getString(2);
					String lastName=rs.getString(3);
					String dob=rs.getString(4);
					String doj=rs.getString(5);
					String email=rs.getString(6);
					String mobile=rs.getString(7);
					String country=rs.getString(9);
					
				
					request.setAttribute("firstName", firstName);
					request.setAttribute("lastName", lastName);
					request.setAttribute("dob", dob);
					request.setAttribute("doj", doj);
					request.setAttribute("email", email);
					request.setAttribute("mobile", mobile);
					request.setAttribute("country", country);
				}
				request.setAttribute("name", username);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcomeUser.jsp");
				requestDispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("login","Username is not Exsist");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
