package ch12스레드;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
					// implements : 구현 [ 인터페이스(추상) 구현할때 ]
					// Runnable : 쓰레드 인터페이스
					// Runnable 이 run을 제공. ( 자동완성 가능 )
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드 [ 스레드를 제공하는 함수 = run ]
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		for( int i = 0 ; i < 5 ; i++) {
			toolkit.beep(); 
			try {Thread.sleep(100);} catch (Exception e) {}
		} 
	}
}
