package login.submit.registration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class responsibility1
 */
@WebServlet("/responsibility1")
public class responsibility1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public responsibility1() {
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
		String responsibility=request.getParameter("responsibility");
		responsibilitiesDAO r=new responsibilitiesDAOImpl();
		
		
	//	System.out.println(responsibility);
		if(responsibility.contentEquals("add")) {
			String r_id=request.getParameter("r_id");
			String r_name=request.getParameter("r_name");
			//System.out.println(r_id);
			r.addresponsibility(r_id, r_name);
			RequestDispatcher d=request.getRequestDispatcher("responsibility.jsp");
			d.forward(request,response);
		}
		
		else if(responsibility.contentEquals("remove")) {
			String[] r_id=request.getParameterValues("responsibilities");
			//System.out.println("remove1");
			System.out.print(r_id[0]);
			r.removeresponsibility(r_id[0]);
			RequestDispatcher d=request.getRequestDispatcher("responsibility.jsp");
			d.forward(request,response);
			}
		else if(responsibility.contentEquals("assign")) {
			String[] assign_responsibility=request.getParameterValues("assign_responsibility");
			String[] assign_faculty=request.getParameterValues("assign_faculty");
			String r_from=request.getParameter("r_from");
			String r_to=request.getParameter("r_to");
			
			System.out.println(assign_faculty[0]+" "+assign_responsibility[0]);
			
			r.assignresponsibility(assign_faculty[0],assign_responsibility[0],r_from,r_to);
				
				
			}
	}

}
