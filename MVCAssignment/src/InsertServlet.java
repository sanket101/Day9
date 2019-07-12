

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
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String role = request.getParameter("role");
		String password = request.getParameter("psw");
		String admin = request.getParameter("isAdmin");
		boolean isAdmin = false;
		
		PrintWriter pw = response.getWriter();
		String temp = "true";
		
		if(!name.equals("") && !number.equals("") && !role.equals("") && !password.equals("") && !admin.equals("")) {
			
			if(admin.equals(temp)) {
				isAdmin = true;
			}
			Employee e = new Employee(name, number, role, password, isAdmin);
			//EmpDAOImpl ei = new EmpDAOImpl();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			EmpDAOImpl ei = (EmpDAOImpl)ctx.getBean("obj1");
			boolean isSuccess = ei.insertEmployee(e);
			
			if(isSuccess) {
				pw.println("Insertion Successful");
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccessful.jsp");
				rd.include(request, response);
			}
			else {
				pw.println("Invalid Credentials!!!");
				RequestDispatcher rd = request.getRequestDispatcher("Insert.jsp");
				rd.include(request, response);
			}
		}
		else {
			pw.println("Please enter complete details");
			RequestDispatcher rd = request.getRequestDispatcher("Insert.jsp");
			rd.include(request, response);
		}
		
	}

}
