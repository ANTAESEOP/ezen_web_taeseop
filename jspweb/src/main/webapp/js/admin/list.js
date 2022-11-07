getproduct()
// 모든 제품 호출 메소드
function getproduct() {
	$.ajax({
		url: "/jspweb/admin/regist",
		data: { "type": 1, "option": "all" }, // 타입이 1이면 모든 제품 호출
		type: "get", // 해당 서블릿주소의 doGet 메소드와 통신
		success: function(re) {
			let json = JSON.parse(re)
			let html = ""
			// forEach ( 반복 변수 명 => { 실행문 } ) : 인덱스 존재하는 객체에 한해 사용 가능

			// json.forEach( p => {

			//})
			for (let i = 0; i < json.length; i++) {
				let total = json[i].pprice - (json[i].pprice / json[i].pdiscount)
				html += '<tr>' +
					'<td><img src="/jspweb/admin/pimg/' + json[i].pimg + '" width="100%"></td>' +
					'<td>' + json[i].pno + '</td>' +
					'<td>' + json[i].pcno + '</td>' +
					'<td>' + json[i].pname + '</td>' +
					'<td>' + json[i].pprice + '</td>' +
					'<td>' + json[i].pdiscount + '</td>' +
					'<td>' + total + '</td>' +
					'<td>' + json[i].pactive + '</td>' +
					'<td>' + json[i].pdate + '</td>' +
					'<td><button type="button" onclick="updatemodal(' + json[i].pno + ')">수정</button>' +
					'<button type="button" onclick="deleteproduct(' + json[i].pno + ')">삭제</button></td>' +
					'</tr>'
			}
			document.querySelector('.table').innerHTML += html;
		}
	})
}

// 2-1 수정 모달 실행 메소드
function updatemodal(pno) {
	// 1. 해당 모달을 열어주는 버튼에 강제 클릭 이벤트 실행
	document.querySelector('.updatemodalbtn').click() // 해당 버튼을 클릭하는 이벤트 실행
	// 2. 해당 모달에 기존 내용을 넣기
	// 2-1 : 해당 pno의 제품정보 호출
	$.ajax({
		url: "/jspweb/admin/regist",
		data: { "type": 2, "pno": pno }, // 타입이 2 이면 개별 제품 호출
		type: "get",
		success: function(re) {
			let json = JSON.parse(re)
			document.querySelector('.pno').value = json.pno
			document.querySelector('.pname').value = json.pname
			document.querySelector('.pcomment').value = json.pcomment
			document.querySelector('.pprice').value = json.pprice
			document.querySelector('.pdiscount').value = json.pdiscount

			// 카테고리 호출 
			$.ajax({
				url: "/jspweb/board/pcategory",
				type: "get",
				success: function(re) {
					let json2 = JSON.parse(re)
					let html = ''
					for (let i = 0; i < json2.length; i++) {
						let category = json2[i];
						if (category.pcno == json.pcno) {

							html += '<input checked type="radio" name="pcno" value=' + category.pcno + '>' + category.pcname;
						} else {
							html += '<input type="radio" name="pcno" value=' + category.pcno + '>' + category.pcname;
						}

					}
					document.querySelector(".pcategorybox").innerHTML = html;
				}
			})

			// 제품 상태 호출 
			let pactivebtns = document.querySelectorAll('.pactive');
			if (json.pactive == 0) { pactivebtns[0].checked = true }
			if (json.pactive == 1) { pactivebtns[1].checked = true }
			if (json.pactive == 2) { pactivebtns[2].checked = true }
		}
	})
}
// 2-2 수정 처리 메소드
function updateproduct() {

	// 2. 수정 할 정보
	let form = document.querySelector('.updateform')
	let formdata = new FormData(form)
	// formdata 속성 추가
	// formdata.set('속성명' : 데이터 )
	// 2. 수정 할 대상
	$.ajax({
		url: "/jspweb/admin/regist",
		type: "put",
		data: formdata,
		processData: false,
		contentType: false,
		success: function(re) {
			if (re === 'true') {
				alert('수정 완료')
				//1. 모달 닫기
				document.querySelector(".modalclosebtn").click()
				//2. 모달 새로고침
				pagechange('list.jsp');
			} else { alert('수정실패') }
		}
	})
}
// 3. 삭제 처리 메소드
function deleteproduct(pno) {
	if (confirm('정말 삭제하시겠습니까?')) {
		$.ajax({
			url: "/jspweb/admin/regist",
			data: { "pno": pno }, /* 톰켓 서버의 기본 설정값은 get , post 방식만 객체[Body] 전송 */
			type: "delete", // 해당 서블릿 주소 의 doDelete 메소드와 통신
			success: function(re) {
				if (re === 'true') { alert('삭제 성공'); pagechange('list.jsp') }
				// pagechange() : dashboard.jsp내 dashboard.js가 포함되어 있기 때문에 호출이 가능하다.
				// 현재 구조상 dasgboard.jsp내 특정태그에 list.jsp 포함
				else { alert('삭제 실패') }
			} // success end
		}) // ajax end
	} // if end
} // f end

getpcategory()
function getpcategory() {
	document.querySelector('.categorybox').innerHTML
	$.ajax({
		url: "/jspweb/board/pcategory",
		type: "get",
		success: function(re) {
			let json = JSON.parse(re)
			let html = ''
			for (let i = 0; i < json.length; i++) {
				let category = json[i];
				html += '<input type="radio" name="pcno" value=' + category.pcno + '>' + category.pcname;
			}
			document.querySelector(".categorybox").innerHTML = html;
		}
	})
}




/* 서버 프로젝트 클릭 - > server.xml -> 63줄  
	원본 : <Connector connectionTimeout="20000" port="8081" protocol="HTTP/1.1" redirectPort="8443"/>
	수정 : <Connector connectionTimeout="20000" port="8081" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="GET,POST,PUT,DELETE"/>			
*/
