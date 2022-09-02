package c조건반복문;

// 1. 클래스 선언
public class Ex_IF { // class start
	// 2. main() : 코드를 읽어주는 메소드
	public static void main(String[] args) { // class main start
		
		// 예1 ) : 참 실행문이 1개일때는 중광호 생략 가능
		if( 3 > 1 ) System.out.println("예1) 3이 1보다 크다");
		// 예2 ) : 조건이 true이면 실행 아니면 실행X
		if( 3 > 5 ) System.out.println("예2) 3이 5보다 크다");
		// 조건이 false 이기 때문에 실행 안됨!!
		
		// 예2 ) p.136
		int score = 93;
		if( score >= 90 ) { // 실행문( ; ) 2개 이상이면 { } 으로 묶음
			System.out.println("점수가 90보다 큽니다. ");
			System.out.println("등급은 A입니다.");	
		} // if end
		if( score < 90 ) 
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		 // if end
		
		if( score < 90 ) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		} // if end
		
		// p.137
		// int score = 85
				// 변수선언시 : 중복이름 불가능
		int score2 = 85;
		
		if( score2 >= 90 ) { // 85 >= 90 -> flase -> 실행X
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}// if end
		else {
			System.out.println("점수가 90점보다 작습니다.");
			System.out.println("등급은 B입니다.");
		} // else end
		
		// p.138		조건이 다수일때 1. if ~ elseif ( 하나의 결과 ) 2. (다수의결과)
		int score3 = 70;
		if( score3 >= 90 ) {System.out.println("점수가 100 ~ 90 입니다."); System.out.println("등급은 A입니다."); }
		else if (score3 >= 80 ) {System.out.println("점수가 80 ~ 89 입니다."); System.out.println("등급은 B입니다."); }
		else if (score3 >= 70 ) {System.out.println("점수가 70 ~ 79 입니다."); System.out.println("등급은 C입니다."); }
		else {System.out.println("점수가 70 미만입니다."); System.out.println("등급은 D입니다."); }
		// VS
		if( score3 >= 90 ) {System.out.println("점수가 100 ~ 90 입니다."); System.out.println("등급은 A입니다."); }
		if( score3 >= 80 ) {System.out.println("점수가 80 ~ 89 입니다."); System.out.println("등급은 B입니다."); }
		if( score3 >= 70 ) {System.out.println("점수가 70 ~ 90 입니다."); System.out.println("등급은 C입니다."); }
		if( score3 < 70 ) {System.out.println("점수가 70 미만입니다.."); System.out.println("등급은 D입니다."); }
		
		// 예제5 if 중첩
		int score4 = 95;	char 성별 = 'M' ;
		if( score == 100 ) {
			if (성별 == 'M') { System.out.println("100점 이면서 남자이다."); }
			else { System.out.println("100점 이면서 여자이다."); }	
		}else{
			if (성별 == 'F') { System.out.println("100점 이면서 여자이다."); }
			else { System.out.println("100점 이면서 남자이다."); }	
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main end
} // class end
/*
	IF문 : 조건식의 걀과에 따라 블록 실행 여부 결정
		if( 조건식 )
			if( 조건식 ) { 조건이 true }
			- 조건식 : true / flase / 비교연산자 , 논리연산자 , 변수 , 함수
			
			if 형태
				1.
					if( 조건 ) 참
				2.
					if( 조건 ) { 참 }
				3.
					if( 조건 ) { 참 }
					else{ 거짓 }
				4.
					if( 조건 ) { 참 }
					else if( 조건2 ) { 참2 }
					else if( 조건3 ) { 참3 }
					else { 거짓 }
				5.
					if( 조건 ) {
						if( 조건 ) {
							참
						}else{
							거짓
						}
					}		
					
					
					
					
					
					
					
					
*/		