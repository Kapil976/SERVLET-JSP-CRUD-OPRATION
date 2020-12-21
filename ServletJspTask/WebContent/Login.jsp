<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="login.css">
<title>Login Page</title>
</head>
<body>

	<div id="main_container">
		<div id="header">Login</div>
		<hr>
		<form action="LoginServlet" method="post">
			<div id="main">
				<table id="table_login">
						<p style="color: green; text-align: center;">${name}</p>
						<p style="color: red; text-align: center;">${login}</p>
					<tr>
						<td>Username :</td>
						<td><input type="text" placeholder="Username" name="username"
							required></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" placeholder="Password"
							name="password" required></td>
					</tr>
				</table>
				<center>
					<button id="btn_login" type="submit"
						style="background-color: #e7e7e7; color: black; font-size: 12px; padding: 4px 40px;">Login</button>
				</center>
				<br>
			</div>
		</form>
		<div>
			<button id="btn_Register" type="button"
				onclick="location.href='Register.jsp'">Register</button>
			<button id="btn_fpass" type="submit"
				onclick="location.href='ForgetPassword.jsp'" style="float: right;">Forget
				Password</button>
		</div>
	</div>

</body>
</html>