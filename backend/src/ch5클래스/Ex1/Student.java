package ch5클래스.Ex1;

public class Student {
	public static void main(String[] args) {
		
		// 1. 클래스 기반으로 객체 선언
			// 1. 클래스명 	: 객체 생성시 사용되는 설계도
			// 2. 변수명 		: 객체 이름으로 사용할 임의로 정하기
			// 3. new 연산자 	: 힙 영역에 메모리 할당 후 주소값을 스택영역에 할당
			// 4. 생성자명 	: 객체 생성시 초기값 담당[ 클래스명 
		Student s1 = new Student();
		// 1	2	=	3	4
		// 스택 영역 = 힙 영역
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		
		Student s2 = new Student();
		System.out.println("s2 변수가 Student 객체를 참조합니다.");
	}
}
