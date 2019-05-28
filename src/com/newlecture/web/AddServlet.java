package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {	
	
	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
		int result = 0;
		
		String result_ = request.getParameter("result");
		
		if(result_ != null)
			result = Integer.parseInt(result_);
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("    <div>");
		out.write("       <label>x : </label>");
		out.write("       <input type=\"text\" name=\"x\" />");
		out.write("   </div>");
		out.write("   <div>");
		out.write("       <label>y : </label>");
		out.write("       <input type=\"text\" name=\"y\" />");
		out.write("    </div>");
		out.write("   <div>");				
		out.write("       <input type=\"submit\" value=\"����\" />");
		out.write("   </div>");
		out.write("   <div>");
		out.write("    	��� : ");
		out.printf("%d", result);
		out.write("    </div>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		Integer x = 0;
		Integer y = 0;
		
		if(x_ != null)
			x= Integer.parseInt(x_);
		if(y_ != null)
			y= Integer.parseInt(y_);
		
		int result = x + y;
		
				
		// �������� �ٸ� ������ ��û�ϴ� ���
		// 1. ����Ʈ redirect
		response.sendRedirect("add?result="+result);
		// 2. ������ forward
		//request.getRequestDispatcher("add").forward(request, response);
		// GET -> GET  ,   POST->POST
	}
	*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
		int result = 0;

		if(request.getMethod().equals("POST")) {
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");
			
			Integer x = 0;
			Integer y = 0;
			
			if(x_ != null)
				x= Integer.parseInt(x_);
			if(y_ != null)
				y= Integer.parseInt(y_);
			
			result = x + y;
		}
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("    <div>");
		out.write("       <label>x : </label>");
		out.write("       <input type=\"text\" name=\"x\" />");
		out.write("   </div>");
		out.write("   <div>");
		out.write("       <label>y : </label>");
		out.write("       <input type=\"text\" name=\"y\" />");
		out.write("    </div>");
		out.write("   <div>");				
		out.write("       <input type=\"submit\" value=\"����\" />");
		out.write("   </div>");
		out.write("   <div>");
		out.write("    	��� : ");
		out.printf("%d", result);
		out.write("    </div>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");	
		
	}
	
}
