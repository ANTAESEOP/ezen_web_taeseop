package ch8인터페이스;

// 클래스 선언 : 접근제한자 : class 클래스명 { }
// 인터페이스 선언 : 접근제한자 interface 인터페이스명 { }

public interface RemoteControl {
// 변수( 변하는 수 ) vs 상수 ( 고정된 수 )
// 1. [ static final ] : 상수 키워드 생략시 자동으로 상수 선언 (생략가능)
// 2. 초기값( 선언시 대입되는 값 ) 필수	
	public static final int MAX_VLOUME = 10;
//	       타입 상 수 이 름  = 값;
	public int MIN_VLOUME = 0;
	
	// 추상 : abstract
	// 1. [ abstract ] : 추상 키워드 생략시 자동으로 추상 선언
	// 2. 선언만 하자 !!! ----> 각 클래스에서 정의 [ 구현 객체 ]
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	
	
	
	
	
	
	
}
