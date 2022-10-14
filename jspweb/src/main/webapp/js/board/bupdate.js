
/* 썸머노트 실행 */
$(document).ready(function() {
  	$('#summernote').summernote({
	
	placeholder : '내용 입력' ,
  	MaxHegiht : null ,
  	MinHeight : 300 , 
	});	
})

function bupdate(){
	let btitle  = document.querySelector('#btitle')
	let bcontent  = document.querySelector('#bcontent')
	let bfile  = document.querySelector('#bfile')
	$.ajax({
		url :"/jspweb/member/bupdate" ,
		data: {"btitle" : btitle , "bcontent" : bcontent , "bfile" : bfile} ,
		success : function( re ){ 
				if( re === 'true'){
					alert('수정에 성공하였습니다.')
				}else{
					alert('수정에 실패하였습니다. [ 관리자 문의]')
				}
			}
	})
}