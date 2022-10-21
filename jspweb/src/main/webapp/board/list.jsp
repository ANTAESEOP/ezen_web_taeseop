<%@page import="model.dto.dao.BoardDao"%>
<%@page import="model.dto.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../../header.jsp"%>
	<div class="webbox">
		<a href="write.jsp"> 글쓰기 </a>
	
		<!-- 5. 게시물 수 표시 -->
		<div> 게시물 수 : <span class="totalsize"></span></div>
		
		<!-- 6. 화면에 표시할 게시물 수  -->
		<div>
			<select class="listsize" onchange="blistsize()">
				<option value="5"> 5 </option>
				<option value="10"> 10 </option>
				<option value="15"> 15 </option>
				<option value="20"> 20 </option>
			</select>
		</div>
		
		
		
		
		<table class="btalbe table">
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th>작성자</th> 
				<th> 작성일 </th> <th> 조회수 </th>
			</tr>
		</table>
		
		<div class="pagebox">
		
		
		
		</div>
		
		<!--  4. 검색처리 -->
		<div>
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.content">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text" placeholder="검색어">
			<button type="button" onclick="bsearch()">검색</button>
		</div>
		
		
	</div>
	
	
	<script type="text/javascript" src="../js/board/list.js"></script>

	<!-- JSP로 테이블 표시   [ 서블릿,js 제외한 ] -->
<%-- 		<table>
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th>
			</tr>
			<%  // 스크립트 태그 : html에 java 작성할수 있는 공간
			
			ArrayList<BoardDto> list 
				= BoardDao.getInstance().getlist();
			
			for( int i = 0 ; i<list.size() ; i++ ){
			%>
				<tr>
					<td> <%= list.get(i).getBno() %></td>
					<td> <%= list.get(i).getBtitle() %></td>
					<td> <%= list.get(i).getMno() %></td>
				</tr>
			<% 
			}			// <%= 표현식(호출) 
			%>
		</table> --%>

		



</body>
</html>