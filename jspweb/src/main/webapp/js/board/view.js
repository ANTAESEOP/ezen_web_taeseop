bview()

function bview(){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/view" , 
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			// 절대경로 : http://localhost:8080/jspsweb/board/filedown
			// 상대경로 : 현재 위치 기준[ http://localhost:8080/jspweb/js/view.js ]
			//			../board/filedown
			
			if(board.file !==  null){ // null , undefiend , 0
				let filelink = `<a href="/jspweb/board/filedown?bfile=${board.bfile}">${board.bfile}</a>`
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분
				document.querySelector('.bfile').innerHTML = filelink;
			}
			
			console.log(board.btnaction)
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

