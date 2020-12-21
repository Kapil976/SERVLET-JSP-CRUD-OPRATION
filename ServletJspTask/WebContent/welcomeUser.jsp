<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="login.css">
<title>Welcome </title>
</head>
<body><div id="main_container">
	    <h1><u>Welcome ${name} </u></h1>
	    <%
         Date date = new Date();
         out.print( "<h2>" +date.toString()+"</h2>");
     	 %>
     	 <br><br>
     	  <p>FisrtName: ${firstName} </p>
     	   <p>LastName: ${lastName} </p>
     	    <p>DOB:< ${dob} /p>
     	     <p>DOJ: ${doj} </p>
     	      <p>EmailID: ${email} </p>
     	       <p>Mobile: ${mobile} </p>
     	        <p>Country: ${country} </p>
     	        
     	 <form action="Login.jsp" method="get">
     	  <button>Logout</button>
     	  </form>
     	</div>
</body>
</html>