<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" %>
    <%@page import="login.submit.registration.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.*" %>
    <%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="login.jsp">LOGIN</a> &nbsp;  
<form action="show" method="post">
<b><u>REPORT </u></b><br>
<h1>Show Responsibility</h1><br>From<input type="text" name="r_from">dd-MM-yyyy<br>
To<input type="text" name="r_to">dd-MM-yyyy<br>
<input type="submit" name="show" value="show responsibilities">

<br><br><br><br>
<h2>Show Leaves</h2><br>From<input type="text" name="l_from">dd-MM-yyyy<br>
To<input type="text" name="l_to">dd-MM-yyyy<br>
<input type="submit" name="show" value="show leaves"><br><br><br><br>
<h3>Show Courses</h3><br>Year<input type="text" name="year"><br>Semester<select class="Drop-Down" style="width: 250px" name="semester">
<option value="odd">odd</option>
<option value="even">even</option>
</select><br>
<input type="submit" name="show" value="show courses">
</form>
</body>
</html>