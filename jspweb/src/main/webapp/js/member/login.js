

/* HTML 과 서블릿 통신 */

// 0. 로그인 버튼 눌렀을때 [ 여러번 실행 --> 함수 ]
	// 1. 함수 정의 [function 함수명(매개변수 {   } ) ]
	// 2. HTML 함수 실행 --> 이벤트
		// 1. onclick="함수명()" : 클릭 했을 떄 함수 호출
function login(){
	

// 1. html 입력된 데이터 가져오기 [DOM]
	// 1. document.querySelector('#mid')
	// 2. document.getElementById("id")
	let mid = document.querySelector('#mid').value
	let mpassword = document.querySelector('#mpassword').value
	let loginconfirmbox = document.querySelector('#loginconfirmbox')
	// 2. 변수 2개를 서블릿으로 보내자 [ JQUERY : JS ]
		// 1. JQEURY 라이브러리 포함
		// 2. AJAX : 
	// $.ajax( { 속성명 = 값 , 속성명 = 값 , 속성명 = 값 } )	
		// url : ''		: 서블릿 URK
		// data : 전송할 데이터 { '키' : 값 , '키' : 값 }
		// success : function( 매개변수 ) { }
	$.ajax({
		url : "/jspweb/member/login" ,
		data : { "mid" : mid , "mpassword" : mpassword} ,
		success : function( re ){
			if( re === '1'){
				location.href = '/jspweb/index.jsp';
			}else if (re === '2'){
				loginconfirmbox.innerHTML = '패스워드가 다릅니다.'
				/*해당 id 에 문자열 넣기 */
			}else if (re === '3'){
				loginconfirmbox.innerHTML = '데이터베이스 오류[관리자 에게 문의]'
			}else if (re === '0'){
				loginconfirmbox.innerHTML = '존재하지 않는 아이디 입니다.'
			}
		}	
	})
}

/*---------------------------------------------------*/