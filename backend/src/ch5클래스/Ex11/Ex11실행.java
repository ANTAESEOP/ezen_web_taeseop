package ch5클래스.Ex11;

public class Ex11실행 { // 클래스
	
	public static void main(String[] args) { // 코드를 읽어주는[스레드] 포함된 함수
		
		// run메소드 호출 = 동일한 클래스에 존재
		// 1. 매소드 선언시 main 함수가 해당 매소드 먼저 읽기 static 사용
		run();
		
		// 2. 객체 만들자
		Ex11실행 ex11실행 = new Ex11실행();
		ex11실행.run2();
		
	} // main end
	
	// 1. 함수 선언 [ 반환x 매게변수 x ]
	static void run() {
		while(true) {
			System.out.println(" 1. 회원가입 2. 로그인  : ");
		}
	}
	
	void run2() {
		while(true) {
			System.out.println(" 1. 회원가입 2. 로그인  : ");
		}
	}
	
}
