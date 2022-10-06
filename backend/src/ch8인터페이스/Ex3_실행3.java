package ch8인터페이스;

public class Ex3_실행3 {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		// 구현객체 교체
		myCar.FrontLeftTire = new KumhoTire();
		myCar.FrontRightTire = new KumhoTire();
		
		myCar.run();
	}
}
