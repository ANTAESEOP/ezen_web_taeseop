<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자 정의 css 호출  -->
	<link rel="stylesheet" href="/jspweb/css/main.css">
	
</head>
<body>
	<%@include file="header.jsp"%>

	<!-- 대문 [ 이미지 슬라이드 - 캐러셀 ] -->	
	<div id="maincarousel" class="carousel slide" data-bs-ride="carousel">
		<div class="carousel-inner"> <!-- 이미지 삽입되는 구역 -->
			<div class="carousel-item active"> <!-- 이미지 active : 현재 보이는 이미지 -->
		<img src="img/m1.jpg" class="d-block w-100" alt="...">
	</div>
	<div class="carousel-item">
		<img src="img/m2.jpg" class="d-block w-100" alt="...">
	</div>
	<div class="carousel-item">
		<img src="img/m3.jpg" class="d-block w-100" alt="...">
	</div>
	</div>

  
  <!-- 왼쪽 버튼 -->
  <button class="carousel-control-prev" type="button" data-bs-target="#maincarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <!-- 오른쪽 버튼 -->
  <button class="carousel-control-next" type="button" data-bs-target="#maincarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	<!-- 광고 / 이벤트  -->


	<!-- 제품 출력 -->
	<div class="container"> <!-- 전체 박스권 -->
	
		<h6 class="box_title">Most Popular</h6>
	
		<div class="itemlist"> <!-- 일정 구역 -->
		

			
		</div> <!-- 일정 구역 -->
	</div> <!-- 전체 박스권  -->

	<script src="js/admin/index.js" type="text/javascript" ></script>
	
</body>
</html>

<!-- 
	<div class="webbox">
	<img alt="" src="img/ip.gif" width="100%">
	<img alt="" src="img/ip2.gif" width="100%">
	<h3> 메인 페이지 </h3> 
-->