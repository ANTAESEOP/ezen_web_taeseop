function postlist (){
	$.ajax({
		url : "http://localhost:8080/work/post/postlist",
		data : {"pno" : pno , "ptitle" : ptitle , "pwriter" : pwriter , "pdate" : pdate , "pview" : pview },
		success : function(re){
			alert(re)
			let boardlist = JSON.parse(re)
			alert(re)
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
			}
			alert(re)
			document.querySelector('.table').innerHTML = html
		}
		
		
		
	})
}