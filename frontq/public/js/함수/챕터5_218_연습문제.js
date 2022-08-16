// 확인문제 - 1
function multiplyall( a , b ){
	
	let result = 1 // 1. a->b 까지 모두 곱한 값을 저장하는 변수
	
	for( let i = a ; i<=b ; i++ ){
		// i는 a부터 b까지 1씩증가 반복
		// result += i // 누적합계
		result *= i
	} // for end
	return result // 함수를 종료시 결과 반환
	}
	
console.log('모두 곱한 결과 : ' + multiplyall(1 , 2))
console.log('모두 곱한 결과 : ' + multiplyall(1 , 3))

// 확인문제 - 2 -1	[ 익명함수 선언 - > function( 인수~ ){} ]
const max = function( array ){
	let maxvalue = array[0]	// 배열내 첫번째 값을 가장 큰값 설정
	for ( let i of array ){ // 배열내 요소(항목=값) 하나씩 i에 대입 반복
		if( maxvalue > i){ maxvalue = i}
	} // for end
	return maxvalue
	// 배열내 요소(값)을 하나씩 출력하는 방법
	// 1. for ( let i in 배열명 ){ : 배열에서 *인덱스를 하나씩 대입반복
	//		배열명[i]
	// }
	// 2. for ( let i of 배열명 ){ : 배열에서 *값을 하나씩 대입 반복
	// 3. for ( let i ; i<배열명.length ; i++ ){
	//			배열명[i]
	/// }

console.log( ' 최대값 구하기 결과 : ' max2( [1,2,3,4] ) )
// 확인문제 - 2 -2	[가변 매개변수 함수 선언 -> ...매개변수 ]
const max2 = function( ...array ){
	let maxvalue = array[0]	// 배열내 첫번째 값을 가장 큰값 설정
	for ( let i of array ){ // 배열내 요소(항목=값) 하나씩 i에 대입 반복
		if( maxvalue > i){ maxvalue = i}
	} // for end
	return maxvalue
	
	console.log('최대값 구하기 결과2 : ' + max3)
	}
// 확인문제 -2 -3
const max3 = function (array , ...array2){
	
	alert( '타입확인 : ' + typeof (array) )
	alert( '타입확인 : ' + typeof (array2) )
	
	let = maxvalue = 0
	let items
	if( typeof(array) == 'object'	){
		items = array
	}else if(typeof(array2) != 'number')} {
		items = array2	
	}
	
	//최대값 구하기 함수
	for( let i of items ){
		if( maxvalue < i ){ maxvalue = i }
	}
		return maxvalue
}
console.log( ' 최대값 구하기 결과3[ 배열 -> 매개변수 1개 ]')
console.log( ' 최대값 구하기 결과3[ 숫자 -> 매개변수 4개 ]')