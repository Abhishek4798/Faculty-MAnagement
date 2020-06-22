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
<tr><td><b>UserName</b></td><td><b>C_Name</b></td><td><b>Batch</b></td></tr>
<%
int j=0;
List<courserecord> C=new ArrayList<courserecord>();
C =(ArrayList<courserecord>)request.getAttribute("clist");
for(int i=0;i<C.size();i++)
{
	j++;
%>

<tr><td><%=C.get(i).getUser_name()%></td><td> <%=C.get(i).getC_name() %> </td>
<td> <%=C.get(i).getBatch() %></td></tr>


<%} %>
</table>

</form>
</body>
</html>