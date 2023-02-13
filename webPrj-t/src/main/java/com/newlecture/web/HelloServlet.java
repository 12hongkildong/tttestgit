package com.newlecture.web;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//PrintStream out = new PrintStream(response.getOutputStream());
		
		String c = request.getParameter("c");
		
		int count = 10;
		if(c!=null)
			count = Integer.parseInt(c);
		
		
		for(int i=0; i<count; i++)
			out.println("안녕하세요 servlet");
		
		
		
	}
}
