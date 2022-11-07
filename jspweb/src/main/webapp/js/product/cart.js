// [ 전역 변수 ]
let totalprice = 0; // 총 주문금액
let cartlist = null; // 장바구니 리스트

getcart() // 카트리스트 먼저 호출

let checkbtnlist = document.querySelectorAll('.checkbtn') // 1. 모든 체크박스 가져오기

checkbtnlist[0].addEventListener('click', (e) => {
	// 첫번째 체크박스에 체크가 되어 있는 경우 모든 체크박스에 체크
		// e.currentTarget : 이벤트를 발생시킨 대상의 이벤트 정보
			// checked : 속성 [ 체크 여부 ]
	if ( e.currentTarget.checked == true ) { // 만약에 첫번째 체크박스가 체크 되어 있으면
		checkbtnlist.forEach( c => { c.checked = true } ) // 모든 체크박스에 체크
	}
	// 아니면 모드 체크박스에 체크 제거
	else{checkbtnlist.forEach( c => { c.checked = false } ) }
})

let checkplist = []
// 2. 장바구니에서 체크된 제품만 결제 페이지 이동
function payload(){
	checkbtnlist.forEach((c , i) => {
		if(i != 0 && c.checked == true ){
			// 체크가 되어 있는 경우에
			checkplist.push(cartlist[i-1] )
		}
	})
	// 만일 1개도 체크된 제품이 없으면
	if(checkplist.length == 0 ){ alert ( '1개 이상 선택해주세요. '); return ;}
	localStorage.removeItem( 'checklist' ) // 저장소 초기화
	localStorage.setItem( 'checkplist' , JSON.stringify( checkplist ) ); // JSON을 문자열 형식으로 변환시켜 보냄
	// 저장소 생성 [ 'checkplist' 라는 이름으로 checkplist 객체 저장]
	location.href='/jspweb/product/pay.jsp'
}

function getcart() {
	$.ajax({
		url: "/jspweb/product/cart" ,
		type: "get" ,
		async : false , // 결과가 있을 때 까지 대기 상태
		success: re => {
			cartlist = JSON.parse(re)
			console.log(cartlist)
			let html = '<tr><th wdith="5%"><input type="checkbox" class="checkbtn"</th>' +
				'<th wdith="10%"> 이미지 </th>' +
				'<th width="40%"> 상품정보 </th>' +
				'<th> 수량 </th>' +
				'<th wdith="15%"> 가격 </th>' +
				'<th> 비고 </th>' +
				'</tr>'

			cartlist.forEach(c => {

				html += '<tr>' +
					'<td> <input type="checkbox" class="checkbtn"> </td>' +
					'<td> <img width="30%" alt="" src="/jspweb/admin/pimg/' + c.pimg + '"> </td>' +
					'<td> ' + c.pname + ' <br> - ' + c.pcolor + ' / ' + c.psize + ' </td>' +
					'<td> ' + c.amount + ' </td>' +
					'<td> ' + c.amount * (c.pprice - (c.pprice / c.pdiscount)) + ' </td>' +
					'<td> <button> 삭제 </button> </td>' +
					'</tr>'
				totalprice += c.amount * (c.pprice - (c.pprice / c.pdiscount))
			})
			document.querySelector('.cart_t').innerHTML = html
		}
	})

}






