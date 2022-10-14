
/* 썸머노트 실행 */
$(document).ready(function() {
  	$('#summernote').summernote({
	
	placeholder : '내용 입력' ,
  	MaxHegiht : null ,
  	MinHeight : 300 , 
	});
	
})


function bwrite(){

	// form 버전
	let form = document.querySelector('form') // 1. form 태그 호출
	console.log(form)
	
	let formdata = new FormData(form) // 2. 객체화된 form 정보 호출
	
	console.log(formdata)
	
	$.ajax({
		url: "http://localhost:8080/jspweb/board/write", // 1. 서블릿 주소
		data : formdata , // ajax 기본값으로 form 전송 불가능	 // 2. 
		contentType : false ,
		// 기본값 : application x-www-form-urlencoded; charset = 
		// vs
		// false : multipart/form-data
		processData : false , // String : 기본값 vs 전송시 사용되는 타입
		// 기본값 : 전송url 데이터 명시
		// vs
		// false
		type : 'POST' , // http메소드 [ get vs post ]
		success : function( re ) {
			if(re==='true'){alert('글 등록 완료!'); location.href="http://localhost:8080/jspweb/board/list.jsp"}}
	
	})


/*	
	let inputs = document.querySelectorAll('input')
	
	console.log( inputs ) // inputs[0] : 헤더에 검색 입력창
	
	let data = {
		btitle : inputs[1].value , 	
		bcontent : inputs[2].value
	}
	
	console.log( data )
	
	$.ajax({
		url : "http://localhost:8080/jspweb/board/write" ,
		data : data ,
		success : function ( re ){
			if(re==='true'){alert('글 등록 완료!'); location.href="http://localhost:8080/jspweb/board/list.jsp"}}
	})
	*/
}

/*
	let 객체 = { 속성명 : 데이터 , 속성명 : 데이터 ~~ }
*/