package Servlet;

import java.io.IOException;

import Helper.Inserthelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class DeleteTicket extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
         @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	 int id=0;
      			id = Integer.parseInt(req.getParameter("id"));
    
     		String message="";
     		boolean result=false;
     		if(id!=0)
     			result= Inserthelper.DeleteTicket(id);
     		
     		RequestDispatcher dispatcher=req.getRequestDispatcher("/ViewTicket");
     		if(result)
     			message= "Delete is successfull!";
     		else
     			message="Delete is unsuccessfull pls try again!";
     		
     		req.setAttribute("msg", message);
     		dispatcher.forward(req, resp);
     		
     	}

        	 

}

