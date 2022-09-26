package ch12스레드;

import java.util.Scanner;

public class Ex4_예제1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean musicstate = false; // 음악 재생 여부 판단 변수
		boolean moviestate = false; // 영화 재생 여부 판단 변수
		
		Music music = new Music(); // 음악 스레드 선언
		Movie movie = new Movie(); // 영화 스레드 선언
		Thread thread = new Thread(movie); // 영화 스레드 선언
		
		while(true) {

			if( musicstate == false ) System.out.println("1. 음악[재생]");
			else System.out.println("1.음악[중지]		");

			if( moviestate == false ) System.out.println("1. 영화[재생]");
			else System.out.println("1. 영화[중지]	");
			
			int ch = scanner.nextInt();
			
			if( ch == 1 && musicstate == false ) { // 입력한 값이 1번 이면서 음악이 꺼져있으면
				music.start();					// 음악 스레드 실행
				musicstate = true;				// 현재 스레드가 작업 스레드 재생여부 변경
			}
			else if( ch == 1 && musicstate == true ) { // 입력한 값이 1번 이면서 음악 쓰레드가 켜져 있으면
				music.setStop(false);					// 현재 스레드가 작업 스레드 재생여부 변경
				musicstate = false; music = new Music();// 새로운 메소드
			}
			
			if( ch == 2 && moviestate == false ) {
				thread.start(); moviestate = true;
			}
			else if( ch == 2 && moviestate == true ) {
				movie.setStop(false);
				moviestate = false;
			}
			
			
		}
	}
}

/*
	1. Thread 클래스
	2. Runnable 인터페이스

*/