getproduct()
// 모든 제품 호출 메소드
function getproduct(){
	
	$.ajax({
		url: "/jspweb/admin/regist",
		type:"get",
		success:function(re){
			let json = JSON.parse(re)
			let html = ""
			for(let i = 0 ; i<json.length; i++){
			html += '<tr>'+
						'<td><img src="/jspweb/admin/pimg/'+json[i].pimg+'" width="70%"></td>'+
						'<td>'+json[i].pno+'</td>'+
						'<td>'+json[i].pcno+'</td>'+
						'<td>'+json[i].pname+'</td>'+
						'<td>'+json[i].pprice+'</td>'+
						'<td>'+json[i].pdiscount+'</td>'+
						'<td>'+json[i].pprice*json[i].pdiscount+'</td>'+
						'<td>'+json[i].pactive+'</td>'+
						'<td>'+json[i].pdate+'</td>'+
					'</tr>'	
			}
			console.log(html)
			document.querySelector('.table').innerHTML += html;
		}
	})
}