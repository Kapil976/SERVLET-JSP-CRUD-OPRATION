<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="forgetpassword.css">
<script type="text/javascript" src="myscript.js"></script>
<title>Reset PAssword</title>
</head>
<body>
	<div id="main_container">
		<div id="header">Reset Password</div>
		<hr>
		<form action="ForgetPasswordServlet" method="post">
			<div id="main">
				<table id="table_login">
				<p style="color: green; text-align: center;">${update}</p>
					<tr>
						<td>Username :</td>
						<td><input type="text" placeholder="Username" name="username"
							required></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><label><input name="password" id="password"
								type="password" onkeyup="check();" required/> </label></td>
					</tr>
					<tr>
						<td>Confirm Password :</td>
						<td><label><input type="password"
								name="confirm_password" id="confirm_password" name="cpassword"
								onkeyup="check();" /> <span id="message" min="3" max="8" required></span>
						</label></td>
					</tr>
				</table>
				<center>
					<button id="btn_Update" type="submit">Update Password</button>
					<input type="button" value="cancel" onclick="location.href='Login.jsp'">
				</center>
			</div>
		</form>
	</div>

</body>
</html>