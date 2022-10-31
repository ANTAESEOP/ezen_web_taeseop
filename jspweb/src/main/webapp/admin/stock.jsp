<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h3> 재고 관리 </h3>
		<div class="row">
			<div class="col-md-4"> <!-- form-select : width 100% vs col-md-4 : width 12/4 -->
				<select class="cselect form-select col-md-4">
					<option> 카테고리 선택 </option>
				</select>
			</div>
			<div class="col-md-4">
				<select class="pselect form-select col-md-4">
					<option > 제품명 선택 </option>
				</select>
			</div>	
		</div>
		
		<div class="row my-3"> <!-- b : my-3 위아래 바깥여백[ margin ] -->
			<div class="col-md-6">
				<h3> 재고 등록</h3>
				<table class="table"> <!-- b: table -->
					<tr> <td style="width : 20%"> 카테고리번호</td> <td class="rows"> </td> </tr>
					<tr> <td style="width : 20%"> 카테번호</td> <td class="rows"> </td> </tr>
					<tr> <td style="width : 20%"> 제품명</td> <td class="rows"> </td> </tr>
					<tr> <td style="width : 20%"> 사이즈</td> <td class="rows"> <input type="text" class="psize form-control"> </td> </tr>
					<tr> <td style="width : 20%"> 색상</td> <td class="rows"> <input type="text" class="pcolor form-control"> </td> </tr>
					<tr> <td style="width : 20%"> 재고</td> <td class="rows"> <input type="text" class="pstock form-control"> </td> </tr>
					<tr> <td colspan="2"> <button onclick="setstock()" type="button" class="form-control"> 등록 </button> </td> <td> </td> </tr>
				</table>
			</div>
			<div class="col-md-6">
				<h3> 재고 출력</h3>
				<table class="table ttable">

				</table>
			</div>
			
		</div>
	</div>
		
		
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/admin/stock.js"></script>

			
</body>
</html>