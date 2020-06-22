package login.submit.registration;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class leave1
 */
@WebServlet("/leave1")
public class leave1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leave1() {
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
		String leave=request.getParameter("apply");
		leave l=new leave();
		leaveDAO L=new leaveDAOImpl();
		SimpleDateFormat Formatter= new SimpleDateFormat("dd-MM-yyyy");
		if(leave.contentEquals("applyleave")) {
			System.out.println("apply"+request.getParameter("user_name"));
			l.setUser_name(request.getParameter("user_name"));
			java.util.Date L_FROM=null;
			java.util.Date L_TO=null;
			try {
				L_FROM = Formatter.parse(request.getParameter("l_from"));
				L_TO = Formatter.parse(request.getParameter("l_to"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.setL_from(L_FROM);
			l.setL_to(L_TO);
			l.setType(request.getParameter("leave_type"));
			
			L.applyLeave(l);
			RequestDispatcher d=request.getRequestDispatcher("leave.jsp");
			d.forward(request,response);
		}
		
		else if(leave.contentEquals("status")) {
			System.out.println("check");
			String status=L.checkStatus(request.getParameter("user_name"));
			System.out.println(status);
			request.setAttribute("msg", status);
			RequestDispatcher d=request.getRequestDispatcher("leave.jsp");
			d.forward(request,response);
		}
	}

}
