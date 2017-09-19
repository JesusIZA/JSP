package ua.jrc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fN = request.getParameter("fName");	
		String lN = request.getParameter("lName");
		String Profesia = request.getParameter("job");	
		String gender = request.getParameter("gender");
		String age18 = request.getParameter("age18");
		String[] hobbies = request.getParameterValues("hobbies");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h3>Profile PERSON</h3>First name: " + fN + "<br/>Last name: " + lN);
		out.println("<br/>Profesia: " + Profesia + "<br/>Sex: ");
		if(gender == null) gender = "Non";
		if(gender.hashCode() == "M".hashCode()) gender = "Man";
		if(gender.hashCode() == "W".hashCode()) gender = "Woman";
		out.println(gender);
		out.println("<br/>Hobbies: " + Arrays.deepToString(hobbies));
		/*
		for(String h: hobbies){
			out.println("<i>" + h + "</i>");
		}
		*/
		out.println("<br/>Age more than 18: ");
		if(age18 == null) age18 = "No";
		out.println(age18);
		
		out.close();
	}

}
