package com.itvedant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Validate", urlPatterns = { "/validate" })
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//String colors = getInitParameter("colors");
		//out.print(colors.charAt(0));
		
		List<String> errorList = new ArrayList<String>();
		
		String name = request.getParameter("name");		
		if(name.equals("")) {
			errorList.add("Name not provided");
		}
		
		String marks = request.getParameter("marks");
		if(marks.equals("")) {
			errorList.add("Marks not provided");
		}
		
		String color = request.getParameter("color");
		if(color.equals("none")) {
			errorList.add("Color not provided");
		}
		
		if(errorList.isEmpty()) {
			float m = Float.parseFloat(marks);
			
			//local variable
			float aggregate = (m / 500) * 100;		
			
			//add local variable in request
			request.setAttribute("aggr", aggregate);
			
			request.getRequestDispatcher("success").forward(request, response);
		}
		else {
			//response.sendRedirect("home?redirect=yes");
			out.print("<ul style='color:red;'>");
			for(String err : errorList) {
				out.print("<li>" + err + "</li>");
			}
			out.print("</ul>");
			
			request.getRequestDispatcher("home").include(request, response);
		}
		
		String dev = getServletContext().getInitParameter("developer");
		out.print("<h6>&copy;" + dev + "</h6>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
