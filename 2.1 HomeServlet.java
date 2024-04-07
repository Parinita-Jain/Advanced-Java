package com.itvedant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String colors = getInitParameter("colors");
		//out.print(colors);
		
		String[] colorValues = colors.split(",");
		
		out.print("<form action='validate' method='get'>");
		out.print("<table><tr><td>Name:</td>");
		out.print("<td><input type='text' name='name'/></td>");
		out.print("</tr><tr><td>Marks:</td>");
		out.print("<td><input type='number' name='marks'/></td>");
		out.print("</tr><tr><td>Color:</td><td>");
		out.print("<select name='color'>");
		out.print("<option value='none'>.....</option>");
		
		for(String c : colorValues) {
			out.print("<option>" + c + "</option>");
		}
		
		out.print("</select></td></tr><tr>");
		out.print("<td><input type='submit' value='OK'/></td>");
		out.print("<td><input type='reset'/></td></tr></table></form>");
		
		String dev = getServletContext().getInitParameter("developer");
		out.print("<h6>&copy;" + dev + "</h6>");
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("sample", "sampling context");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
