package Servlet;

	import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.http.Cookie;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	public class Logout extends HttpServlet{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			PrintWriter writer=resp.getWriter();
			
			
			Cookie[] arrcookie = req.getCookies();
			String name="";
			Cookie Org_cookie=null;
			boolean result = false;
		
			for (Cookie cookie : arrcookie) {
				if (cookie.getName().equals("Logincookie")) {
					Org_cookie=cookie;
					result = true;
					break;
				}
			}
			if(Org_cookie!=null) {
			Org_cookie.setMaxAge(0);
			
			resp.addCookie(Org_cookie);
			}
		
			
			if(result) {
			RequestDispatcher	dispatcher = req.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, resp);		
				writer.print("There is some problem");
				dispatcher.include(req, resp);
			}
		}

	}

