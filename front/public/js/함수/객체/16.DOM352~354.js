

// 1. HTML 요소 가져오기
const input = document.querySelector('#todo') 					// input id (todo) 가져오기
const todoList = document.querySelector('#todo-list') 			// button id (add-button) 가져오기
const addButton = document.querySelector('#add-button') 		// div id (todo-list) 가져오기

// 2. 변수 선언하기
let keyCount = 0 										// keyCount 라는 변수를 선언 ( 어디서든 사용 가능하게 )

// 3. 함수 선언하기
const addTodo = () => { 								// addTodo 라는 상수 선언
	if (input.value.trim() === ''){ 					// input 에 입력한 값이 공백 과 같다면 
		alert('할 일을 입력해주세요.') 						// (아무것도 입력을 안 했을 때) 할 일을 입력하라는 메세지창 (팝업) 생성
		return 											// 함수 실행 종료
	} // if end

// 4. 문서 객체 설정
	const item = document.createElement('div') 			// item 은 html = div에 대한 상수 선언
	const checkbox = document.createElement('input') 	// checkbox 는 html = input에 대한 상수 선언
	const text = document.createElement('span')			// text 는 html = span에 대한 상수 선언
	const button = document.createElement('button') 	// button 은 html = button에 대한 상수 선언

// 5. 문서 객체를 식별할 키 생성	
	const key = keyCount 					// 위에서 선언한 keyCount = 0 이니 식별을 위한 값을 추가하기위해 선언 
	keyCount += 1 							// keyCount 값에 +1대입

	// 6. item 객체를 조작하고 추가
	item.setAttribute('asd', key ) 				// item에 대한 속성
	item.appendChild(checkbox) 					// (상위:item 객체 에 하위: checkbox 객체 추가 
	item.appendChild(text)						// (상위:item 객체 에 하위: text 객체 추가 
	item.appendChild(button)					// (상위:item 객체 에 하위: button 객체 추가 
	todoList.appendChild(item) 					// (상위:todoList 객체 에 하위: item 객체 추가 
	
	// 7. checkbox 객체 조작
	checkbox.type = 'checkbox' 								// checkbox type 을 input= type="checkbox"]
	checkbox.addEventListener('change' , (event) => {		// 체크박스가 바뀔 때마다(눌릴때마다) 글씨에 중간 줄이 생기는 이벤트 발생
		item.style.textDecoration 							// item(div)객체에 textDecoration 이라는 속성 부여
			= event.target.checked ? 'line-through' : '' 	// 체크박스가 체크가 됐을때, 가운데줄 추가
	})
	
	// 8. text 객체 조작
	text.textContent = input.value 							// 입력값에 span 을 추가
	
	// 9. button 객체 조작
	button.textContent = '제거하기' 							// 버튼에 대한 요소 '제거하기' 추가
	button.addEventListener('click' , () => { 				// 버튼이 클릭 될 때마다 실행되는 이벤트를 추가
		removeTodo(key) 									// 값(할일)을 삭제
	})
	
	// 10 .입력 양식의 내용 비우기
	input.value = '' 										// 입력값을 공백으로
	}
	
	const removeTodo = (key) => { 							// 키 값을 제거하는 함수 선언
		
	
	// 11. 식별 키로 문서 객체 제거
	const item = document.querySelector(`[asd="${key}"]`) 		// html에 대한 div 값을
	todoList.removeChild(item) 									// (상위:todoList 객체 에 하위: item 객체 제거 
	}
	
	// 12. 이벤트 연결
	addButton.addEventListener('click' , addTodo) 			// addButton 이벤트가 클릭 될 때마다 addTodo에 내용 삽입
	input.addEventListener('keyup' , (event) => { 			// 입력 양식에서 Enter 키를 누르면 바로 addTodo() 함수 호출. (등록)
		const ENTER = 13 									// 엔터의 키 코드 값 (13)
		if (event.keyCode === ENTER){ 						// 만약 키코드값이( ENTER= 13) 이 눌리면
			addTodo() 										// 할 일 목록 추가
		}
	})
