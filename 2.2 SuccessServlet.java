package com.itvedant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Success", urlPatterns = { "/success" })
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String marks = request.getParameter("marks");
		String color = request.getParameter("color");
		
		float aggregate = (float)request.getAttribute("aggr");
		
		out.print("<p style='color:" + color + ";'>");
		out.print("Welcome, " + name);
		out.print("<br/><br/>You have scored " + marks
						+ " out of 500");
		out.print("<br/><br/>Your aggregate is " + aggregate + "%");
		out.print("</p>");
		
		String dev = getServletContext().getInitParameter("developer");
		out.print("<h6>&copy;" + dev + "</h6>");
		
		ServletContext ctx = getServletContext();
		String samp = (String)ctx.getAttribute("sample");
		out.print(samp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
