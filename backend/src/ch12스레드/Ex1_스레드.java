package ch12스레드;

import java.awt.Toolkit;

public class Ex1_스레드 {
		
	public static void main(String[] args) {
		// 스레드 : 한가닥의 실 의미 [ 코드를 읽어주는 하나의 흐름 ]
		// 멀티스레드 : 코드 읽는 여러개의 흐름
		
		// 1. p.525
		System.out.println(" -- 싱글 스레드 시작 -- ");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit : console ui 제공
		for( int i = 0 ; i < 10 ; i++) {
			toolkit.beep(); // 비프음 소리 함수 [ 소리 속도보다 반복문이 더 빠르다.[ 스레드가 더 빠르다. ]
			try {Thread.sleep(100);} catch (Exception e) {}
			// 밀리초 : 1000/1초
			// Thread : 현재 스레드
			// . sleep( 밀리초 ) : 스레드 일시정지 [ 무조껀 예외처리 발생 ( try / catch ) ]
		} // for end
		
		for ( int i = 0 ; i <5 ; i--) {
			System.out.println(i);
			try {Thread.sleep(6000);} catch (Exception e) {}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(" -- 멀티 스레드 시작 -- ");
		// 2. p.526
		Runnable beeptask = new BeepTask(); // 구현 객체
		Thread thread = new Thread(beeptask);
		thread.start(); // run 메소드 호출
		
		// main스레드 = 생성된 스레드 실행 후 다음 코드 실행
		
		for ( int i = 0 ; i <5 ; i++) {
			System.out.println("띵");
			try {Thread.sleep(100);} catch (Exception e) {}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		// 3. p.527 : 익명구현 객체 - 1회용 [ 이름 없으니까 다른곳에 호출 불가능 ]
		System.out.println(" -- 익명 구현 객체 멀티스레드 시작 -- ");
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit(); 
				for( int i = 0 ; i < 10 ; i++) {
					toolkit.beep(); 
					try {Thread.sleep(100);} catch (Exception e) {}
				} 
			}
		} );
		thread2.start();
		
		for ( int i = 0 ; i <5 ; i++) {
			System.out.println("띵");
			try {Thread.sleep(100);} catch (Exception e) {}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		// 4. p.529 : Thread 클래스 객체
		System.out.println("Thread 클래스 이용한 멀티스레드");
		Thread thread3 = new BeepThread();
		thread3.start();
		
		for ( int i = 0 ; i <5 ; i++) {
			System.out.println("띵");
			try {Thread.sleep(100);} catch (Exception e) {}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		// 5. p.530 : 클래스명 객체명 = new 생성자(){ 맴버 재정의 };
		System.out.println("Thread 클래스 이용한 익명자식객체 멀티스레드");
		Thread thread4 = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit(); 
				for( int i = 0 ; i < 5 ; i++) {
					toolkit.beep(); 
					try {Thread.sleep(100);} catch (Exception e) {}
				} 
			}
		};
		thread4.start();
		for ( int i = 0 ; i <5 ; i++) {
			System.out.println("띵");
			try {Thread.sleep(100);} catch (Exception e) {}
		}
		
		
		
		return; // main  함수 종료
	} // main end
} // class end














/* 
	

[멀티 태스킹 ]			[ 멀티프로세스 ]
		 				--> 프로세스		--> 스레드	[ 싱글스레드 ]
		 
	프로그램[애플리케이션]	--> 프로세스		--> 스레드1	[ 멀티스레드 ]
		크롬								--> 스레드2

		 				--> 프로세스
[윈도우]
하드웨어[주기억장치]	--> 운영체제			프로그램[애플리케이션]	--> 프로세스		--> MAIN스레드	[싱글스레드]
메모리			[스케줄링]				자바
[자바 제어X]								--> 프로세스		--> MAIN스레드
										--> 스레드1 생성 
										--> 스레드2 생성



	프로그램[애플리케이션]


운영체제 : 하드웨어 <----중개자----> 사람
-----------------------------------------------------------------------
멀티스레드[병렬 처리] 흐름단위
[ 운영체제가 메모리 할당[스케줄링]한 순서대로 처리 ]
1. main스레드 처리
2. 스레드2 처리
3. 스레드1 처리
4. 스레드2 처리
5. main스레드 처리
						MAIN스레드
							|
							|----------- 스레드생성1
			스레드2생성-------|				|
				|			|				|
				|			|				|
				|			|				|
				|			|				|


*/