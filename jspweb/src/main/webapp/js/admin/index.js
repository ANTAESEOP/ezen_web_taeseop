getpactive1()
function getpactive1(){
	$.ajax({
		url : "/jspweb/admin/regist",
		data : {"type" : 1 , "option" : "pactive1"},
		success : function(re){
			let json = JSON.parse( re )
			let html ='';
			console.log(json)
			for(let i = 0 ; i<json.length; i++){
			let comma = json[i].pprice-(json[i].pprice/json[i].pdiscount)
			html +=  
			'	<div class="item">																					'+
			'	<a href="/jspweb/product/view.jsp?pno='+json[i].pno+'">												'+
			'		<img src="/jspweb/admin/pimg/'+json[i].pimg+'">											'+
			'	</a>																							'+
			'	<div class="item_info"> 																		'+
			'		<div class="item_title"> 																	'+
			'			'+json[i].pname+'																		'+
			'		</div>																						'+
			'	<div class="item_size"> [FREE] </div>															'+
			'		<div class="item_price">'+json[i].pprice.toLocaleString('ko-KR')+'원</div> 					'+
			'			<div>																					'+
			'				<span class="item_sale">'+comma.toLocaleString('ko-KR')+'원</span>					'+
			'				<span class="item_discount">'+json[i].pdiscount.toLocaleString('ko-KR')+'%</span>	'+
			'			</div>																					'+
			'			<div class="item_review"> 리뷰 수 3142</div>												'+
			'	</div>																							'+
			'			<div>																					'+		
			'				<span class="badge rounded-pill text-bg-warning">주문폭주</span>						'+
			'				<span class="badge rounded-pill text-bg-danger">1+1</span>							'+
			'			</div>																					'+
			'	</div>																							'
			}
			document.querySelector('.itemlist').innerHTML += html
		}
	})
}



/*
'<div class="item">'+
	'	<a href="#">'+
	'		<img src="img/11.jpeg">'+
	'	</a>	'+
	'	<div class="item_info"> '+
	'		<div class="item_title"> '+
	'			IAB Studio Pigment Hoodie & Sack Coral '+
	'		</div>'+
	'		<div class="item_size"> [FREE] </div>'+
	'		<div class="item_price"> 200,000원 </div> '+
	'		<div>'+
	'			<span class="item_sale"> 20,000원 </span>'+
	'			<span class="item_discount"> 90% </span>					'+
	'		</div>'+
	'		<div class="item_review"> 리뷰 수 3142</div>'+
	'	</div>'+
	'	<div>'+
	'		<span class="badge rounded-pill text-bg-warning">주문폭주</span>'+
	'		<span class="badge rounded-pill text-bg-danger">1+1</span>'+
	'	</div>	'+
	'</div>';
 */