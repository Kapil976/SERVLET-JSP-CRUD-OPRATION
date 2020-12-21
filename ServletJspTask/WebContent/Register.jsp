<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration Page</title>
<link rel="stylesheet" href="register.css">
<script type="text/javascript" src="myscript.js"></script>
</head>
<body>

	<div id="main_container">
		<div id="header">Registeration User</div>
		<hr>
		<form action="RegisterationServlet" method="post">
			<div id="main">
				<table id="table_register">
					<p style="color:red; text-align:center;">${name}</p>
					<tr>
						<td>First Name :</td>
						<td><input type="text" placeholder="FirstName"
							name="firstname" id="firstname" pattern="[a-zA-Z ]{3,30}"
							title="Please Enter only Alphabets" required></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><input type="text" placeholder="LastName" name="lastname"
							id="lastname" pattern="[a-zA-Z ]{3,30}"
							title="Please Enter only Alphabets" required></td>
					</tr>
					<tr>
						<td>DOB :</td>
						<td><input type="date" placeholder="Date of Birth" name="dob"
							id="dob" required></td>
					</tr>
					<tr>
						<td>DOJ :</td>
						<td><input type="date" placeholder="Date of Join" name="doj"
							id="doj" required></td>
					</tr>
					<tr>
						<td>Email id :</td>
						<td><input type="email" placeholder="Email id" name="emailid"
							id="emailid"
							pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$"
							required></td>
					</tr>
					<tr>
						<td>Mobile No :</td>
						<td><input type="text" placeholder="Mobile No" name="mobile"
							id="mobile" pattern="[7-9]{1}[0-9]{9}"
							title="Please Provide Valid Number" maxlength="10" required></td>
					</tr>
					<tr>
						<td>Country :</td>
						<td><select name="country" id="country" required>
								<option value="in">India</option>
								<option value="us">United State</option>
								<option value="uk">United Kingdom</option>
						</select></td>
					</tr>
					<tr>
						<td>Username :</td>
						<td><input type="text" placeholder="Username" name="username"
							id="username" maxlength="20" required></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><label><input name="password" id="password" placeholder="Password"
								type="password" onkeyup="check();" minlength="3" maxlength="10" />
						</label></td>
					</tr>
					<tr>
						<td>Confirm Password :</td>
						<td><label><input type="password" placeholder="Confirm Password"
						 id="confirm_password" name="cpassword"
								onkeyup="check();" minlength="3" maxlength="10" /> <span
								id="message"></span> </label></td>
					</tr>
				</table>
				<center>
					<button id="btn_Register" type="submit">Register</button>
					<input type="button" value="cancel" onclick="location.href='Login.jsp'">
					<input type="reset" name="reset" value="Reset">
				</center>
			</div>
		</form>
	</div>

</body>
</html>