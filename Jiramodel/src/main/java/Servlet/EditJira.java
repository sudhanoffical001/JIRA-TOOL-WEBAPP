package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.IntegerSyntax;

import Helper.Inserthelper;
import Pojo.Jira;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditJira extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		ArrayList<Jira> a1 = Inserthelper.EditOneticket(id);

		Jira jr = a1.get(0);
		req.setAttribute("jira detial", jr);

		ArrayList<String> al = new ArrayList<String>();
		Inserthelper.ViewUser(al);
		req.setAttribute("userinfo", al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
		dispatcher.forward(req, resp);

	}

}
