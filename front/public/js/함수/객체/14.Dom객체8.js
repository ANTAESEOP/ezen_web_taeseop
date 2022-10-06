/*
	1. contextmenu : 오른쪽 클릭 [ 메뉴 ] 있을때 이벤트


*/

// 1. 호출 사진출력 요소 호출
const imgs = document.querySelectorAll('img')
	// 배열[갹체] = ????? All -> 여러개 -> 배열 ( 인덱스 )

// 2.
for( let i = 0 ; i<imgs.length; i++){
	imgs[i].addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
}

/*
// 3.
for( let i in imgs ){
	if( imgs.length-1 == 1){ break }
	imgs[i].addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
}

// 4.
for(let i of imgs ){
	imgs[i].addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
}

// 5.
imgs.forEach((img)=> {
	img.addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
} )


/*-------------------------------------------------------*/

let 상태 = false /* 체크박스를 체크 여부 저장 변수 */

// html 요소 가져오기
const 체크박스 = document.querySelector('input')

//
체크박스.addEventListener('change' , ( 이벤트속성 ) => {
	상태 = 이벤트속성.currentTarget.checked
	// 상태 = 체크박스.ckecked
})

const 링크 = document.querySelector('a')

링크.addEventListener('click' , (이벤트속성) => {
	if( !상태){ // | 논리반대  : true -< false // false -> true
	// if( 상태 )
	// if( 상태 )
		이벤트속성.preventDefault()
	}
})


























