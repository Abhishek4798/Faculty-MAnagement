package login.submit.registration;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
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
		
		String show=request.getParameter("show");
		responsibilitiesDAO R=new responsibilitiesDAOImpl();
		leaveDAO L=new leaveDAOImpl();
		CourseDAO C=new CourseDAOImpl();
		String r_from=request.getParameter("r_from");
		String r_to=request.getParameter("r_to");
		SimpleDateFormat Formatter= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date R_FROM=null;
		java.util.Date R_TO=null;
		if(show.contentEquals("show responsibilities")) {
			System.out.println("srespons");
			try {
				R_FROM = Formatter.parse(request.getParameter("r_from"));
				R_TO = Formatter.parse(request.getParameter("r_to"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<responsibility> l=R.show(R_FROM, R_TO);
			/*for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i).getR_name());
			}*/
			request.setAttribute("rlist", l);
			request.getRequestDispatcher("responsibilityreport.jsp").forward(request, response);
		}
		else if(show.contentEquals("show leaves")) {
			System.out.println("sleaves");
			try {
				R_FROM = Formatter.parse(request.getParameter("l_from"));
				R_TO = Formatter.parse(request.getParameter("l_to"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<leave> l=L.showleaves(R_FROM, R_TO);
		/*	for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i).getUser_name());
			}*/
			request.setAttribute("llist", l);
			request.getRequestDispatcher("leavereport.jsp").forward(request, response);
		}
		else if(show.contentEquals("show courses")) {
			System.out.println("scourses");
			String year=request.getParameter("year");
			String[] sem=request.getParameterValues("semester");
			
			List<courserecord> c=C.showcourses(year, sem[0]);
		for(int i=0;i<c.size();i++) {
				System.out.println(c.get(i).getUser_name()+c.get(i).getC_name()+c.get(i).getBatch());
			}
			request.setAttribute("clist", c);
		request.getRequestDispatcher("coursereport.jsp").forward(request, response);
		}
	}

}
