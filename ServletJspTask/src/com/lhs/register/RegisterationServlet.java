package com.lhs.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhs.databaseconnection.ConnectionManager;

/**
 * Servlet implementation class RegisterationServlet
 */
@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("userRegistartion()");
		Connection connection = ConnectionManager.getConnection();
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("username");
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		//date of birth
		String dob=request.getParameter("dob");  
		System.out.println(dob);
		
		//date of joining
		String doj=request.getParameter("doj");
		//eamil id
		String emailId=request.getParameter("emailid");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("cpassword");
		String country=request.getParameter("country");					
		String checkUsername = "select username from test_trainee_reg where username = '" + userName + "'";
		try {
			ps =  connection.prepareStatement(checkUsername);
			rs = ps.executeQuery();
			boolean flag = false;
			if (!rs.next()) {
				flag = true;
			}
			if(flag) {
				String insertTableSQL = "INSERT INTO test_trainee_reg" + "(USERNAME,FIRST_NAME,LAST_NAME,DOB,DOJ,EMAIL,MOBILE_NO,PASSWORD,COUNTRY_CODE) VALUES"
						+ "(?,?,?,?,?,?,?,?,?)";
				System.out.println("insertTableSQL---->" + insertTableSQL);
				ps = connection.prepareStatement(insertTableSQL);
				ps.setString(1,userName);
				ps.setString(2, firstName);
				ps.setString(3,lastName);
				//ps.setString(4,date1);
				ps.setDate(4, java.sql.Date.valueOf(dob));
				ps.setDate(5, java.sql.Date.valueOf(doj));
				ps.setString(6, emailId);
				ps.setString(7,mobile);
				ps.setString(8, password);
				ps.setString(9,country);
				ps.executeUpdate();
				System.out.println("New Record add successfully");
				String name="Registration is success";
				request.setAttribute("name", name);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				String name="User is already Exsist";
				request.setAttribute("name", name);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.jsp");
				requestDispatcher.forward(request, response);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
