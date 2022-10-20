// 1. 로그인제 [로그인된 경우에만 실행 하겠다. [ 세션 호출 : jsp vs ajax ] ]
let mid = document.querySelector('.mid').value
// 웹소켓 선언 
let websocket = null 
// 2. 만약에 로그인이 되어 있는경우에만 서버소켓으로부터 접속한다. 
if( mid !== 'null' ){ 
	websocket = new WebSocket("ws://localhost:8080/jspweb/chatting/"+mid); 
	// 3. 2번에서 구현된 메소드를 클라이언트소켓에 대입 
	websocket.onopen = function( e ){ onopen(e) }
	websocket.onclose = function( e ){ onclose(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
	websocket.onerror = function( e ){ onerror(e) }
}else{
	alert('로그인하고 오세요~'); location.href="../member/login.jsp";}
function onopen(e){ alert('채팅방에 들어왔습니다.'+ e ) }
function onclose(e){ alert('채팅방에 나갔습니다.'+ e ) }
function send() {
	let msg = {
		contente : document.querySelector('.msgbox').value,
		mid : mid ,
		date : new Date().toLocaleTimeString()
	}
	websocket.send( JSON.stringify( msg ) )
	document.querySelector('.msgbox').value = ''
}	
// 전송방식 : 1. 눌렀을때 2. 메세지 입력 상자에서 엔터를 눌렀을 때
function enterkey(){if(window.enevt.ketCode== 13) {send() } } 

	// 4. 메시지 받았을때 
function onmessage(e){
	let msg = JSON.parse( e.data )
	console.log( msg )
	let html = '<div>'+
					'<span>'+msg.mid+'   :   </span>'+
					'<span>'+msg.content+'</span>'+
					'<span> [ '+msg.date+' ] </span>'+
				'</div>';
	document.querySelector('.contentbox').innerHTML += html; 
 }
function onerror(e){ 	alert(e) }

// 자바스크립트 " F5 할 때마다 [ 새로 열릴 때마다 ] 메모리 초기화

	





