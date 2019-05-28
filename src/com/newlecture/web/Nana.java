package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// /hello?cnt=3    -> "3"
		// /hello?			-> "" 
		// /hello				-> null
		
		String cnt_ = request.getParameter("cnt");
		Integer cnt = 0;
		
		if(cnt_ != null)
			cnt = Integer.parseInt(cnt_);
		
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<cnt; i++)
			out.println("Welome Ȩ!!~~~<br >");
	}
}
