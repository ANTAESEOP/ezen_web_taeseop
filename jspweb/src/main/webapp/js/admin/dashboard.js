let sidebar = document.querySelector(".sidebar")
let mainbox = document.querySelector("#mainbox")

 //2. 해당 사이드바에 태그 호출 [ 사이드바 열기 ]
	sidebar.addEventListener('click' ,function(){
	sidebar.style.left = 0;
})

// 3. 본문 div를 클릭했을때 이벤트 [ 사이드바 닫기 ]
	mainbox.addEventListener('click' ,function(){
	sidebar.style.left = '-170px';
})

///////// 본문 전환 이벤트 /////////
function pagechange( page ){ // load 특정 태그 새로고침 api
	// 특정 태그에 해당 파일 로드 [ jquery ]
	$('#mainbox').load( page )
}