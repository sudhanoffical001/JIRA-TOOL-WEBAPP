package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import Helper.Inserthelper;
import Pojo.Jira;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowCreateList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        
	   ArrayList<String>  al=new ArrayList<String>();
	       
	    Inserthelper.ViewUser(al);
	    
	    req.setAttribute("userinfo", al);
	    
	    RequestDispatcher dispatcher= req.getRequestDispatcher("CreateNewJira.jsp");
	    dispatcher.forward(req, resp);
	   
		
	}

}
