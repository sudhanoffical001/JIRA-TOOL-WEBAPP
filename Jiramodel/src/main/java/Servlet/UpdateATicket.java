package Servlet;

import java.io.IOException;
import Helper.Inserthelper;
import Sending.Mail;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateATicket extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String Assignee = req.getParameter("assignee");
		String Reporter = req.getParameter("reportee");
		String Heading = req.getParameter("problem");
		String Notify = req.getParameter("notify");
		String Status = req.getParameter("status");
		
		boolean result = Inserthelper.Update(Assignee,Reporter,Heading,Notify,Status,id);
		
		boolean sendEmail=false;
		if(("Dev Done").equalsIgnoreCase(Status))
			sendEmail=true;
		
		if(sendEmail) {
			System.out.println("inside mail block");
			Mail.send(id,Notify);
			}
		
		
		RequestDispatcher dispatcher  =req.getRequestDispatcher("/ViewTicket");
		if(result) {
			req.setAttribute("msg", "successfully upadted");
			dispatcher.forward(req, resp);
			
		}else {
			req.setAttribute("msg", "Not updated");
			dispatcher.include(req, resp);
		}
		          
		      
   	             
	
	}
	

}
