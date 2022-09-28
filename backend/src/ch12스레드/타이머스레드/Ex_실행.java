package ch12스레드.타이머스레드;

import java.util.Scanner;

public class Ex_실행 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Timer timer = new Timer(); // 타이머객체 = 멀티 스레드 선언
		boolean timerstate = false; // 타이머 현재 실행상태 변수
		boolean waitstate = true; // 타이머 현재 일시정지 상태 변수


		
		while(true) {
			System.out.println(" 1.타이머시작 2. 리셋 3. 저장[DB] ");
			int ch = scanner.nextInt();
			
			// 1. 타이머 처음 켰을 때
			if( ch == 1 && timerstate == false && waitstate == true) {
				timer.start(); timerstate = true; 
			}
			
			// 2. 타이머가 켜져 있을 때 일시정지
			else if( ch == 1 && timerstate == true && waitstate == true) {
				timer.setWait(false); waitstate = false;
			}
			
			// 3. 타이머가 켜저 있을 때 일시정지 해제
			else if( ch == 1 && timerstate == true && waitstate == false) {
				timer.setWait(true); waitstate = true;
			}
			
			// 4. 타이머가 켜져 있을 때 리셋
			else if(ch == 2 ) {
				// timer.stop(); -- 비권장
				timer.setStop(false); // -- 안전하게 종료
				timerstate = false; waitstate = true;
				timer = new Timer(); 
			}
			
		}
	}
}


/*
	멀티스레드 사용 방법.
		1. Thread 클래스로부터 상속을 받는다.
		2. Runnable 인터페이스로부터 구현을 한다.
*/