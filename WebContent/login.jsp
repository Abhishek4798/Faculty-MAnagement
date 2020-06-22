<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
P{
margin-top:300px;
}
</style>
</head>
<body>
<form action="loginRegister" method="post" align="center">
<table>

<tr><td>UserName: </td><td><input type="text" name="username"></td></tr>
<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" name="submit" value="Login"></td><td><a href="Register.jsp">Registration</a></td></tr>
</table>

<br><br><br>
<tr><td>${msg }</td></tr>
</form>

</body>
</html>