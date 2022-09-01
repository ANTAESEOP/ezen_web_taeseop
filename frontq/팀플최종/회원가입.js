function 가입하기(){
   alert('가입이 완료되었습니다')
    location.href = "로그인.html";
   
}
function 회원가입(){
   let result = confirm('회원가입페이지로 넘어가겠습니까?')
   if(result == true){
      alert ('회원가입페이지로이동합니다.')
      location.href = "회원가입.html";
   }else{
      alert('이전페이지로이동합니다')
      }
   
}

function 로그인(){
   let id = document.querySelector("#idinput").value;
   let pw = document.querySelector("#pwinput").value;
   console.log(id )
   console.log(pw )
   
   if(id===''  || pw==='' ){
      alert('아이디와 비밀번호를 입력해주세요')
      return
   }else{
      alert('또 오셨군요!')
      location.href = "메인.html";
   }
}

function 인증받기(){
   let 인증받기 = document.querySelector("#injuo").value;
   
   console.log(인증받기)
   if(인증받기===''){
      alert('정확히 입력해주세요.')
      return
   }else{
      alert('인증번호를 발송했습니다')
   }
}   
   
function 인증하기(){
   let 인증하기 = document.querySelector("#inguo2").value;
   console.log(인증하기)
   if(인증하기===''){
      alert('정확히 입력해주세요.')
      return
   }else{
      alert('인증되었습니다')
   }
   
}   
   
   