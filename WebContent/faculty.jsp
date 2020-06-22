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
<a href="report.jsp">GENERATE REPORT</a>&nbsp;<a href="login.jsp">LOGIN</a> &nbsp; <a href="leave.jsp">APPLY FOR LEAVE</a>
<%
HttpSession sess = request.getSession(false); 
String Username=(String)sess.getAttribute("Username");
%>

<h1>Welcome <%= Username %></h1>
<label><h2>Faculty Details</h2>
<%
Faculty f=new Faculty();
FacultyLoginDAO a=new FacultyDAOImpl();
f=a.getdetails(Username);
%>
<table border="2">
<tr><td>NAME</td><td><%=f.getTitle() %> <%=f.getFname() %> <%=f.getLname() %></td></tr>
<tr><td>DEPARTMENT</td><td><%=f.getDepartment() %></td></tr>
<tr><td>EMAIL</td><td><%=f.getEmail() %></td></tr>
<tr><td>PHONE</td><td><%=f.getPhone() %></td></tr>
<tr><td>Date Of Birth</td><td><%=f.getDOB() %></td></tr>
<tr><td>Date Of Joining</td><td><%=f.getDOJ() %></td></tr>
<tr><td>ADDRESS</td><td><%=f.getHouse_no() %> ,<%=f.getDistrict() %>, PIN- <%=f.getPin() %>,<%=f.getCity() %>, <%=f.getState()%>,<%=f.getCountry() %> </td></tr>

</table>
</label>
<br><br>
<label><h3>Course Details</h3>
<%
List<String> c=new ArrayList<String>();
CourseDAO b=new CourseDAOImpl();
c=b.coursedetails(Username);
%>

<%
int j=0;
for(int i=0;i<c.size();i+=2)
{
	j++;
%>
<table border="2">
<tr><td><b>Course <%=j%></b></td><td> <%=c.get(i) %> </td>
<td> <%=c.get(i+1) %></td></tr>

</table>
<%} %>
</label>
<br><br><br><br><br><br><br>
<label><h4>Responsibility</h4>
<%
List<responsibility> r=new ArrayList<responsibility>();
responsibilitiesDAO d=new responsibilitiesDAOImpl();
r=d.getresponsibilities(Username);
%>
<%
for(int i=0;i<r.size();i++)
{
%>
<table border="2">
<tr><td><b>Responsibility <%=i+1 %></b></td><td> <%=r.get(i).getR_name() %> </td>
<td> <%=r.get(i).getR_to() %></td></tr>

</table>
<%} %>
</label><br><br><br><br><br><br><br>
<br><br>

</label>
</body>
</html>