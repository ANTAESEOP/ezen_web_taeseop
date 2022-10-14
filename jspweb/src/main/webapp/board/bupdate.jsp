<%@page import="model.dto.dao.BoardDao"%>
<%@page import="model.dto.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

		<!-- 썸머노트 API -->
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<%@include file="../header.jsp"%>
	<div class="webbox">
		<form enctype="application/x-www-form-urlencoded">
		 	제목 : <input type="text" name="btitle"><br>
 			내용 <textarea id="summernote" name="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile"> <br>
			<!-- form 태그 안에서 button 사용시 type 필수로 넣기 -->
			<button type="button" onclick="bupdate()"> 수정 </button>
		</form>	
	</div>
	
	<!-- 썸머노트 JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>	
	
	<script type="text/javascript" src="../js/board/bupdate.js"></script>
	
</body>
</html>