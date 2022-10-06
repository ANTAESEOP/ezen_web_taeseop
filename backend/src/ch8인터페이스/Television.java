package ch8인터페이스;

public class Television implements RemoteControl{
			// [ implements ] : 구현하다 ( 추상을 구현 )
			// [ extends ] : 연장하다 ( 상속 )
	// 1. 필드
	private int volume;
	// 2. 생성자
	
	// 3. 메소드

	// RemoteControl 인터페이스의 추상 메소드를 구현하자.
	
	@Override
	public void turnOn() {System.out.println(" TV를 켭니다 ");}
	@Override
	public void turnOff() {System.out.println(" TV를 끕니다 ");}
	@Override
	public void setVolume(int volume) {
		// 만일 현재 tv 소음이 리모콘의 최대소음보다 크면
		
		if( volume > RemoteControl.MAX_VLOUME) {
			this.volume = RemoteControl.MAX_VLOUME;
		}else if ( volume < RemoteControl.MIN_VLOUME) {
			this.volume = RemoteControl.MIN_VLOUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
}
