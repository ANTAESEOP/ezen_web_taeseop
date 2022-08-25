
/* 
	객체명.textContent
	객체명.innertHTML
	객체명.value
 */

// 3. HTML 요소 가져오기
const input = document.querySelector('#inchbox')
const button = document.querySelector('#inchbtn')
const p = document.querySelector('#inchp')

// 2. 버튼을 눌렀을때
button.addEventListener('click' , () => {
	
	const inch = Number( input.value )
	// isNaN( 데이터 ) : 숫자가 아니면 ture / 숫자이면 flase
	if( isNaN ( inch ) ){
	p.textContent = '숫자를 입력해주세요'
	return
	}
	// 입력값이 숫자이면
	const cm = inch * 2.54
	p.textContent = `${cm} cm`
})

// p.341
// html 요소 가져오기
const emailbox = document.querySelector('#emailbox')
const emailp = document.querySelector('#emailp')
// 이메일 형식 확인 함수
const isEmail = (value) => {
	return (value.indexOf('@') > 1 ) && (value.split('@')[1].indexOf(".") > 1)
			// 입력데이터의 @ 가 있는지  이면서 입력데이터의 @ 뒤문자
			//							rkskekf@naver.com
			//									naver.com
}

// [기본함수]
function 함수(){
	return (value.indexOf('@') > 1 ) && (value.split('@')[1].indexOf(".") > 1)
}

// 이메일 입력상자에서 키보드를 입력할때마다 이벤트 발생
emailbox.addEventListener('keyup' , (event) => {
	const value = event.currentTarget.value
	if (isEmail(value ) ){
		p.style.color = 'blue'
		p.textContent = `이메일 형식입니다 : ${value}`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다 : ${value}`
	}	
})

/*
	배열명.indexOf('검색데이터') : 배열내 해당 데이터의 인덱스 번호 찾기
	문자열.indexOf('@') : 문자열내 @ 의 인덱스 번호 찾기
		인덱스 0보다 작으면 몾찾았다 [ 인덱스란 : 저장 순서 번호 = 9번 시작]
	문자열.split('기준문자') : 문자열내 기준문자 기준으로 분리 [자르기] -> 배열
		예)
			문자열 = 유재석/강호동/신동엽/하하
			문자열.split("/")		: [ 유재석 , 강호동 , 신동엽 , 하하]
			문자열.split("/")[0]	: 유재석
			문자열.split("/")[3]	: 하하
*/	

// p.343
// 1. html 요소 가져오기
const selectbox = document.querySelector('#selectbox')
const selectp = document.querySelector('#selectp')

// selectbox2 의 데이터가 변경 될 때마다 실행되는 이벤트 [ change ]
selectbox.addEventListener('change' , (event) => {
	// select의 모든 option 호출 [ select객체.options ] = 배열
	const options = event.currentTarget.options
	// 선택한목록번호 = option 중에서 [사용자] 선택된 번호 호출
	const index = event.currentTarget.options.selectedIndex
	//
	selectp.textContent = `선택: ${options[index].textContent}`
	//							옵션목록[ 선택한목록번호 ].내용물
})



// 342
const selectbox2 = document.querySelector('#selectbox2')
const selectp2 = document.querySelector('#selectp2')

// selectbox2 의 데이터가 변경 될 때마다 실행되는 이벤트 [ change ]
selectbox2.addEventListener('change' , (event) => {
	
	// 옵션목록 = selectbox2 모든 옵션을 호출
	const options = event.currentTarget.options
	const list = [ ]
	
	for( const option of options){
		// 배열[옵션목록] 중 하나씩 option 대입 반복
		if( option.selected ){ // 만약에 해당 옵션에 selected 속성[선택된 상자]이 있으면
			// 배열에 선택된 옵션의 텍스트를 추가
			list.push(option.textContent)
		} // if end
	} // for end

	selectp2.textContent = `선택 : ${list.join(',')}`
	// 배열명.join('연결문자') : 배열내 모든 요소들을 연결문자 기준으로 하나의 문자로 변환
		// 배열명 = [ '유재석 , '강호동 , '신동엽' ]
		// 학생명.join('<->')
		// 유재석<->강호동<->신동엽
		
})

let 현재값
let 변환상수 = 10

const select3s = document.querySelector('#select3')
const inputi= document.querySelector('#input')
const spans = document.querySelector('#span')

const calculate = () => {
	spans.textContent = (현재값 * 변환상수).toFixed(2)
}
select3s.addEventListener('change', (event) => {
	// 목록상자[currentTarget] 에서 호출 option 호출
	const options = event.currentTarget.options
	//
	const index = event.currentTarget.options.selectedIndex
	// 목록상자에서 선택한 인덱스 변호의 Value
	변환상수 = Number(options[index].value)
	calculate()
})

inputi.addEventListener('keyup', (event) => {
	현재값 = Number(event.currentTarget.value)
	calculate()
})

// p.347
let timer = 0 		// 타이머 시간(초) 저장하는 변수
let timerid = 0		// 타이머함수 [ setInterval 함수 저장하는 ]
const timerinput = document.querySelector('#timer-input')
const timerh1 = document.querySelector('#timerh1')
// 1. 체크박스의 상태가 변경 되었을때

timerinput.addEventListener('change' , (evnet)=>{
	// 1. 체크박스의 checked 인지 확인
	if( event.currentTarget.checked ){ // 체크가 되어있는
		// timerid = serInterval( ()=>{} , 1000 )
		timerid = setInterval( ()=>{
			timer += 1 // 타이머 시간 변수 1씩 증가
			timerh1.textContent = `${timer}초`
		} , 1000 )
	}else{ // 체크가 안되어 있는상태
		clearInterval( timerid ) // 타이머 함수 종료 [ clearInterval( 타이머객체 ) ]
	}
	
})

// p.348 ~ 349
/* 
	tag		=> 'tag				[복수]	querySelector('h1')
	class	=> '.class명'		[복수]	querySelector('h1class')
	id		=> '#id명'			[단일]	querySelector('#hild')
	name	=> '[name=name명]'	[복수]	querySelector('[name=h1name]')
	
	*식별자
		<h1 id="h1id" class="h1class" name="h1name"
	*js
	
 */ 
 
 // 2. radios[ 배열 ] 반복문
 	// 배열명.forEach ( ( 반복변수 ) => { } )
 		// 동물목록 = [강아지 , 고양이 , 햄스터 , 기타 ]
 		/*
 			1. for( let i in 동물목록 ){ alert( i ) }
 				i = 0 / i = 1 / i = 2 / i = 3
 				
 			2. for( let i of 동물목록 ){ alert( i ) }
 				i = 0 / i = 1 / i = 2 / i = 3
 				
 			3. 배열명.forEach( ( i , j)=> { alert( i , j ) }
 				i = 0 / i = 1 / i = 2 / i = 3
 		*/
const radios = document.querySelectorAll('[name=pet]')
const output = document.querySelector('#output')

radios.forEach( (radio)=> {
	
	radio.addEventListener('change', (event) => {
		const current = event.currentTarget
		if( current.checked ){
			output.textContent = `좋아하는 애완동물은 ${current.value}이시군요!`
		}// if end
	}) // event end
}) // forEach end




















































































