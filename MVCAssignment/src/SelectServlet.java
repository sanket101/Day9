

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
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
		String id = request.getParameter("id");
		//String psw = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		
		if(!id.equals("")) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			EmpDAOImpl ei = (EmpDAOImpl)ctx.getBean("obj1");
			Employee e = ei.getEmployee(Integer.parseInt(id));
			
			if(e != null) {
//				request.setAttribute("name", e);
//				request.getRequestDispatcher("Select.jsp").forward(request, response);
				
				pw.println("Name : " + e.getName() + "<br>");
				pw.println("Number : " + e.getNumber()+ "<br>");
				pw.println("Role : " + e.getRole()+ "<br>");
				pw.println("Password : " + e.getPassword()+ "<br>");
				pw.println("IsAdmin : " + e.isAdmin());
			}
			else {
				pw.println("<h1>Sorry Invalid Credentials...</h1>");
			}
		}
		else {
			pw.println("Please enter complete details");
		}
		RequestDispatcher rd = request.getRequestDispatcher("Select.jsp");
		rd.include(request, response);
		
	}

}
