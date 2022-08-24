	 document.addEventListener('DOMContentLoaded' , ()=>{
	 
	 //1 p.314 텍스트 조작
	 
	 
	 const a =document.querySelector('#a') //해당  id의 요소 가져오기
	 const b = document.querySelector('#b') //해당 id의 요소 가져오기
	 
	 a.textContent = '<h1>텍스트컨텐츠는 텍스트만 넣기</h1>'
	 b.innerHTML = '<h1> html형식으로 넣기 </h1>'
	 
	 
	 
	 //2 p.315 속성조작
	 const rects = document.querySelectorAll('.rect') //해당 class의 모든 요소 가져오기
	 
	 for(let i = 0; i<rects.length; i++){
	      const width = (i+1)*100
	      const src = `http://placekitten.com/${width}/250`
	      //const src=`../img.확장자`
	      rects[i].setAttribute('src' , src)
	      //배열내 해당 i번째 인덱스의 태그에 속성을 추가[이미지경로]
	}
	// 3. p318 스타일 조작
	const divs = document.querySelectorAll('#divbox div')
										// 상위태그 > 하위태그
										// 상위태그 하위태그
	divs.forEach(( div , index) => {
		//						[콜백함수]
		// 배열명.forEach( ( 반복변수명 , 인덱스변수 , 배열명 )=> { } )
		// - 배열에 있는 요소들을 하나씩 반복변수에 저장 대입
		// - 배열에 인덱스들을
		// -
		// 배열명.forEach( 반복변수명 ) => {} )
		// 배열명.forEach( 반복변수명 , 인덱스 ) => {} )
		
		console.log( div,index )
		const val = index*10
		div.style.height = `10px`
		div.style.backgroundColor = `rgba(${val}, ${val}, ${val})`
		
	})
	
})
































