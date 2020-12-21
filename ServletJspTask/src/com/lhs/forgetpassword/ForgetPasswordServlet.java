package com.lhs.forgetpassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forgetPassword()");
		Connection connection = ConnectionManager.getConnection();
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");	
		String check= "select username from test_trainee_reg where username = '" + username + "'";
		try {
			ps = connection.prepareStatement(check);
			rs = ps.executeQuery();
			boolean flag = false;
			if (rs.next()) {
				flag = true;
			}
			if(flag) {

				String query = "Select * from test_trainee_reg where username='" + username + "'";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				String password=request.getParameter("password");
				query = "update test_trainee_reg set  PASSWORD= ? where username='" + username + "'";
				ps = connection.prepareStatement(query);
				System.out.println("Query--->" + query);
				ps.setString(1, password);						
				ps.executeUpdate();
				System.out.println("Record Updated....");
				request.setAttribute("update", "Password is Successfully Updated !!!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("Username Not Exits !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
