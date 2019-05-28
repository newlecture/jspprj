package com.newlecture.web.admin.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet{ //  http://servler/admin/member/list
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		List<Map<String, String>> members = new ArrayList<>();
		//List members = new ArrayList<>();
		Map<String, String> member; 

		member = new HashMap<>();
		member.put("id", "dragon");
		member.put("name", "손오공");
		members.add(member);
		
		member = new HashMap<>();
		member.put("id", "moon");
		member.put("name", "문재인");
		members.add(member);
		
		Notice notice = new Notice(1, "hello", "newlec", new Date(), 2);
		notice.setComment(member);
		
		// 공유 저장 공간 = 상태 저장 공간
		// application, session. request
		request.setAttribute("members", members);
		request.setAttribute("x", 10);
		request.setAttribute("member", member);
		request.setAttribute("y", new int[]{3,4,5});
		request.setAttribute("notice",notice);
		
		request.getRequestDispatcher("list.jsp")
				  .forward(request, response);
		
	}
}
