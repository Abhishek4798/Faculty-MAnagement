<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="report.jsp">GENERATE REPORT</a>&nbsp;<a href="login.jsp">LOGIN</a> &nbsp; <a href="faculty.jsp">PROFILE</a>
<form action="leave1" method="post">
<%String u=session.getAttribute("Username").toString();


%>
<input type="hidden" name="user_name" value="<%=u%>" />
<h1><b>Leave Application</b></h1>
<label>FROM <input type="text" name="l_from">dd-MM-yyyy</label><br>
<label>TO<input type="text" name="l_to">dd-MM-yyyy</label><br>
</select><br>
Select Leave Type<select class="Drop-Down" style="width: 250px" name="leave_type">
<option value="CL">CL</option>
<option value="PL">PL</option>
<input type="submit" name="apply" value="applyleave"><br><br>
<input type="submit" name="apply" value="status">
<br>${msg }
</select>
</form>
</body>
</html>