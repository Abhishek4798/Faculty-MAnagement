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
<body><a href="login.jsp">LOGIN</a> &nbsp; <a href="report.jsp">GENERATE REPORT</a> &nbsp; <a href="course.jsp">COURSES</a>
&nbsp;<a href="responsibility.jsp">RESPONSIBILITY</a> 
<form action="leave2" method="post">
<label><h1>Leave Requests</h1></label>
<%
leaveDAO l=new leaveDAOImpl();
List<leave> L=new ArrayList<>();
L=l.leavelist();



%>

<%
for(int i=0;i<L.size();i++)
{
%>
<table border="2">
<tr><td><input type="checkbox" name="id" value=<%=L.get(i).getUser_name() %>> </td><td><b><%=i+1 %></b></td><td><%=L.get(i).getUser_name() %></td><td> <%=L.get(i).getL_from() %> </td>
<td> <%=L.get(i).getL_to() %></td><td><%=L.get(i).getType() %></td>
</tr>


</table>
<%} %>
<br><br>
<input type="submit" name="approve" value="approve"></button>
<input type="submit" name="approve" value="cancel"></button>
</form>
</body>
</html>