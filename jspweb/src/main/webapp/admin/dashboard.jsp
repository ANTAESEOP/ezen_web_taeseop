<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/dashboard.css" rel="stylesheet">
</head>
<body>

    <!-- 관리자 페이지 -->
    <!-- 만약에 세션이 없거나 관리자가 아니면 -->
    <% String mid = (String)session.getAttribute("mid") ;
          if(mid == null || !mid.equals("admin")){
             response.sendRedirect("../index.jsp");
          }
          
    %>
       <!-- marquee : 텍스트 슬라이드(전광판) /scrollamount :속도-->
       <marquee scrollamount="10"> 공지사항 표시되는 위치 </marquee>
       
       <!-- 사이드바  열고 닫기-->
      <div class="sidebar">
         <h1> ADMIN MENU </h1>
         <ul class="side_menu">
            <li class="side_item"><a onclick="pagechange('regist.jsp')">제품등록</a>
            <li class="side_item"><a href="#">제품목록</a>
            <li class="side_item"><a href="#">재고관리</a>
            <li class="side_item"><a href="#">주문관리</a>
            <li class="side_item"><a href="#">매출관리</a>
            <li class="side_item"><a href="#">회원목록</a>
            <li class="side_item"><a href="#">배송관리</a>
            
            <li class="side_item"><a href="/jspweb/member/logout.jsp">로그아웃</a>
            
         </ul>
      </div>
      
      <div id="mainbox">
      	<h3>asdasdasqwdqwdqwddasdasdasdadsasdasdasd</h3>
      
      </div>
      
      
		<script type="text/javascript" src="../js/admin/dashboard.js"></script>
		<!-- JQUERY 라이브러리 -->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>