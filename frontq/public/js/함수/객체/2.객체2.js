/*

	// p.249
	자바스크립트 데이터 를 저장하는 방법
		1. 변수 / 상수
		2. 배열
		*. 함수 : 1. 매개변수 2. 미리정의코드 3. 리턴값
			1. 일반 함수 : function 함수명 ( 매개변수 ~ ){ 코드 return 리턴값 }
			2. 익명 함수 : function ( ) { }
			3. [콜백함수] 화살표 함수 : ( 매개변수 ) => 리턴값
			4. [객체메소드] : 함수명 ( ) { }
		3. 객체
		
			let/const 객체명 = {
				키 : 값 ,
				키2 : 값2 , 
				키3 : 값3 , 
				키4 : function(){}
				
			}

*/
const pet = {
	name : '구름' ,
	eat : function( food ){
		alert(this.name + '은/는 ' + food + '을/를 먹습니다.') 
		// this : 자신이 가진 속성 뜻.
		// 객체내부 this.키 vs 객체외부 객체명.키
	}// 함수 end	
	
} // 객체 end

// 2. 객체내 메소드 호출 [ 객채네 속성/엑소드 호출일때 : 객체명.키 ]
pet.eat('고기')

// p. 250 속성 추가
// 1. 객체 만들기
const student = { } // 비어 있는 객체
// 2. 기존에 없는 키 접근 -> 새로운 속성 부여
student.이름 = '안태섭'
student.취미 = '악기'
student.장래희망 = '생명공학자'
// 3. 객체 확인
console.log( student)

// p.250 속성 제거
// 1. 객체내 속성 제거 [ delete 객체명.키 ]
delete student.장래희망
// 2. 객체 확인
console.log(student)

// p.251
const pet2 = {
	name : '구름' ,
	eat ( food ){
		alert(this.name+' 은/는 '+food+'을/를 먹습니다.')
	}
}
pet2.eat('밥')

// p.254
// 1.
const 객체 ={
	name : '혼자 공부하는 파이썬' ,
	price : 18000 ,
	publisher : '김경주꿈펼'
}

// 2. add[X] 정답 : 3
// 3. delete[O] 정답 : 1
// 4. print 메소드

// p.257 : 배열도 객체이다.
const a = [ ] // 1. 배열 선언
console.log ( a )
a.sample = 10 	// 2. 배열에 속성 추가
console.log ( a.sample )

// 함수도 객체이다.
function b (){}
b.sample = 10
console.log ( b.sample )

// 기본자료형
const c = 273		// 1. 상수 선언
c.sample = 10		// 2. 상수에 속성 추가
console.log( c.sample )

// 기본자료형
const d = '안녕하세요' // 1. 상수(문자열) 선언
c.sample = 10
console.log ( d.smaple )

// p.277 : 수학함수 : Math 객체
	// Math.random() : 0<= 결과 < i
	// Math.random()*10 : 0<= 결과 < 10
	// Math.random()*10 : 0<= 결과 < 50
	// Math.random()*10 -5 : -5<= 결과 < 5
	// Math.random()*50 -25 : 25<= 결과 < 25
	// 결과물 : 실수(소수점) --> 소수점없애기 --> 정수 만들기 : Math.floor(실수)
const num = Math.random()

console.log( ' 0 ~ 1 사이의 랜덤한 숫자 :' , num)
console.log( ' 0 ~ 10 사이의 랜덤한 숫자 :' , num*10)
console.log( ' 0 ~ 50 사이의 랜덤한 숫자 :' , num*50)

console.log( ' -5 ~ 5 사이의 랜덤한 숫자 :' , num*10 -5 )
console.log( ' -5 ~ 5 사이의 랜덤한 숫자 :' , num*50 -25 )































