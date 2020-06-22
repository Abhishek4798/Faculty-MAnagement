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
 * Servlet implementation class loginRegister
 */
@WebServlet("/loginRegister")
public class loginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginRegister() {
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
		FacultyLoginDAO cd= new FacultyDAOImpl();
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		FacultyLogin f=cd.getFacultyLogin(Username,Password);
		HttpSession sess = request.getSession(); 
		sess.setAttribute("Username", Username);
		if(submitType.equals("Login") && f.getUsername()!=null && f.getUsername().contentEquals("Admin")){
			response.sendRedirect("course.jsp");
		}
		
		else if(submitType.equals("Login") && f.getUsername()!=null) {
			response.sendRedirect("faculty.jsp");
		}
		
		else if(submitType.equals("Login") && f.getUsername()==null) {
			System.out.println(f.getUsername());
			System.out.println(f.getPassword());
			request.setAttribute("msg", "username or password wrong");
			RequestDispatcher d=request.getRequestDispatcher("login.jsp");
			d.forward(request,response);
		}
		
	}

}
