package login.submit.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Course1
 */
@WebServlet("/Course1")
public class Course1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	/*	CourseDAO c=new CourseDAOImpl();
		try {
			List<Course> C=c.list();
			List<String> s=new ArrayList<>();
			s.add("hey");
			s.add("hi");
			s.add("hiiiii");
			
			request.setAttribute("listcourse", C);
			int i=1;
		while(i<C.size()) {
			System.out.println((C.get(i)).getCourse_name());
			System.out.println(i);
			
			i++;
		}
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("course.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e){
			System.out.print(e);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String add=request.getParameter("add");
	//	String remove=request.getParameter("remove");
		CourseDAO c=new CourseDAOImpl();
		Course C=new Course();
		if(add.contentEquals("add")) {
			String c_id=request.getParameter("c_id");
			String course_name=request.getParameter("course_name");
			C.setC_id(c_id);
			C.setCourse_name(course_name);
			c.addcourse(C);
			//System.out.print(C.getC_id());
			RequestDispatcher d=request.getRequestDispatcher("course.jsp");
			d.forward(request,response);
		
		}
		else if(add.contentEquals("remove")) {
		String r_c[]=request.getParameterValues("course");
		c.removecourse(r_c[0]);
			System.out.print(r_c[0]);
			RequestDispatcher d=request.getRequestDispatcher("course.jsp");
			d.forward(request,response);
		}
		else if(add.contentEquals("assign")) {
			String[] assign_course=request.getParameterValues("assign_course");
			String[] assign_faculty=request.getParameterValues("assign_faculty");
			String[] year=request.getParameterValues("year");
			String[] semester=request.getParameterValues("semester");
			String[] batch=request.getParameterValues("batch");
			int i=c.assigncourse(assign_faculty[0],assign_course[0],year[0],semester[0],batch[0]);
				if(i==0) {
					request.setAttribute("msg", "Course Assigned");
				RequestDispatcher d=request.getRequestDispatcher("course.jsp");
				d.forward(request,response);
				}
				else {
					request.setAttribute("msg", "Course Already assigned");
					RequestDispatcher d=request.getRequestDispatcher("course.jsp");
					d.forward(request,response);
				}
				
			}
	}

}
