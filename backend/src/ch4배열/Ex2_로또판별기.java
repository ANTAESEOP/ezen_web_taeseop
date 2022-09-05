package ch4배열;

import java.util.Scanner;

/*
 	로또 판별기
 		1. 구매번호 : 사용자에게 6개 수 입력 -> 배열저장
 			1. 1 ~ 45 사이 만 입력받기 아니면 재입력		2. 중복 X
 		2. 추첨번호 : 컴퓨터 난수 6개 생성 -> 배열저장
 			1. 1 ~ 45 사이 난수
 		3. 구매번호 와 추첨번호와 동일한 수 의 개수

 */
public class Ex2_로또판별기 { // class start

	public static void main(String[] args) { // main start
		// 0. 메모리 [변수/배열] 선언
		Scanner scanner = new Scanner(System.in);
		int[] 구매번호 = new int[6]; // int형 변수 6개를 저장 할 수 있는 공간
		int[] 추첨번호 = new int[6]; // int형 변수 6개를 저장 할 수 있는 공간
		
		// 1. 사용자에게 입력 받는다. [ 6번 ]
		for( int i = 0; i<6 ; i++) { // i=인덱스
			System.out.println("안내) " + (i+1) + "번째 번호 선택 : ");
			구매번호[i] = scanner.nextInt(); // 입력받은 값을 i번째 인덱스에 저장한다.
			if( 구매번호[i] < 1 || 구매번호[i] > 45) { // 만약에 입력값이 1보다 작거나 45보다 크면
				System.err.println("안내) 선택할 수 없는 번호 입니다.");
				i--; continue; // i값을 깎으면서	
			} // if end
			// [조건2] 배열 내 입력된 데이터 확인 [중복확인]
			boolean 중복체크 = false;
			for( int j = 0; j<구매번호.length ; j++) {
				if( 구매번호[j] == 구매번호[i] ) {
					System.out.println("안내) 이미 선택된 번호 입니다.");
					중복체크 = true ;
				}// if end
			} // for2 end
			if( 중복체크 == true) { i--; continue; }
			
		} // for end

	} // main end
	
} // class end
