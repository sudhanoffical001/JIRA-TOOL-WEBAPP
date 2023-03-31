package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Cookie[] arrcook = req.getCookies();
		String name = "";
		boolean result = false;
		if (arrcook != null) {
			for (Cookie cook : arrcook) {
				if (cook.getName().equals("loginname")) {
					name = cook.getValue();
					result = true;
					break;
				}
				if (!name.isEmpty()) {
					int index = name.indexOf("1");
					name = name.substring(0, index);
					req.setAttribute("name", name);
				}
				RequestDispatcher dispatcher = null;
				if (result) {
					dispatcher = req.getRequestDispatcher("Home.jsp");
					dispatcher.forward(req, resp);
				}

				else {

					req.setAttribute("msg", "Sorry session timed out!");
					dispatcher = req.getRequestDispatcher("Login.jsp");
					dispatcher.include(req, resp);
				}

			}
		}
	}
}
