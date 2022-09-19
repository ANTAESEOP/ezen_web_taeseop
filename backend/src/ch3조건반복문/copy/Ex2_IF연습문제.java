package ch3조건반복문.copy;

import java.util.Scanner;

public class Ex2_IF연습문제 { // class start
	
	public static void main(String[] args) { // main start
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
	/*
		// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
		System.out.print("문제1) 정수1 입력: "); int 문제1_1 = scanner.nextInt();
		System.out.print("문제1) 정수1 입력: "); int 문제1_2 = scanner.nextInt();
		if( 문제1_1 > 문제1_2 ) { System.out.println("결과1 : " + 문제1_1 );}
		else if( 문제1_1 < 문제1_2 ) { System.out.println("결과1 : " + 문제1_2 );}
		//else if( 문제1_1 == 문제1_2 ) { System.out.println("결과1 : 두 수는 같다");}
		else{ System.out.println("결과1 : 두 수는 같다"); }
		
		// 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
		System.out.print("문제2) 정수1 입력: "); int 문제2_1 = scanner.nextInt();
		System.out.print("문제2) 정수2 입력: "); int 문제2_2 = scanner.nextInt();
		System.out.print("문제2) 정수3 입력: "); int 문제2_3 = scanner.nextInt();
		int max = 문제2_1;	// 첫번째 데이터를 가장 큰수로 저장하는 max 변수  
		if( max < 문제2_2 ) { max = 문제2_2; } // 두번째 데이터가 max보다 크면 max에 두번째 데이터를 넣기
		if( max < 문제2_3 ) { max = 문제2_3; } // 세번째 데이ㅓ가 max보다 크면 max에 세번째 데이터를 넣기 
		System.out.println("결과2 : 가장큰수 : " + max );
		
		// 문제3 : 3개의 정수를 입력받아서 오름차순 / 내림차순 [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
		System.out.print("문제3) 정수1 입력: "); int 문제3_1 = scanner.nextInt();
		System.out.print("문제3) 정수2 입력: "); int 문제3_2 = scanner.nextInt();
		System.out.print("문제3) 정수3 입력: "); int 문제3_3 = scanner.nextInt();
		if( 문제3_1 > 문제3_2 ) { int temp = 문제3_1; 문제3_1 = 문제3_2; 문제3_2 = temp; }
		if( 문제3_1 > 문제3_3 ) { int temp = 문제3_1; 문제3_1 = 문제3_3; 문제3_3 = temp; }
		if( 문제3_2 > 문제3_3 ) { int temp = 문제3_2; 문제3_2 = 문제3_3; 문제3_3 = temp; }
		System.out.printf("%d %d %d \n" , 문제3_1 , 문제3_2 , 문제3_3 ); // 출력방식 1 
		System.out.println( 문제3_1 +" "+ 문제3_2 +" "+ 문제3_3 );  // 출력방식 1 
		
		// 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
		System.out.print("문제3) 점수 입력: "); int 문제4 = scanner.nextInt();
		if( 문제4 >= 90 ) { System.out.println("합격"); }
		else { System.out.println("불합격"); }
	*/
		
		// 문제5
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//				점수가 80점 이상이면 B등급
		//				점수가 70점 이상이면 C등급
		//				그외 재시험
	/*	
		System.out.print("문제5) 점수 입력: "); int 점수 = scanner.nextInt();
		if ( 점수 >= 90) {System.out.println("A등급");}
		else if ( 점수 >= 80) {System.out.println("B등급");}
		else if ( 점수 >= 70) {System.out.println("C등급");}
		else{System.out.println("재시험");}
	*/
		/* 문제6
		[ 입력 ] : 국어,영어,수학 입력받기
		[ 조건 ]
			평균이 90점 이상이면서 
				국어점수 100점 이면 '국어우수' 출력
				영어점수 100점 이면 '영어우수' 출력
				수학점수 100점 이면 '수학우수' 출력
			평균이 80점 이상이면서 
				국어점수 90점이상 이면 '국어장려' 출력
				영어점수 90점이상 이면 '영어정려' 출력
				수학점수 90점이상 이면 '수학장려' 출력
			그외 재시험 
		*/
		
		System.out.print("문제6) 국어점수 입력: "); int 국어점수 = scanner.nextInt();
		System.out.print("문제6) 영어점수 입력: "); int 영어점수 = scanner.nextInt();
		System.out.print("문제6) 수학점수 입력: "); int 수학점수 = scanner.nextInt();
		double 평균 = 국어점수 + 영어점수 + 수학점수 / 3;
		
		// 1. 경우의수 3개
		if( 평균 >=90 ) {}
		else if( 평균 >= 80 ) {}
		else { }
		// 2. if 중첩 : 하위 경우의수 작성
		if( 평균 >=90 ) {
			if( 국어점수 == 100 ) {}
			if( 영어점수 == 100 ) {}
			if( 수학점수 == 100 ) {}
		}
		else if( 평균 >= 80 ) {
			if( 국어점수 >=90 ) {}
			if( 영어점수 >=90 ) {}
			if( 수학점수 >=90 ) {}
		}
		else {
			System.out.println("재시험");
		}
		
		//문제7 로그인페이지
		// [ 입력 ] : 아이디와 비밀번호를 입력받기
		// [ 조건 ] : 회원아이디가 admin 이고 
		//           비밀번호가 1234 일 경우에는 
		//          로그인 성공 아니면 로그인 실패 출력
		System.out.println( "-----------------[로그인페이지]-----------------");
		System.out.print(" 아이디 : "); String 아이디 = scanner.next();
		System.out.print(" 비밀번호 : "); String 비밀번호 = scanner.next();
		// 기본자료형(int,char,double 등) 비교연산자 가능
		// 클래스( 객체 = 기본자료형 외 ) 는 비교연산자 불가능
		if( 아이디.equals("admin") ) { // 아이디가 admin 이면 [ String == (x) ] 
			if( 비밀번호.equals("1234") ) {
				System.out.println("안내) 로그인 성공 ");
				}else {
					System.out.println("안내) 비밀번호가 다릅니다.");
				}
		} // if end
		else { // else start
			System.out.println("안내) 아이디가 다릅니다.");
		} // else end
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main end

} // class end

