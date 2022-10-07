/*-------------------------------------------------*/
function findid(){
	// 1. 해당 id의 input value 와 div 호출
	let mname =  document.querySelector("#mname").value
	let memail = document.querySelector('#memail').value
	let findidconfirmbox =
		document.querySelector('#findidconfirmbox')
	
	// 2. 서블릿에게 데이터 보내기 [ 기본 : get메소드 ]
	$.ajax({
		url: "/jspweb/member/findid", 		/* 통신 경로 : 서블릿 URL */
		data: {"mname" : mname , "memail" : memail } , 	/* 보낼 테이터 : { "이름" : 값 , "이름" , "값" } */
		success : function( re ) {
			if(re !== 'null'){
				findidconfirmbox.innerHTML = '회원아이디 : ' + re
			}else{
				findidconfirmbox.innerHTML = '동일한 회원정보가 없습니다.'
			}
		} 
	});
}
/*-------------------------------------------------*/
function findpassword(){
	let mid = document.querySelector("#mid").value
	let memail = document.querySelector("#memail").value
	let findpasswordconfirmbox =
		document.querySelector("#findpasswordconfirmbox")
		
	$.ajax({
		url: "/jspweb/member/findpassword",
		data: {"mid" : mid , "memail" : memail},
		success : function(result){
			if( result === ''){
				findpasswordconfirmbox.innerHTML = '동일한 회원정보가 없습니다.';
			}else{
				findpasswordconfirmbox.innerHTML = '임시 비밀번호 : ' + result;
			}
		}
	})
}