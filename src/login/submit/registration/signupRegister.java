package login.submit.registration;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupRegister
 */
@WebServlet("/signupRegister")
public class signupRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//PrintWriter out = response.getWriter();  
		response.setContentType("text/html");
		 FacultyLoginDAO cd=new FacultyDAOImpl();
		 Faculty f=new Faculty();
		 SimpleDateFormat Formatter= new SimpleDateFormat("dd-MM-yyyy");
		Date DOB=null;
		 Date DOJ=null;
		 String Title= request.getParameter("title");
		 String Fname=request.getParameter("fname");
		 String Lname=request.getParameter("lname");
		 String Username=request.getParameter("username");
		 String Password=request.getParameter("password");
		 String[] Department=request.getParameterValues("department");
		 String Email=request.getParameter("email");
		 String Phone=request.getParameter("phone");
		 String dob=request.getParameter("DOB");
		try {
		// DOB = new Date(Integer.parseInt(byear),Integer.parseInt(bmonth), Integer.parseInt(bday));
			 DOB=Formatter.parse(dob);
		}
		catch(Exception e){
			 
		}
		 String House_no=request.getParameter("houseno");
		 String City=request.getParameter("city");
		 String District=request.getParameter("district");
		 String Pin=request.getParameter("pin");
		 String State=request.getParameter("state");
		 String Country=request.getParameter("country");
		 String doj=request.getParameter("DOJ");
		try {
		DOJ=Formatter.parse(doj);
		}
		catch(Exception e){
		  
		}
		
		if(Title=="" || Fname=="" || Lname=="" || Username=="" || Password=="" || Department[0]=="" || Email=="" || Phone=="" || dob=="" || House_no=="" || City=="" || District=="" || Pin=="" || State=="" || Country=="" || doj=="") {
		
			request.setAttribute("msg", "please fill all the fields");
		RequestDispatcher d=request.getRequestDispatcher("Register.jsp");
		d.forward(request,response);
			
		}
		
		else {
			f.setTitle(Title);
			f.setFname(Fname);
			f.setLname(Lname);
			f.setUsername(Username);
			f.setPassword(Password);
			f.setDepartment(Department[0]);
			f.setEmail(Email);
			f.setPhone(Phone);
			f.setDOB(DOB);
			f.setHouse_no(House_no);
			f.setCity(City);
			f.setDistrict(District);
			f.setState(State);
			f.setPin(Pin);
			f.setCountry(Country);
			f.setDOJ(DOJ);
			
		}
		
			int status=cd.insertFacultyLogin(f);
			RequestDispatcher d=request.getRequestDispatcher("Register.jsp");
			d.forward(request,response);
	}

}
