/*
	p.226
		* 타이머함수 : 콜백함수 [ 내장함수 ]
		setTimeout( 함수 , 시간 ) : 시간이후에 한번 함수 실행
		setintaval( 함수 , 시간 ) : 매시간마다 함수 실행
*/

setTimeout( ()=> { console.log('1초 후에 실행합니다.')} , 1*1000   )

let count = 0
let 타이머 = setInterval( ()=> { 
	console.log(`1초 마다에 실행합니다${count}`)
	count++
	if( count == 5){	// 5초 후 타이머 종료된다.
		console.log(' 타이머가 종료됩니다. ')
		clearInterval( 타이머 )
	}
} , 1*1000   )
	
