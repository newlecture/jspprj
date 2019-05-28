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
    <title>Document</title>
    <!--
        스타일 속성(X) -> 선택자를 통해서 스타일을 부여한다.
    -->
    <link href="../css/style.css" type="text/css" rel="stylesheet" >
</head>

<body>
    
    <!-- --- header block -------------------------------------------------------------------------- -->
    <header id="header">        
        <div class="content-box">
            
            <h1 id="logo">뉴렉처 온라인</h1>
            <section>            
                <h1 class="d-none">머릿말</h1>            
                
                <nav id="main-menu">
                    <h1 class="d-none">메인메뉴</h1>
                    <ul>
                        <li><a href="">학습가이드</a></li>
                        <li><a href="">강좌선택</a></li>
                        <li><a href="">AnswerIs</a></li>
                    </ul>
                </nav>

                <section id="lecture-search-form">
                    <h1 class="d-none">강좌선택 폼</h1>    
                    <form>
                        <label>과정검색</label>
                        <input type="text" >
                        <input type="submit" value="검색" >
                    </form>
                </section>
                
                <nav id="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li>HOME</li>
                        <li>로그인</li>
                        <li>회원가입</li>
                    </ul>
                </nav>
                
                <nav id="direct-menu">
                    <h1 class="d-none">자주사용하는 메뉴</h1>
                    <ul>
                        <li>마이페이지</li>
                        <li>고객센터</li>
                    </ul>   
                </nav>
            </section>
        </div>
    </header>
    <!-- --- visual block -------------------------------------------------------------------------- -->
    <div id="visual">
        <div class="content-box" style="position: relative;">            
           
        </div>
    </div>
    <!-- --- body block -------------------------------------------------------------------------- -->
    <div id="body">
        <div class="content-box">
            
            <aside>
               
                <h1 id="aside-title">고객센터</h1>

                <nav id="customer-menu">
                    <h1>고객센터메뉴</h1>    
                    <ul>
                        <li><a href="">공지사항</a></li>
                        <li><a href="">자주하는 질문</a></li>
                        <li><a href="">수강문의</a></li>
                        <li><a href="">이벤트</a></li>
                    </ul>
                </nav>
                
                <nav id="coworker">
                    <h1>협력업체</h1>
                    <ul>
                        <li>노트펍스</li>
                        <li>나무랩연구소</li>
                        <li>한빛미디어</li>
                    </ul>
                </nav>
            </aside>

            <main>
                
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
	                    <form action="edit" method="post">
	                    	<h1>공지사항 내용</h1>
	                    	<table>                    		
	                    		<tbody>
	                    			<tr>
	                    				<th>제목</th>
	                    				<td><input name="title" value="${notice.title }" ></td>
	                    			</tr>
	                    			<tr>
	                    				<th>작성일</th>
	                    				<td></td>
	                    			</tr>
	                    			<tr>
	                    				<th>내용</th>
	                    				<td><textarea name="content" >${notice.content }</textarea></td>
	                    			</tr>
	                    		</tbody>
	                    	</table>
	                    	<div>
	                    		<input type="hidden" name="id" value="${notice.id }" >
	                    		<input type="submit" value="저장" >
	                    		<a href="detail?id=${notice.id}">취소</a>
	                    	</div>	
	                    </form>
                    </section>
                    
                    

                   
                </section>
            </main>
            <!-- <? style="clear:left;">막내양</?> -->
        </div>
        
    </div>
    <!-- --- footer block -------------------------------------------------------------------------- -->
    <footer id="footer">
        <div class="content-box">
<!--         
        <section>
            <h1>회사정보</h1>

            <section>
                <h1>소유권자 정보</h1>
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
            </section>
            
            <section>
                <h1>저작권 정보</h1>
                <div>
                    Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information
                </div>
            </section>
        </section> -->
        </div>
    </footer>
</body>
</html>