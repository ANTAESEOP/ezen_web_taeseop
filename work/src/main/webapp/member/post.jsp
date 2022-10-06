<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 게시판 </h3>
	<form action="/work/member/post" method="post">
		제목 	:  	<input type="text" name="ptitle"> <br>
		작성자 	: 	<input type="text" name="pwriter"> <br>
		내용 	: 	<input type="text" name="pcontent"> <br>
		비밀번호 	: 	<input type="text" name="ppassword"> <br>
		<input type="submit" value="게시물 작성">
	</form>
	
</body>
</html>