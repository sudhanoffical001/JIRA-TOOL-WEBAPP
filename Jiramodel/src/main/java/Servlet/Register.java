package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import Helper.Inserthelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		String firstname = req.getParameter("firstname");
		String Lastname = req.getParameter("Lastname");
		String Mobileno = req.getParameter("Mobile");
		String email = req.getParameter("Email");
		String password = req.getParameter("password");

		boolean result = Inserthelper.register(firstname, Lastname, Mobileno, email, password);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
		if (result) {
			dispatcher.forward(req, resp);
		} 
		else {
			pw.print("Successfully not registred");
			dispatcher.include(req, resp);		
		}
	}

}
