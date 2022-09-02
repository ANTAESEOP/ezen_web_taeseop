package java1;

import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 문제3 : 3개의 정수를 입력받아서 오름차순 / 내림차순 [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
		/*
				System.out.print("문제3) 정수1 입력: "); int 문제3_1 = scanner.nextInt();
				System.out.print("문제3) 정수2 입력: "); int 문제3_2 = scanner.nextInt();
				System.out.print("문제3) 정수3 입력: "); int 문제3_3 = scanner.nextInt();
				if( 문제3_1 > 문제3_2 ) { int temp = 문제3_1; 문제3_1 = 문제3_2; 문제3_2 = temp; }
				if( 문제3_1 > 문제3_3 ) { int temp = 문제3_1; 문제3_1 = 문제3_3; 문제3_3 = temp; }
				if( 문제3_2 > 문제3_3 ) { int temp = 문제3_2; 문제3_2 = 문제3_3; 문제3_3 = temp; }
				System.out.printf("%d %d %d \n" , 문제3_1 , 문제3_2 , 문제3_3 ); // 출력방식 1 
				System.out.println( 문제3_1 +" "+ 문제3_2 +" "+ 문제3_3 );  // 출력방식 2
		*/
		/*
				int 실행횟수 = 0;
				for( int 단 = 2 ; 단<=9 ; 단++ ) { // 단 2 ~ 9		[ 8회 ]
					// 단 2부터 9까지 1씩 증가
					for( int 곱 = 1 ; 곱<=9 ; 곱++ ) { // 곱 1 ~ 9	[ 9회 ] 단 마다 곱 모두 실행 [ 8 * 9 => 72 ]
						// 곱 1부터 9까지 1씩 증가
						System.out.printf("%d X %d = %2d \n " , 단 , 곱 , (단*곱) );
						
						실행횟수++;
					}// for 문
				} // for 문
				System.out.println("총 반복 횟수 : " + 실행횟수 ); // 72회
		*/		
				
				System.out.println("정수입력"); int 정수1 = scanner.nextInt();
				System.out.println("정수입력"); int 정수2 = scanner.nextInt();
				System.out.println("정수입력"); int 정수3 = scanner.nextInt();
				if( 정수1 > 정수2) {int temp = 정수1; 정수1 = 정수2; 정수2 = temp;}
				if( 정수1 > 정수3) {int temp = 정수1; 정수1 = 정수3; 정수3 = temp;}
				if( 정수2 > 정수3) {int temp = 정수2; 정수2 = 정수3; 정수3 = temp;}
				System.out.printf("%d %d %d \n" , 정수1 , 정수2 , 정수3 );
				
				int 실행횟수 = 0;
				for ( int 단 = 2 ; 단<=9 ; 단++) {
					for( int 곱 = 1 ; 곱<=9; 곱++) {
						System.out.printf("%d X %d =%2d \n" , 단 , 곱 , (단*곱));
					}
				}
				

	}
}
