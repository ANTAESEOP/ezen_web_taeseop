/*
 
    익명함수 = 람다
      *js : 함수도 자료이다. [함수도 변수처럼 사용이 가능하다.]
      매개변수에 함수 전달이 가능하다.
      매개변수: 자료형[number.string.boolean.object]
      함수호출(변수/상수)
      함수호출(배열)
      함수호출(함수)
      함수호출(function (){})
 */
 //1.콜백 함수 정의[221]
 function callthreetimes( callback ){
   for(let i = 0; i<3; i++){
      callback(i)
   }
}

function print(i){
   console.log(`${i}번째 함수 호출`)
}

//함수호출
callthreetimes(print)
console.log(typeof(print))

//2.익명 콜배 함수 정의[222]
function callthreetimes2(callback){
   for(let i =0; i<3; i++){
      callback(i)
   }
}

//콜백함수 : 익명 함수 사용하기
callthreetimes2(function(i){
   console.log(`${i}번째 함수 호출`)
    }//익명함수 e
)//함수 호출e


//3.배열의forEach()함수 메소드[p.223]
      //forEach(): 배열 반복문[인덱스와 값 호출]함수
      
let numbers = [237,52,103,32,57]
numbers.forEach(function(value , index , array){
   
   console.log(`${index}번째 요소:${value}`)
   
})

//* forEach()사용안할떄

function for_print(numbers){
   for(let i=0; i<numbers.length; i++){
   console.log(`${i}번째 요소:${numbers[i]}`)
   }
}
for_print(numbers)

//4. 배열의 map()함수[223]
numbers.map(function( value , index , array){
      return value *value
      
})
console.log('map실행 결과 :'+numbers)
numbers.forEach(console.log)

// 5. 배열의 filter( ) [ p. 224 ]
const evenNumbers = numbers.filter( function( value ) {
	return value % 2 == 0 // 짝수 공식
})
console.log( '원래 배열 : ' + numbers)
console.log( '짝수 배열 : ' + evenNumbers)