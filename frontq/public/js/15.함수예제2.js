// p.204
function sumAll( a,b){
		//sumALL 이름으로 함수명 선언, 매개변수 a , b
			// 매개변수 : 함수 함수 호출시 들어오는 값 [ 데이터 ]
			let output = 0
			for(let i = a ; i<=b ; i++){
				// i는 a부터 b까지 1씩증가 반복처리
				output += i // vs output = output + i
			} // for end
			return output // output 리턴한다 [ 함수를 호출했던 위치로 ] 
}

console.log('1부터 100까지의 합 : ${sumALL(1,100) }')
console.log('1부터 100까지의 합 : ${sumALL(1,500) }')

// 계산하기 버튼을 눌렀을때 함수
function 계산버튼함수(){
	alert('버튼눌림 성공')	
	document.getElementById('sinput').value
	let snumber = document.getElementById('sinput').value
	let enumber = document.getElementById('sinput').value
	let result = sumALL ( snumber , enumber )
	document.getElementById('resultbox').innerHTML= '계산결과 : ' + result
	alert( snum )
}