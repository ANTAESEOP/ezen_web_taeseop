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
		System.out.println("");
		
	} // main end
	
} // class end
