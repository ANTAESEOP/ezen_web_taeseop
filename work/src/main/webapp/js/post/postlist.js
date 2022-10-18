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
							'<td><a href="http://localhost:8080/jspweb/board/view.jsp?bno='+b.bno+'">'+b.btitle+'</a></td>'+
							'<td onclick="viewload('+b.pno+')">'+b.ptitle+'</td>'+
							'<td>'+b.mno+'</td>'+
							'<td>'+b.mid+'</td>'+
							'<td>'+b.bdate+'</td>'+
							'<td>'+b.bview+'</td>'+
						'</tr>';
						
			}
		}
		
		
		
	})
}