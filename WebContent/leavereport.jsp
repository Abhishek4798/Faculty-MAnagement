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
<body><form action="show" method="post">
<a href="report.jsp">GENERATE REPORT</a>&nbsp;<a href="login.jsp">LOGIN</a> 

<table border="2">
<tr><td><b>UserName</b></td><td><b>Type</b></td><td><b>From</b></td><td><b>To</b></td></tr>
<%
int j=0;
List<leave> L=new ArrayList<leave>();
L =(ArrayList<leave>)request.getAttribute("llist");
for(int i=0;i<L.size();i++)
{
	j++;
%>

<tr><td><%=L.get(i).getUser_name()%></td><td> <%=L.get(i).getType() %> </td>
<td> <%=L.get(i).getL_from() %></td><td> <%=L.get(i).getL_to() %></td></tr>


<%} %>
</table>

</form>
</body>
</html>