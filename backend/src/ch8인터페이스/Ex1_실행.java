package ch8인터페이스;

public class Ex1_실행 {
	
	public static void main(String[] args) {
		
		// 1. 객체 [ 인터페이스 X ]
		Television tv = new Television();
		// 1. 인터페이스 구현 객체
		// 인터페이스 변수명 = new 구현클래스( );
		RemoteControl rc;
		
		// 2. 인터페이스 변수에 구현객체 대입
		rc = new Television(); // 리모콘에 텔레비전 기능 탑재
		
		// 3. 메소드 실행
		rc.turnOn(); // 
		rc.setVolume(5);
		rc.turnOff();
		
		System.out.println("TV --> Audio 변경");
		
		// 2. 인터페이스 변수에 구현객체 변경
		rc = new Audio(); // 리모콘에 오디오 기능 변경
		
		// 3. 메소드 실행
		rc.turnOn();
		rc.setVolume(7);
		rc.turnOff();
		
		System.out.println("Audio ---> 스마트tv 변경");
		
		SmartTelevision stv = new SmartTelevision();
		
		rc = stv;
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		Searchable sc = stv;
		sc.search("11번");
		
		
		
		
	}
}
