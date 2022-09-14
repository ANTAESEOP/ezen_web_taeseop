package ch5클래스.Ex8;

import java.util.Scanner;

public class Ex8실행 {
	
	public static void main(String[] args) {
		
		// 0. 입력객체
		Scanner scanner = new Scanner(System.in);
			// scanner.next(); 객체명.메소드()		[O]
			// scanner.next(); 클래스명.메소드명() 	[X]
		// 1. 객체 생성 [ 빈 생성자 사용 ]
		Member m1 = new Member();
			// 객체가 맴버에 접근할때 . 연산자
			m1.id = "qwe";
			m1.password = "qwe";
			m1.name = "qwe";
		
		// 2. 객체 생성 [ 매개변수 1개인 생성자 사용 ]
		Member m2 = new Member("qwe");
		
		// 3. 객체 생성 [ 매게변수 2개인 생성자 사용 ]
		Member m3 = new Member("qwe" , "qwe");
		
		// 4. 객체 생성 [ 매게변수 3개인 생성자 사용 ]
		Member m4 = new Member("qwe" , "qwe" , "qwe");
		
}

		
}
/*

	객채지향 프로그램
		1. 클래스 : 필드 , 생성자 , 메소드로 구성
		2. 객체 : 클래스로부터 new 연산자를 사용한 메모리 할당
			객체 [선언] : 클래스명 변수명 = new 생성자명();
			객체 [호출] : 변수명
			객체 [맴버호출] : 변수명.맴버
				변수명.필드명
				변수명.메소드명
		




*/