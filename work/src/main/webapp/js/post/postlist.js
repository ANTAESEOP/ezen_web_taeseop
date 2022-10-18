function postlist (){
	
	$.ajax({
		url : "http://localhost:8080/work/post/postlist",
		success : function(re){
			let boardlist = JSON.parse(re)
			console.log(re)
			let html = ""
			for( let i = 0 ; i<boardlist.length ; i++){
				let b = boardlist[i]
				console.log(b)
						html += '<tr>' +
							'<td>'+b.pno+'</td>'+
							'<td>'+b.ptitle+'</td>'+
							'<td>'+b.pwriter+'</td>'+
							'<td>'+b.pdate+'</td>'+
							'<td>'+b.pview+'</td>'+
						'</tr>';
						document.querySelector('.table').innerHTML = html
						
			}
		}
		
		
		
	})
}