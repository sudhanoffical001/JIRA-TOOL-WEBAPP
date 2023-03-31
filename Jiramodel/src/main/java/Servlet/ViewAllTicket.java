package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import Helper.Inserthelper;
import Pojo.Jira;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/ViewAllTicket")
public class ViewAllTicket  extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	         @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("txt/html");
                
                
                ArrayList<Jira> al=new ArrayList<Jira>(); 
                		
                    Inserthelper.viewticket(al);
                  
                req.setAttribute("jiralist", al);
                
                RequestDispatcher dispatcher=req.getRequestDispatcher("ViewTicket.jsp");
                dispatcher.forward(req, resp);
              
              }
}
