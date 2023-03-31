package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Helper.Inserthelper;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Createticket extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		String Assignee = req.getParameter("assignee");
		String Reporter = req.getParameter("reportee");
		String Heading = req.getParameter("problem");
		String Notify = req.getParameter("notify");
		String Status = req.getParameter("status");
		

		boolean Ticket = Inserthelper.createticket(Assignee, Reporter, Heading, Notify, Status);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
		if (Ticket) {
			dispatcher.forward(req, resp);
		} else {
			dispatcher.include(req, resp);
			printWriter.print("Not submitted successfully");
		}

	}

}
