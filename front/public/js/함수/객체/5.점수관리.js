/*
	* 함수 : 1.정의[만들기] 2. 호출

	* 학생 점수 프로그램
		1. 학생 객체 설치
		2. 점수 등록 버튼을 눌렀을때
			1. 해당 js 함수 호출하기
			<button onclick="함수명() ">
			
		1. HTML에서 입력받은 데이터를 js객체에 저장
		- 함수 등록 함수 사용
		document.getElementById('id명').value;
		3.
*/
let studentlist = [ ]
학생출력()
function 점수등록(){
	// 1. 객체
	const student = {
		name : document.getElementById('name').value ,
		kor : Number(document.getElementById('kor').value ),
		eng : Number(document.getElementById('eng').value ),
		mat : Number(document.getElementById('math').value)
	}
	
	// * 배열에 저장하기전 [ 학생등록 전]에 중복체크 |||
	if( 이름중복체크( student.name ) ) { // 이름중복체크의 함수
		return // return 함수 종료 라는 의미로 return 될 경우에는 아래코드는 실행되지 않는다.
	}// if end
	
	// 2. 객체를 배열에 넣기
	studentlist.push ( student ) // 배열명.push( 데이터 ) : 배열에 데이터 추가
	// 3. 알림
	alert('학생 점수 등록이 되었습니다.')
	console.log(studentlist)
	//4.
	document.getElementById('name').value = ''
	document.getElementById('kor').value = ''
	document.getElementById('eng').value = ''
	document.getElementById('math').value = ''
	// 5. 등록할때마다 테이블내 html 재호출
	학생출력()
}
function 이름중복체크(name){ // 학생 중복체크 함수 정의
	for( let i = 0 ; i<studentlist.length ; i++ ){
		// 만약에 배열이 객체가 3개 있을경우 : 길이 : 1 ~ 3		인덱스 0 ~ 2
		// i 는 0부터 i는 배열길이 [ 배열내 객체수 ]미만까지 1씩증가 반복
		if( studentlist[i].name === name ){
			// 배열내 i번째 인덱스의 객체내 이름이 새로 입력받은 이름과 같으면
			alert('이미 존재하는 학생명 입니다.')
			return true // 배열내 name과 동일한 이름이 있다.
		}// if end
	}// for end
	return false // 배열내 name 동일한 이름이 없다
}// f end

function 학생출력(){
	// 1. 변수에 html태그[문자열]를 저장하기
	let html =	'<tr>' +
					'<th>등수</th>' +
					'<th>학생명</th>'+
					'<th>국어</th>'+
					'<th>영어</th>'+
					'<th>수학</th>'+
					'<th>총점</th>'+
					'<th>평균</th>'+
					'<th>비고</th>'+
				'</tr>'
	// *** 배열내 데이터를 하나씩 꺼내기 -> 객체 정보를 html 화 	
	for( let i = 0 ; i<studentlist.length ; i++ ){	
		let 총점 = Math.floor(studentlist[i].kor + studentlist[i].eng + studentlist[i].mat)
		let 평균 = Math.floor(총점/3)
		// i는 0부터 배열내 마지막 인덱스까지 [ 배열의 길이 -1 ] 1씩 증가반복
		// 객체에 들어있는 데이터를 html로
			html +=	'<tr>' +
					'<th>등수</th>' +
					'<th>'+studentlist[i].name+'</th>'+
					'<th>'+studentlist[i].kor+'</th>'+
					'<th>'+studentlist[i].eng+'</th>'+
					'<th>'+studentlist[i].mat+'</th>'+
					'<th>'+총점+'</th>'+
					'<th>'+평균+'</th>'+
					'<th><button onclick="학생삭제('+i+')" > 삭제 </button></th>'+
				'</tr>'
			// 변수는 문자처리 X // 변수를 앞전에 미리 정의된 단더 [ 키워드 = 컴퓨터가 알고 있는 단어 ]
	} // for end
	// 2. 해당 변수를 html에 출력하기
	document.getElementById('listtable').innerHTML = html
} // f end

function 학생삭제( i ) { // 학생 삭제하는 함수 [ 매게변수 : 삭제할 식별번호 ( 배열내 저장된 순서번호=인덱스 )]
	alert(studentlist[i].name + '의 점수를 삭제 합니다.')
	studentlist.splice( i , 1 )
	학생출력() // 5. 삭제할때마다 테이블내 html 재호출
} // f end	

function 순위(){
	
}







