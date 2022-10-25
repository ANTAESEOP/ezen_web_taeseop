function regist(){
	/* 첨부파일이 포함되어 있을 경우 */
	let form = document.querySelector('form')
	let formdata = new FormData( form )
	$.ajax({
		url : "http://localhost:8080/jspweb/admin/regist",
		data: formdata ,
		/* form 전송이 첨부파일 경우 */ // [ type , processData , contentType ] 이 3개는 세트 write.js 참고.
		type : "post",
		processData : false,
		contentType : false, //
		success : function(re) {
			console.log( re ) 
		}
	})
}

// 2. 첨부파일 등록(변경)했을때 미리보기
let pimg = document.querySelector('#pimg')
pimg.addEventListener( 'change' , function(e){ // e : 첨부파일 input change 이벤트 // e : event 객체 ( 이벤트정보 [ target , data 등 ] )
	alert('이미지 등록')	
	// 1. js 파일 클래스 [ FileReader() ]
	let file = new FileReader() 			// 객체 생성
		console.log( file )
		console.log( e )					// 이벤트 객체
		console.log( e.target )				// 이벤트 발생 시킨 태그 <input type="file" id="pimg">
		console.log( e.target.files[0] )	// 해당 태그의 등록된 파일호출
	// 2. 해당 첨부된 파일 경로 얻기 [ .readAsDataURL( 파일 ) ] // e.target.files[0] : 첨부파일이 등록된 이미지 경로
	file.readAsDataURL( e.target.files[0] ) //readAsDataURL() : 해당 파일 읽어오기
	// 3. 이미지 태그에 이미지 대입 [ id="pimgpre" ]
	file.onload = function( e ){ 			// e : 로드 된 file 의 이벤트
		document.querySelector('#pimgpre').src = e.target.result
		console.log(e.target.result)
	}
}) 
// 3. 카테고리 추가 버튼 눌렀을때 이벤트
function pcategoryview(){
	document.querySelector('.pcategoryaddbox').innerHTML
		='<input type="text" id="pcname">'+
				'<button type="button" onclick="pcategoryadd()">카테고리 등록</button>'
}
// 4. 카테고리 등록 버튼을 눌렀을때 이벤트
function pcategoryadd(){
	$.ajax({
		url :"/jspweb/board/pcategory",
		type : "post",
		data: {"pcname" : document.querySelector('#pcname').value},
		success: function( re ) {
			if(re ==='true'){
				alert('카테고리 등록 성공')
				document.querySelector('.pcategoryaddbox').innerHTML = ''
				getpcategory()
			}else {alert('카테고리 등록 시류ㅐ')}
			}
	})
}	
// 5. 카테고리 호출 메소드 [ 실행조건 : 페이지 열렸을때]
getpcategory()
function getpcategory(){
	$.ajax({
		url :"/jspweb/board/pcategory",
		type : "get",
		success : function(re){
			let json = JSON.parse(re)
			console.log( json )
			
			let html =''
			for(let i = 0 ; i<json.length ; i++){
				let category = json[i]
				html += '<input type ="radio" name="pcno" value='+category.pcno+'>'+category.pcname;
			}
			
			
		}
	})
}