
bview()
function bview() {
	$.ajax({
		url: "http://localhost:8080/jspweb/board/view",
		success: function(re) {
			let board = JSON.parse(re)
			console.log(board)

			document.querySelector('.btitle').value = board.btitle
			// 썸머노트는 내용 저장시 html 형식으로 저장하기 때문에
			document.querySelector('.bcontent').innerHTML = board.bcontent

			if (board.bfile !== null) { // 첨부파일이 존해 하면
				let filedelete = board.bfile + '<button type="button" onclick="bfiledelete()">삭제</button>'
				document.querySelector('.oldbfilebox').innerHTML = filedelete
			}
			/* 썸머노트 실행 */
			$(document).ready(function() {
				$('#summernote').summernote({
					placeholder: '내용 입력',
					MaxHegiht: null,
					MinHeight: 300,
				})
			})
		}
	})
}

function bfiledelete() {

	// 1. 
	if (confirm('삭제하시겠습니까?')) {
		$.ajax({
			url: "/jspweb/board/bfiledelete",
			success: function(re) {
				if (re === 'true') {
					alert('첨부파일 삭제')
					// * 현재페이지 새로고침 : location.reload()
					// location.reload()
					document.querySelector('.oldbfilebox').innerHTML = '' // 공백처리
					// * 특정태그만 새로고침 : JQUERY ( $ ) 제공
					$("#oldbfilebox").load(location.href + ' #oldbfilebox')
				} else {
					alert('첨부파일 삭제 실패')
				}
			}
		})
	}
}

function bupdate() {

	let form = document.querySelector('form')
	let formdata = new FormData(form)

	$.ajax({
		url: "/jspweb/board/bupdate",
		data: formdata,
		// 첨부파일시
		type: "POST",
		contentType: false,
		processData: false,
		// 성공시
		success: function(re) {
			if (re === 'true') { location.href = 'view.jsp' }
			else (alert('수정 실패'))
		}
	})

}

