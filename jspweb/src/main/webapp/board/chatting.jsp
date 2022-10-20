<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<!--  로그인 회원 아이디 숨기기 -->
	<input type="hidden" class="mid" value="<%=loginid%>">
	
	<div class="webbox">
		<h3> 채팅 </h3>
		<div class="contentbox"></div> <!-- 받은메시지 출력 구역 -->
		<textarea rows="" cols="" class="msgbox"></textarea> <!-- 메세지 입력 구역 -->
		<button type="button" onclick="send()">보내기</button> <!-- 메세지 본는 버튼 -->
	</div>
	
	<script src="../js/board/chatting.js" type="text/javascript"></script>

</body>
</html>