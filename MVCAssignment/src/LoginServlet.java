

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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String id = request.getParameter("employeeId");
		String psw = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		
		if(!id.equals("") && !psw.equals("")) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			EmpDAOImpl ei = (EmpDAOImpl)ctx.getBean("obj1");
			Employee e = ei.getEmployee(Integer.parseInt(id));
			
			if(e != null && e.isAdmin() == true) {
				request.setAttribute("name", e.getName());
				request.getRequestDispatcher("LoginSuccessful.jsp").forward(request, response);
			}
			else {
				pw.println("<h1>Sorry Invalid Credentials...</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}
		else {
			pw.println("Please enter complete details");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
