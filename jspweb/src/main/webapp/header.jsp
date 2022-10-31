<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB STORY</title>

	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- 사용자 정의 css 호출  -->
	<link rel="stylesheet" href="/jspweb/css/header.css">
	<!-- 폰트어썸 [ 아이콘 ] -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	
</head>
<body>

	<div class="webbox"> <!-- 웹페이지 박스권 -->
		<div class ="hd_top"> <!-- 상단메뉴 -->
			<div> <!--  로고 -->	
				<span class="hd_title">
				<a href="/jspweb/index.jsp" class="nav-link">Phone Shop </a> 
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
				<li> <a href="/jspweb/member/login.jsp" class="nav-link">로그인</a> </li>
				<li> <a href="/jspweb/member/signup.jsp" class="nav-link">회원가입</a> </li>
			<% }else if(loginid.equals("admin")){ %>
               <li> <a href="/jspweb/admin/dashboard.jsp" class="nav-link">관리자</a></li>   <!-- 관리자 페이지 -->
                   
				
			<!--  로그인 메뉴 세션  -->
			<% }else{ %>
				<li> <%=loginid %> 님 안녕하세요 </li>
				<li> <a href="/jspweb/member/logout.jsp" class="nav-link"> 로그아웃 </a> </li>
			<%}		%>
			
			<!-- 공통 메뉴  -->
				<li> <a href="/jspweb/member/info.jsp" class="nav-link">마이쇼핑</a> </li>
				<li> <a href="/jspweb/board/list.jsp" class="nav-link">고객센터</a> </li>			
			</ul> <!-- 상단 메뉴 end -->
		</div>
		<ul class="hd_menu"> <!-- 하단 헤더 -->
			<li><a href="/jspweb/board/chatting.jsp" class="nav-link">채팅방</a></li>
			<li><a href="/jspweb/board/api.jsp" class="nav-link">공공데이터</a></li>
			<li><a href="#" class="nav-link">아우터</a></li>
			<li><a href="#" class="nav-link">바지</a></li>
			<li><a href="#" class="nav-link">원피스</a></li>
			<li><a href="#" class="nav-link">스커트</a></li>
			<li><a href="#" class="nav-link">스니커즈</a></li>
			<li><a href="#" class="nav-link">신발</a></li>
			<li><a href="#" class="nav-link">가방</a></li>
			<li class="searchbox">
				<span>
					<input>
					<i class="fas fa-search"></i>
				</span>
				<i class="fas fa-shopping-cart"></i>
			</li>
		</ul>
	</div>
	
	
		<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>

<!-- 
	헤더파일 [ 모든 페이지에서 호풀되는 파일 ] 
		경로 :
				/jspweb/board.chatting.jsp
				/ : 최 상위 경로 = localhost:8080
			j
				현재경로


 -->