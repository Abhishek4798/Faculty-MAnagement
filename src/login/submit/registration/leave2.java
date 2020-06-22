package login.submit.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class leave2
 */
@WebServlet("/leave2")
public class leave2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leave2() {
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
		doGet(request, response);
		leaveDAO l=new leaveDAOImpl();
		String approve=request.getParameter("approve");
		String select[] = request.getParameterValues("id"); 
		if(approve.contentEquals("approve")) {
			System.out.println("approve");
			for(int i=0;i<select.length;i++){
				l.addleave(select[i]);
			}
		}
		else if(approve.contentEquals("cancel")) {
		System.out.println("cancel");
		for(int i=0;i<select.length;i++){
			l.cancelleave(select[i]);
		}
		}
		//System.out.println(select[0]);
		//System.out.println(select[1]);
		//SSystem.out.println(select[2]);
		
		RequestDispatcher d=request.getRequestDispatcher("admin.jsp");
		d.forward(request,response);
	}

}
