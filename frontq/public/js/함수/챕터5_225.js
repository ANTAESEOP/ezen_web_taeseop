/*
	함수 : 미리정의된 코드
		기본형태 : 1.매개변수 2.정의코드 3.리턴값
		사용목적 : 1.재활용 2.메모리효율성 3.매개변수에 따른 서로 다른 리턴값 
		모양 : function 함수명 ( 매개변수 ~ ){  정의코드 return 리턴값 }
			매개변수(인수) : 함수 안으로 들어오는 수	(선택사항)
				- 변수 , 상수 , 배열 , 함수 
			리턴값(반환) : 함수 밖으로 나가는 수 	(선택사항)
		** 함수도 자료형이다!! [ Object -> 1.array 2.function ]
			
	1. 익명함수 : 이름 없는 함수
		function (){ } 
	2. 선언적함수 : 일반 함수 
		function 함수명(){ }
	3. 나머지매개변수 : 매개변수가 고정적이지 않는 함수 -> 배열  
		function 함수명( ...나머지매개변수 ){ }
	4. 기본매개변수 : 매개변수의 초기값 설정 
		function 함수명( 매개변수=값  ){ }
	5. 콜백함수 : 함수도 자료형이기 때문에 매개변수로 전달이 가능하다.
		fuction 함수명( 매개변수 ){ 
			
		}
		fuction 함수명2( ){ }
		함수명( 함수명2 )
		
		* 미리 만들어진 콜백 사용하는 배열내 함수들 
			forEach() : 반목문 
			map()		: 새로운 배열 생성 [ return 값을 새로운 배열 저장 ]
			filiter()	: 새로운 배열 생성 [ return true인 경우에만 값을 새로운 배열 저장 ]
	6. 화살표 함수 : function 생략 
		( 매개변수 ) => 결과 
*/

// p.226 화살표 함수
	// function , return 생략 
	// (매개변수) => 결과
let numbers = [ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9]
/*
	// 메소드 체이닝(결과 연결) 사용하지 않을때 
*/
let array1 = numbers.filter( (value) => value % 2 == 0 )
let array2 = array1.map( (value) => value * value )
array2.forEach( (value) => console.log(value) )
/*
	//화살표 함수를 사용했을때 
	// 메소드 체이닝(결과 연결) 사용하지 않을때 
		// 배열명.메소드1().메소드2() : 메소드1 결과를 가지고 메소드2 실행 
	numbers.filter( (value) => value%2 == 0 )
		.map( (value) => value*value )
		.forEach( (value) => console.log(value) )
	*/
/*	
	// 화살표 함수가 아닐때 
	numbers.filter( function(value){
		return value % 2 == 0
	}).map( function(value){
		return value * value
	}).forEach( function( value){
		console.log(value)
	})
*/
