package ch5클래스.Ex16_정적맴버;

public class Singleton {
	
	private static Singleton s1 = new Singleton();
		
		
	
	// 싱글톤 : 객체 1개만 선언 가능한 클래스
		// 방법 : 외부에서 생성자를 못쓰게 하자 [ new X ]
		// 접근제한자 :
			// private 	: 현재 클래스에서만 접근 가능
			// public 	: 프로젝트 어디서든 호출 가능
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return s1;
	}

}
