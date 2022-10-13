<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자 정의 css 호출 -->
	<link rel="stylesheet" href="/jspweb/css/header.css">
	<meta name="viewport" content="width=device-width,initial-scale=1">
			<!-- font awesome 글머리 기호[ 아이콘 ] -->
	<script src="https://kit.fontawesome.com/b8a7fea4d4.js"></script>
	
	
</head>
<body>

	<div class="webbox"> <!-- 웹페이지 박스권 -->
		
		<div class ="hd_top"> <!-- 상단메뉴 -->
			<div> <!--  로고 -->	
				<span class="hd_title">
				<a href="/jspweb/index.jsp">Phone Shop </a> 
				</span>
			</div>

	<!-- 세션 호출 [ JSP방식 = 템플릿마다 다름 ( JSP vs 리엑트 ) -->
			<% 
				// JSP 스트립트 태그
				String loginid = (String)session.getAttribute("mid");
			%> 

			<ul class="hd_sub">
			<!-- 비로그인 메뉴 -->
			<%if(loginid == null){%>
				<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
				<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
				
			<!-- 로그인 메뉴 // 세션 -->
			<% }else{ %>
				<li> <%=loginid %> 님 안녕하세요 </li>
				<li> <a href="/jspweb/member/logout.jsp"> 로그아웃 </a> </li>
			<%}		%>
			
			<!-- 공통 메뉴  -->
				<li> <a href="/jspweb/member/info.jsp">마이쇼핑</a> </li>
				<li> <a href="/jspweb/board/list.jsp">고객센터</a> </li>			
			</ul> <!-- 상단 메뉴 end -->
		</div>
		<ul class="hd_menu"> <!-- 하단 헤더 -->
			<li><a href="#">인기</a></li>
			<li><a href="#">상의</a></li>
			<li><a href="#">아우터</a></li>
			<li><a href="#">바지</a></li>
			<li><a href="#">원피스</a></li>
			<li><a href="#">스커트</a></li>
			<li><a href="#">스니커즈</a></li>
			<li><a href="#">신발</a></li>
			<li><a href="#">가방</a></li>
			<li class="searchbox">
				<span>
					<input>
					<i class="fas fa-search"></i>
				</span>
				<i class="fas fa-shopping-cart"></i>
			</li>
		</ul>
	</div>
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>

<!-- 
	레이아웃 , 박스권 , 구역
	<div> : block [ 한 줄 차지 ]
		vs
	<span> : inline
	
	<ul>


 -->