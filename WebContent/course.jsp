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
&nbsp;<a href="responsibility.jsp">RESPONSIBILITY</a> 
<form action="Course1" method="post">
<h1>ASSIGN/ADD/REMOVE COURSES</h1>

<label><U><b>Add course</b></U></label><br>
<label>Course ID <input type="text" name="c_id"></label><br>
<label>Course Name<input type="text" name="course_name"></label><br>
<input type="submit" name="add" value="add">

<br><br><br>
<%
CourseDAO c=new CourseDAOImpl();
FacultyLoginDAO f=new FacultyDAOImpl();
try {
	List<Course> C=c.list();
	List<String> F=f.facultylist();
	
	request.setAttribute("listcourse", C);
request.setAttribute("facultylist", F);
	
	//RequestDispatcher dispatcher=request.getRequestDispatcher("course.jsp");
	//dispatcher.forward(request, response);
}
catch(Exception e){
	System.out.print(e);
}
%>
<b><u>REMOVE COURSES</u></b><br>
Select Course<select class="Drop-Down" style="width: 250px" name="course">
<c:forEach items="${listcourse}" var="course">
<option value="${course.c_id}">${course.course_name}</option>
</c:forEach>
</select><br>
<input type="submit" name="add" value="remove">
<br><br><br><br>

<b><u>ASSIGN COURSES</u></b><br><br>
Select Course<select class="Drop-Down" style="width: 250px" name="assign_course">
<c:forEach items="${listcourse}" var="course">
<option value="${course.c_id}">${course.course_name}</option>
</c:forEach>
</select><br>
Select Faculty<select class="Drop-Down" style="width: 250px" name="assign_faculty">
<c:forEach items="${facultylist}" var="faculty">
<option value="${faculty}">${faculty}</option>
</c:forEach>
</select><br>
Select Year<select class="Drop-Down" style="width: 250px" name="year">
<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>
</select><br>
Select Batch<select class="Drop-Down" style="width: 250px" name="batch">
<option value="y16">y16</option>
<option value="y17">y17</option>
<option value="y18">y18</option>
<option value="y19">y19</option>
<option value="y20">y20</option>
</select><br>
Select Semester<select class="Drop-Down" style="width: 250px" name="semester">
<option value="odd">odd</option>
<option value="even">even</option>
<option value="summer">summer</option>

</select><br>
<input type="submit" name="add" value="assign">

<br>
${msg }


<br>
</form>
</body>
</html>