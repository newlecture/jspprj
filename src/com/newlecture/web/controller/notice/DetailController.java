package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		NoticeDao noticeDao = new OracleNoticeDao();
				
		try {
			request.setAttribute("notice", noticeDao.get(id));
			request.setAttribute("prev", noticeDao.getPrev(id));
			request.setAttribute("next", noticeDao.getNext(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("../WEB-INF/view/notice/list.jsp")
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
		  .forward(request, response);
	}
}
