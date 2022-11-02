/*
	document.querySelector('tag명')
	document.querySelector('#id명')
	document.querySelector('.class명')
	여러개[배열] : document.querySelectorAll()
	-- 속성[ 해당 tag내에서 사용가능한 속성 ]
		value 		:  div,span,td 등 사용불가
		innerHTML
		src : 
		style : 

	JS 반복문
		1. for( let i = 0 ; 배열명.length ; i++ ){  }
			i : 반복변수 [ 인덱스용 ]
		2. 배열명.forEach( ( value , index , array ) => { } )
			value : 배열 내 데이터 반복변수
			index : 인덱스 반복변수
			array : 배열
		3. for( value of 배열명 ) { } 
			// 배열에서 순서대로 데이터 반복변수에 대입
		4. for( index in 배열명 ) { }
			// 배열에서 순서대로 인덱스 반복변수에 대입
*/
/*
	// 1. 배열에 객체 추가
	배열.push( 객체 )
	// 2. 배열에 객체 삭제
	배열.splice( 인덱스 , 1 )

 */
// 공통변수 // 전역변수 [ 여러 함수에서 공동으로 사용하기 위한 목적 ]
let stock = null 		// 전역변수 
let product = null		// 제품
let color = null		// 선택된 색상
let productlist = [] 	// 선택된 색상
let sale = 0			// 할인율이 적용된 판매가
// 1. 현재 페이지내 제품번호[ a href="링크?pno=제품번호" ]를 가지고 와서 ajax로 해당 제품번호의 모든 제품정보를 가져오자 
let pno = document.querySelector('.pno').value
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////이벤트////////////////////////////////////
// **색상 select 박스를 체인지 했을때 이벤트 
document.querySelector('.cselect').addEventListener('change' , (e)=>{
	color = e.currentTarget.value	// 이벤트를 발생한 객체[cselect]의 담겨져있는 값 
	// 8. 색상 select 에서 선택된 색상 의 사이즈 select 구성 
	let shtml = '<option>-[필수] 사이즈 선택</option>'
	stock.forEach( s => {
		if( s.pcolor == color ){	// 재고목록중 색상 과 선택된 색상 같으면 해당 사이즈 html 구성
			shtml += '<option value='+s.psize+'> '+s.psize+' </option>'
		}
	})
	document.querySelector('.sselect').innerHTML = shtml
})
// **사이즈 select 박스를 체인지 했을때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value
	
	// 1. 사이즈 선택시 안내문구 클릭하면 함수 종료 
	if(size == '-[필수] 사이즈 선택'){ return; }
	
	// 이미 존재한 옵션을 클릭했을때 해당 옵션의 수량 증가하고 함수 종료
	for(p of productlist){
		if( p.pcolor == color &&
			p.psize == size ){
				p.amount++; print(); return;
			}
	}
	// 3.  선택된 제품정보와 옵션을 객체 만든다. 
	let sproduct = {
		pcolor : color , 	// 색상
		psize : size , 		// 사이즈 
		amount : 1			// 수량
	}
	productlist.push( sproduct ) // 리스트에 담는다.
	print() // 리스트에 존재하는 객체를 출력한다. 
})

// ** 찜하기 버튼을 눌렀을 때
let btnlike = document.querySelector('.btnlike');
btnlike.addEventListener('click' , (e)=>{
	// 1. 로그인 유무 판단 [ 1. ajax 통신해서 세션 유무 확인한다. 2. html 에서 가져온다.]
	let mid = document.querySelector('.mid').value
	if( mid == 'null'){
		alert('로그인후 가능한 기능입니다.')
		return;
	}
	
	// 2. 찜하기 등록 혹은 삭제
	$.ajax({
		url : "/jspweb/product/plike",
		type: "post",
		data : { "pno" : pno },
		success : re => { 
			if( re == '1'){
				alert('찜하기 취소')
				btnlike.innerHTML = '찜하기 ♡'
			}else if ( re == '2'){
				alert('찜하기 성공')
				btnlike.innerHTML = '찜하기 ♥'
			}else{
				alert('DB 오류')
			}
		}
	})
	
});
////////////////////////////////////////////////////////////////////////////
// js 열람시 최초로 함수 한 번 실행
getproduct(pno)	// 제품 정보 호출 [ pno ]
getstock(pno)		// 제품 재고 호출 [ pno ]
sethtmlprint()	

// 1. 해당 제품 번호의 제품정보 호출
function getproduct( pno ){
$.ajax({
	url : "/jspweb/admin/regist" ,	
	type : "get" , 
	async : false , 
	data : { "type" : 2 , "pno" : pno } ,
	success : re => { product = JSON.parse( re ) }
	})
}	
	
// 2. 해당 제품의 정보를 HTML 대입 메소드
function sethtmlprint(){
		document.querySelector('.pimg').src ='/jspweb/admin/pimg/'+product.pimg // 1.제품사진 대입
		document.querySelector('.pname').innerHTML = product.pname 		// 2.제품명 대입
		document.querySelector('.pcomment').innerHTML = product.pcomment 		// 3.제품설명 대입
		let phtml = '' 		// 4.가격 대입
		
		if( product.pdiscount == 0 ){ // 2. 할인이 없을때	[ 천단위 쉼표 함수 : 데이터.toLocaleString() ]
			psale = product.pprice
			phtml += '<span class="psale">'+(product.pprice.toLocaleString() )+'원</span>'
		}else{ // 1. 할인이 있을때						[ 반올림(소수점버리고 반올림) : Math.round( 데이터 ) ]
			psale = product.pprice
			phtml +=
				'<span class="pdiscount">'+ Math.round( product.pdiscount)+'%</span>'+
				'<span class="pprice">'+( product.pprice.toLocaleString() )+'원</span>'+
				'<span class="psale">'+ ( product.pprice -( product.pprice / product.pdiscount ) ).toLocaleString() +'원</span>'
		}
		document.querySelector('.pricebox').innerHTML = phtml 
}

// 3. 재고 가져오는 함수 메소드
function getstock( pno ){
		$.ajax({
			url : "/jspweb/admin/stock" ,
			type : "get" , 
			async : false ,
			data : { "pno" : pno },
			success : (re) => { stock = JSON.parse( re ) } // 대입
		})	
}
				console.log( stock ) // 재고 목록
				
				// java set VS js set   [ 컬렉션 : 수집 // 프레임워크 : 미리 만들어진 클래스  ]
					// let set = new Set( [1,1,2,2,3,3] );	console.log( set )
				
				// 6. 사이즈 종류 출력
				// 사이즈목록 중복제거	[ set , includes , filter 등 ]
				let sizelist = [ ]						// 1. 중복이 있는 사이즈 배열 선언
				stock.forEach( s => {  sizelist.push( s.psize ) })	// 2.리스트에 담기 
				let sizeset = new Set( sizelist ) 		// 2. 사이즈 리스트 => set 목록 변경 [중복제거]
					console.log( sizeset ) 				// 3. 확인
				
					// 중복이 없는 사이즈목록 html 구성
				let shtml = '<span> [ '
				sizeset.forEach( s => { 
					shtml += " " + s +" "
				})
				shtml += ' ] </span>'
				
				document.querySelector('.sizebox').innerHTML = shtml
				
				// 7. 색상 select 구성 
				// 색상 목록 중복제거	[ set , includes , filter 등 ]
				let colorlist = []
				stock.forEach( s => {  colorlist.push( s.pcolor ) })
				let colorset = new Set( colorlist )
					console.log( colorset )			// 3. 확인
				
				let chtml = '<option>-[필수] 색상 선택</option>'
				colorset.forEach( c => { 
					chtml += '<option value='+c+'>'+c+'</option>'
				})
				document.querySelector('.cselect').innerHTML = chtml

// 4. 선택된 제품옵션 리스트를 출력하는 함수 [ 1. 사이즈선택 했을때 2.옵션 제거 했을때 마다 실행]
function print(){
	let ohtml = '<tr> <th width="60%">상품명/옵션 </th>  <th width="25%">수량</th>  <th width="15%"> 가격 </th>  </tr>';
	
	let totalprice = 0 	// 선택한 옵션제품 목록 총 판매가 변수
	let totalamount = 0	// // 선택한 옵션제품 목록 총 수량 변수
	
	productlist.forEach( ( p , i) => {
		let tsale = psale * p.amount		// 판매가 * 수량
		let tpoint = Math.round(tsale * 0.01) 		// 판매가 * 수량 * 1%
		
		totalprice += tsale		// 각 옵션별 판매가를 전체판매가에 누적 더하기
		totalamount += p.amount	// 각 옵션별 수량을 전체 수량에 누적 더하기 
		
		ohtml +=  
			'<tr>	'+
				'	<td> '+
				'		<span>'+product.pname+'</span>'+
				'		<br>'+
				'		<span> '+p.pcolor+' / '+p.psize+' </span>'+
				'	</td>'+
				'	<td> '+
				'		<div class="row g-0"> '+
				'			<div class="col-md-3">'+
				'				<input readonly class="form-control" value='+p.amount+'>'+
				'			</div>	'+
				'			<div class="col-md-4">	'+
				'				<button class="amount_btn" onclick="amountup('+i+')">▲</button>'+
				'				<button class="amount_btn" onclick="amountdown('+i+')">▼</button>'+
				'			</div>'+
				'			<div class="col-md-1">	'+
				'				<button class="cancel_btn" onclick="pcancel('+i+')">x</button>'+
				'			</div>'+
				'		</div>'+
				'	</td>'+
				'	<td>'+
				'		<span>'+tsale.toLocaleString()+'원</span> <br>'+
				'		<span class="pointbox"> (포인트)'+tpoint.toLocaleString()+' </span>'+
				'	</td>'+
				'</tr>';
	}) // for end
	
	document.querySelector('.select_t').innerHTML = ohtml
	let tohtml = totalprice.toLocaleString()+"원("+totalamount+"개)";
	document.querySelector('.totalprice').innerHTML = tohtml
}

// 5. 수량 증가 버튼을 눌렀을 때
function amountup( i ){
	// 선택한 옵션의 재고 찾기
	let maxstock = 0;
	stock.forEach(s => {
		if(s.pcolor == productlist[i].pcolor &&
		s.psize == productlist[i].psize){ // 재고목록에서 선택한 옵션과 일치하면
			maxstock = s.pstock // 재고 대입
		}
	})
	if(productlist[i].amount >=maxstock){alert('재고가 부족합니다.'); return;}
	productlist[i].amount++; print()
}
	 
// 6. 수량 감소 버튼을 눌렀을 때
function amountdown( i ){
	if(productlist[i].amount <=1 ){alert('최소 구매수량 입니다.'); return;}
	productlist[i].amount--; print()
}
// 7. 선택된 제품 제거
function pcancel( i ){
	productlist.splice( i , 1 ); print();	// 선택 된 제품리스트에서 i번째 1개 인덱스 제거
}


