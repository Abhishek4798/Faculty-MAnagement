<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" %>
    <%@page import="login.submit.registration.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="login.jsp">LOGIN</a> &nbsp; <a href="report.jsp">GENERATE REPORT</a> &nbsp; <a href="admin.jsp">LEAVE APPLICATIONS</a>
&nbsp;<a href="course.jsp">COURSES</a> 
<form action="responsibility1" method="post">
<h1>ASSIGN/ADD/REMOVE RESPONSIBILITY</h1>

<label><U><b>Add Responsibility</b></U></label><br>
<label>Responsibility ID<input type="text" name="r_id"></label><br>
<label>Responsibility Name<input type="text" name="r_name"></label><br>
<input type="submit" name="responsibility" value="add">

<br><br><br>
<%
responsibilitiesDAO r=new responsibilitiesDAOImpl();
FacultyLoginDAO f=new FacultyDAOImpl();
try {
	List<responsibility> R=r.rlist();
	List<String> F=f.facultylist();
	request.setAttribute("listresponsibility", R);
request.setAttribute("facultylist", F);
/*for(int i=0;i<R.size();i++){
		System.out.println(R.get(i).getR_id()+" "+R.get(i).getR_name());
	}*/
	//RequestDispatcher dispatcher=request.getRequestDispatcher("course.jsp");
	//dispatcher.forward(request, response);
}
catch(Exception e){
	System.out.print(e);
}
%>
<b><u>REMOVE Responsibility</u></b><br>

Select Responsibility<select class="Drop-Down" style="width: 250px" name="responsibilities">
<c:forEach items="${listresponsibility}" var="responsibility">
<option value="${responsibility.r_id}">${responsibility.r_name}</option>
</c:forEach>
</select><br>
<input type="submit" name="responsibility" value="remove">
<br><br><br><br>

<b><u>ASSIGN Responsibility</u></b><br><br>
Select Responsibility<select class="Drop-Down" style="width: 250px" name="assign_responsibility">
<c:forEach items="${listresponsibility}" var="responsibility">
<option value="${responsibility.r_id}">${responsibility.r_name}</option>
</c:forEach>
</select><br>
Select Faculty<select class="Drop-Down" style="width: 250px" name="assign_faculty">
<c:forEach items="${facultylist}" var="faculty">
<option value="${faculty}">${faculty}</option>
</c:forEach>
</select><br>
<label>From<input type="text" name="r_from">dd-MM-yyyy</label><br>
<label>To<input type="text" name="r_to">dd-MM-yyyy</label><br>
<input type="submit" name="responsibility" value="assign">


<br>
</form>
</body>
</html>