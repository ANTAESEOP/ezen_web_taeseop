/*
	css : class명
	js : id명
	[등록]
	// 1. HTML input 태그에 입력된 데이터 호출
	// 2. 객체에 담기
	// 3. 글 등록 버튼을 눌렀을때 [마다->함수] 1/2 실행한다.
	// 4. 게시물 객체 여러개 저장할 공간 = 배열 사용
	// 5. 글 등록이 완료 될때마다 board 객체를 배열에 저장한다.
		// 6. 글 등록했으면 기존 내용물 지우기 -> input 공백 넣기
	[출력]
	// 1. js시작될때 / 새로운 글이 등록 될때마다 [ 게시물 출력 ]
	[보기]
	// 1. 개시물 출력해서 제목을 클릭 할 때마다 [ 게시물 보기 ]
		// 1. 내가 클릭한 게시물 (???) : 매게변수 전달 [ 클릭한 게시물의 번호 (중복X) ]
*/
// 4. 여러개 게시물 객체를 저장할 배열 선언
let boardlist = [ ]



// 3. 함수 선언 [ 글 등록 버튼을 클릭할때 마다 ]
function 글등록(){
	/* 1. HTML에서 입력된 데이터 가져와서 변수에 담기*/
	let bwhiter = document.getElementById('bwhiter').value 
	let bpassword = document.getElementById('bpassword').value 
	let btitle = document.getElementById('btitle').value 
	let bcontent = document.getElementById('bcontent').value 
	// 2. 객체에 담기
	let board = {
		작성자 : bwhiter, 
		비밀번호 : bpassword, 
		제목 : btitle,
		내용 : bcontent
	}
	// 5. 객체를 배열에 저장한다
	boardlist.push( board ) // 배열명 .push( 데이터 ) : 배열에 데이터 추가함수
	alert('[안내] 글 등록이 완료되었습니다.')
	// 6. input
	document.getElementById('bwhiter').value = ''
	document.getElementById('bpassword').value = ''
	document.getElementById('btitle').value = ''
	document.getElementById('bcontent').value = ''
	// 7. 글 등록시 게시물 출력 함수 호출
	게시물출력()
	
} // 글 등록 end
	
// 1.
function 게시물출력(){
	let html = '<tr> <th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> </tr>'
	
	// 반복문
	for( let i = 0 ; i<boardlist.length ; i++){
		// i는 0부터 배열의길이 까지 1씩 증가
		html += '<tr> <td> '+i+'</td> <td> <a href="#" onclick="게시물보기('+i+')">'+boardlist[i].제목+'</a> </td> <td> '+boardlist[i].작성자+'</td> </tr>'
											// " " : 문자처리 vs `${}`
											// js에서 html 작성시 문자처리 : '<태그명 onclick="함수()">d'
	}
	
	//
	bwhiter = document.getElementById('boardlist').innerHTML = html
}

function 게시물보기 (i){

	document.getElementById('viewtitle').innerHTML = boardlist[i].제목
	document.getElementById('viewwriter').innerHTML = boardlist[i].작성자
	document.getElementById('viewcontent').innerHTML = boardlist[i].내용	
} // 게시물보기 함수 end
