<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" >
    <title>Document</title>
    <!--
        스타일 속성(X) -> 선택자를 통해서 스타일을 부여한다.
    -->
    <link href="../css/style.css" type="text/css" rel="stylesheet" >
    <style>
    	#footer{
    		width:100px;
    		
    		
    	}
    </style>
</head>

<body>
    
    <!-- --- header block -------------------------------------------------------------------------- -->
    <%-- <jsp:include page="../inc/header.jsp" /> --%>
    
    <!-- --- visual block -------------------------------------------------------------------------- -->
    <div id="visual">
        <div class="content-box1" style="position: relative;">            
           
        </div>
    </div>
    <!-- --- body block -------------------------------------------------------------------------- -->
    <div id="body">
        <div class="content-box1">
            
            <jsp:include page="../inc/aside.jsp" />

            <%-- <main>
                
                <section>
                    <h1>공지사항</h1>

                    <section id="breadcrumb">
                        <h1 class="d-none">경로</h1>
                        <ol>
                            <li>home</li>
                            <li>고객센터</li>
                            <li>공지사항</li>
                        </ol>
                    </section>
                    
                    <section>
                    	<h1>공지사항 검색</h1>
                    	<form>
                    		<select>
                    			<option>제목</option>
                    			<option>작성자</option>
                    			<option>내용</option>
                    		</select>	                        
	                        <input type="text" >
	                        <input type="submit" value="검색" >
	                    </form>
                    </section>
                    
                    <section id="notice">
                        <h1 class="d-none">공지사항 목록</h1>
                        <table>
                            <thead>
                                <tr>
                                    <td class="num">번호</td>
                                    <td class="title">제목</td>
                                    <td class="writer">작성자</td>
                                    <td class="date">작성일</td>
                                    <td class="hit">조회수</td>
                                </tr>
                            </thead>
                            <tbody>
                            
                            <c:forEach var="n" items="${list}">
                                <tr>
                                    <td class="num">${n.id}</td>
                                    <td class="title">
                                    	<a href="detail?id=${n.id}">${n.title}</a>
                                    	<span>[23]</span>
                                    </td>
                                    <td class="writer">newlec</td>
                                    <td class="date">2019-02-18</td>
                                    <td class="hit">255</td>		
                                </tr>
                            </c:forEach>
                               
                            </tbody>
                        </table>
                        <div>
                        	<a href="reg">글쓰기</a>
                        </div>
                    </section>
                    
                    <section id="page-index">
                        <h1 class="d-none">페이지 정보</h1>
                        <div>
                            <span class="color-highlight font-bold">1</span> / 1 pages
                        </div>
                    </section>

                    <section id="pager">
                        <h1 class="d-none">페이저</h1>
                        <div>
                            <div>이전</div>
                            <ul>
                                <li>1</li>
                                <li class="current">2</li>
                                <li>3</li>
                                <li>4</li>
                                <li>5</li>
                            </ul>
                            <div>다음</div>
                        </div>
                    </section>
                </section>
            </main> --%>
            <!-- <? style="clear:left;">막내양</?> -->
        </div>
        
    </div>
    <!-- --- footer block -------------------------------------------------------------------------- -->    
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>