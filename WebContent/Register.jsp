<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="signupRegister" method="post">
<h1>Register</h1>
<br>${msg }
<br><br><br>
<label>Title<select class="Drop-Down" style="width: 250px" name="title">
<option value="Mr.">Mr.</option>
<option value="Mr.">Mrs.</option>
<option value="Ms.">Ms.</option>
<option value="Shri.">Shri.</option>
<option value="Dr.">Dr.</option>
<option value="Prof.">Prof.</option>
</select></label><br><br>
<label>First Name :<input type="text" name="fname"></label><br><br>
<label>Last Name :<input type="text" name="lname"></label><br><br>
<label>UserName :<input type="text" name="username"></label><br><br>
<label>Password<input type="text" name="password"></label><br><br>
<label>Department :<select class="Drop-Down" style="width: 250px" name="department">
<option value="CSE">Computer Science and Engineering</option>
<option value="ECE">Electronics and Communication Engineering</option>
<option value="P">Physics</option>
<option value="M">Mathematics</option>
<option value="HSS">Humanities and Social Science</option>
<option value="MME">Mechanical-Mechatronics Engineering</option>
<option value="O">Other</option>
</select></label><br><br>
<label>Email_id :<input type="text" name="email"></label><br><br>
<label>Phone-No. :<input type="text" name="phone"></label><br><br>
<label>Date of Birth <input type="text" name="DOB"> dd-MM-yyyy</label><br><br>
<label>Address Details <br>House no.     <input type="text" name="houseno"><br>City   <input type="text" name="city"> <br>District     <input type="text" name="district"><br>
PIN       <input type="text" name="pin"><br>State      <input type="text" name="state"><br> Country     <input type="text" name="country">
</label><br><br>
<label>Date of Joining <input type="text" name="DOJ"> dd-MM-yyyy</label><br><br>
<input type="submit" name="register" value="Register">
</form>
</body>

</html>