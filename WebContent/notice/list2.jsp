<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	FileInputStream fis = new FileInputStream("D:\\java-1902\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
	Scanner fscan = new Scanner(fis, "UTF-8");
	
	String line = "";
	
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">    
    <title>Document</title>
</head>
<body>
    <h1>뉴렉처 온라인</h1>

    <ul>
        <li>학습가이드</li>
        <li>강좌선택</li>
        <li>AnswerIs</li>
    </ul>

    <form>
        <label>과정검색</label>
        <input type="text" >
        <input type="submit" value="검색" >
    </form>

    <ul>
        <li>HOME</li>
        <li>로그인</li>
        <li>회원가입</li>
    </ul>
    
    <ul>
        <li>마이페이지</li>
        <li>고객센터</li>
    </ul>   

    <h2>고객센터</h2>

    <h3>고객센터메뉴</h3>

    <ul>
        <li>공지사항</li>
        <li>자주하는 질문</li>
        <li>수강문의</li>
        <li>이벤트</li>
    </ul>
    
    <h3>협력업체</h3>
    
    <ul>
        <li>노트펍스</li>
        <li>나무랩연구소</li>
        <li>한빛미디어</li>
    </ul>

    <h2>공지사항</h2>

    <ol>
        <li>home</li>
        <li>고객센터</li>
        <li>공지사항</li>
    </ol>
    
    <table>
        <thead>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>
        </thead>
        <tbody>
        		
	
        <%while(fscan.hasNextLine()){ 
        	line = fscan.nextLine();
			Notice n = new Notice(line.split(","));
			%>
            <tr>
                <td><%=n.getId() %></td>
                <td><%=n.getTitle() %></td>
                <td><%=n.getWriterId() %></td>
                <td><%=n.getRegDate() %></td>
                <td><%=n.getHit() %></td>		
            </tr>
        <%} %>
           
        </tbody>
    </table>
    
    <div>
        1 / 1 pages
    </div>

    <div>
        <div>이전</div>
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
            <li>5</li>
        </ul>
        <div>다음</div>
    </div>

    <h2>회사정보</h2>

    <dl>
        <dt>주소:</dt>
        <dd>서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호</dd>
        <dt>관리자메일:</dt>
        <dd>admin@newlecture.com</dd>
        <dt>사업자 등록번호:</dt>
        <dd>132-18-46763</dd>
        <dt>통신 판매업:</dt>
        <dd>신고제 2013-서울강동-0969 호</dd>
        <dt>상호:</dt>
        <dd>뉴렉처</dd>
        <dt>대표:</dt>
        <dd>박용우</dd>
        <dt>전화번호:</dt>
        <dd>070-4206-4084</dd>
    </dl>
    
    <div>
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information
    </div>
</body>
</html>
<%
	fscan.close();
	fis.close();
%>