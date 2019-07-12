

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		int id = 0;
		id = Integer.parseInt(request.getParameter("id"));
		PrintWriter pw = response.getWriter();
		
		if(id!=0) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			EmpDAOImpl ei = (EmpDAOImpl)ctx.getBean("obj1");
			Employee e = ei.getEmployee(id);
			
			if(e!=null) {
				request.setAttribute("emp", e);
				request.getRequestDispatcher("ConfirmUpdate.jsp").forward(request, response);
			}
			else {
				pw.println("<h1>Sorry Invalid Credentials...</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				rd.include(request, response);
			}
		}
		else {
			pw.println("<h1>Enter Complete Credentials..</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
			rd.include(request, response);
		}
	}

}
