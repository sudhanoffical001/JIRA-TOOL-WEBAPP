package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Helper.Inserthelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String email = req.getParameter("Uname");
		String Password = req.getParameter("Pass");
		RequestDispatcher rd = null;

		String result = Inserthelper.loginhelp(email, Password);
		req.setAttribute("username", result);
		if (result.isEmpty()) {
			rd = req.getRequestDispatcher("Login.jsp");
		} else {
			Cookie cookie = new Cookie("Logincookie", result + 123);
			resp.addCookie(cookie);
			rd = req.getRequestDispatcher("Home.jsp");
		}
		if (result.isEmpty()) {
			//pw.print("<head><body><style>background color: red;<h2>Login failed</h2></style></body></html>");
			rd.include(req, resp);
		} else {
			rd.forward(req, resp);
		}
	}

}
