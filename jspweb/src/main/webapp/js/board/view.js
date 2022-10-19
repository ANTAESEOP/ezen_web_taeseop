/*
	value		: input , select m textarea 등
		<tag value = "">
	innerHTML 	: div , table , span , textarea 등
		<tag > </tag>
 */ 
bview()

function bview(){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/view" , 
		async : false, // 우선순위 ( 동기 입히기 )
		success : function( re ){ 
			let board  = JSON.parse( re )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			// 절대경로 : http://localhost:8080/jspsweb/board/filedown
			// 상대경로 : 현재 위치 기준[ http://localhost:8080/jspweb/js/view.js ]
			//			../board/filedown
			
			if(board.file !==  null){ // null , undefiend , 0
				let filelink = `<a href="/jspweb/board/filedown?bfile=${board.bfile}">${board.bfile}</a>`
				// let filelink = '<a href="/jspweb/board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
				
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분
				document.querySelector('.bfile').innerHTML = filelink;
			}
			let btnbox = document.querySelector('.btnbox')
			
			if(board.btnaction){
				alert('본인글');
				let deletebtn = '<button onclick="bdelete('+board.bno+')"> 글 삭제 </button>'
				let updatebtn = '<button onclick="bupdate('+board.bno+')"> 글 수정 </button>'
				btnbox.innerHTML += deletebtn;
				btnbox.innerHTML += updatebtn;			
			}else{
				alert('남의글');
			}
		}
	})
////////////////// 댓글출력 ///////////////////
	rlist()
}
function rlist(){
	$.ajax({
		url : "/jspweb/reply/rlist" ,
		data : {"type" : "reply"} , // type : reply 댓글을
		success : function(re){ 
			let replylist = JSON.parse(re)
			let html = ''
			for( let i = 0 ; i<replylist.length ; i++){
				let reply = replylist[i]
				$.ajax({	// 대댓글 호출 = rno ---> rindex
					url : "/jspweb/reply/rlist" ,
					data : {"type" : "rereply" , "rno" : reply.rno} , // type : rereply
					async : false, /* 동기식 */
					success : function(re){ 
						let rereplylist = JSON.parse( re )		
							
						html += '<div>'+
							'<span>'+reply.rcontent+'</span>'+
							'<span>'+reply.rdate+'</span>'+
							'<span>'+reply.mid+'</span>'+
							'<button type="button" onclick="rereplyview('+reply.rno+')">답글</button>'+
							'<div class="reply'+reply.rno+'"></div>';	// 댓글마다 사용되는 구역
							
						for( let j = 0 ; j<rereplylist.length; j++){
							let rereply = rereplylist[j]
							html += '<div style ="margin : 20px;">'+
										'<span>'+rereply.rcontent+'</span>'+
										'<span>'+rereply.rdate+'</span>'+
										'<span>'+rereply.mid+'</span>'+
									'</div>';
						}	
						html += '</div>';
						
					}
				})

			} // 반복문 끝
			document.querySelector('.replylist').innerHTML = html;
		}
	})
}
function rwrite(){
	let rcontent = document.querySelector(".rcontent").value;
	$.ajax({
		url : "/jspweb/reply/rwrite",
		data : {"rcontent" : rcontent , "type" : 0 } ,
		type : "POST",/* HTTP 메소드 : 1. GET방식 = 기본값 2. POST방식 */
		success : function( re ) {
			if ( re == 1){
				alert('댓글 작성 완료 !')
				location.reload();
			}else if (re == 0){
				alert('로그인 후 작성 가능합니다.')
				location.href = '../member/login.jsp';
			}else{
				alert('댓글 작성 실패')
			}
		}	 
	})
}

function rereplyview( rno ){
	let replydiv = document.querySelector('.reply'+rno)
	replydiv.innerHTML = '<input type="text" class="rerecontent'+rno+'"><button onclick="rereplywrite('+rno+')">답글작성</button>'
}
function rereplywrite( rno ){
	let rcontent = document.querySelector('.rerecontent'+rno).value
	$.ajax({
		url : "/jspweb/reply/rwrite" ,
		data : {"rcontent" :  rcontent , "rno" : rno , "type" : "rereply" } , 
		type : "POST" , 
		success : function( re ){ 
			if ( re == 1){
				alert('댓글 작성 완료 !')
				rlist()
			}else if (re == 0){
				alert('로그인 후 작성 가능합니다.')
				location.href = '../member/login.jsp';
			}else{
				
				alert('댓글 작성 실패')}
		}	
	});
}

function bdelete(bno){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/bdelete",
		data: {"bno" : bno},
		success : function( re ) {
			if( re === 'true'){
				alert('글 삭제 성공')
				location.href="../board/list.jsp"
			}
			else{alert('글 삭제 실패 : [관리자문의]')}
		}
	})
}

function bupdate(){
		$.ajax({
		url : "http://localhost:8080/jspweb/board/bupdate",
		success : function( re ) {
				location.href="../board/bupdate.jsp"
			}
	})
}