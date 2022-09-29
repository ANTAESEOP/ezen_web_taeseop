package ch7상속.Ex5_타이어예제;

public class Car {
	 
	// 1. 필드
	
	Tire FrontLeftTire = new Tire( 6 , "앞 왼쪽");
	Tire FrontRightTire = new Tire( 2 , "앞 오른쪽");
	Tire backLeftTire = new Tire( 3 , "뒤 왼쪽");
	Tire backRightTire = new Tire( 4 , "뒤 오른쪽");
	
	// 2. 생성자
	
	// 3. 메소드
	boolean[] run() {
		System.out.println(" [ 자동차가 달립니다 ] ");
		boolean[] tirestate = new boolean[4];
		tirestate[0] = FrontLeftTire.roll();
		tirestate[1] = FrontRightTire.roll();
		tirestate[2] = backLeftTire.roll();
		tirestate[3] = backRightTire.roll();
		for( boolean b : tirestate) {
			if( b == false) {stop(); break; }
		}
		return tirestate;
	}
	
	void stop() {System.out.println(" [ 자동차가 멈춥니다. ] ");}
	
}
