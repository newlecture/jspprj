<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- http://serverip/jspPrj/admin/member/list.jsp -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
		</tr>
		<%-- <%for(int i=0; i<2; i++){ %>
		<tr>
			<td><%= ((Map<String, String>)members.get(i)).get("id") %></td>
			<td><%= members.get(i).get("name") %></td>
		</tr>
		<%} %> --%>
				
		<c:forEach var="m" items="${members}">
		<tr>
			<td>${m.id}</td>
			<td>${m.name}</td>
		</tr>
		</c:forEach>

		<%for(Map<String, String> m : ((List<Map<String, String>>)request.getAttribute("members"))){ %>
		<tr>
			<td><%= m.get("id") %></td>
			<td><%= m.get("name") %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>