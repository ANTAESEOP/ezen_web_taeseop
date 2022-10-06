const pictures = document.querySelectorAll(".poster")
 const left_button = document.querySelector('.left')                  // 포스터 이미지들을 배열로 가져오고 양쪽 버튼에 이벤트 연결을 위해 객체를 가져옴 
 const right_button = document.querySelector('.right')

 let num = 0                                                           // 이미지들이 넘어가는 비율을 저장하기 위한 변수 num 을 선언함



right_button.addEventListener('click', (event)=>{                     //오른쪽 버튼에 이벤트연결
	if(num===-200){                                                    // 사진이 세장이므로 num값이 -200이 되면 함수가 종료되어 버튼을 눌러도 더이상 사진이 넘어가지 않게 함
		return
	}

	num=num-100                                                       //오른쪽 버튼을 누를때 마다 num값에 -100씩 더해서 저장
	
	for(let i = 0 ; i<=2 ; i++){                                      //배열로 가져온 각 이미지들을 반복문으로 각각 x축으로 -100%씩 이돟
		pictures[i].style.transform= `translate(${num}%,0)`
	}
	

	
	
}) 

 
 
 
	
	left_button.addEventListener('click', (event)=>{                //왼쪽 버튼에 이벤트연결
		if(num===0){                                                 // 사진이 세장이므로 num값이 0이 되면 함수가 종료되어 버튼을 눌러도 더이상 사진이 넘어가지 않게 함
		return
	}                                                                  //왼쪽 버튼을 누를때 마다 num값에 100씩 더해서 저장
		num=num+100

	
	for(let i = 0 ; i<=2 ; i++){
		pictures[i].style.transform= `translate(${num}%,0)`                //배열로 가져온 각 이미지들을 반복문으로 각각 x축으로 +100%씩 이돟
	}
	

	
	
}) 