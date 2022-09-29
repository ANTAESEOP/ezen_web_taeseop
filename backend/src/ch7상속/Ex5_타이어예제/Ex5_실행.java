package ch7상속.Ex5_타이어예제;

public class Ex5_실행 extends Thread {
	
	public static void main(String[] args) {
		
		// 1. 자동차 생성
		Car car = new Car(); // tire 객체가 4개
		
		// 2. 자동차 10번 회전
		for( int i = 1 ; i<=10; i++) {
			
		boolean[] result = car.run();
		
		// 3. 만약에 펑크이면 타이어 교체
		if( !result[0]) { // 앞 왼쪽
			car.FrontLeftTire = new HankookTire(15 , "앞 왼쪽" );
		}
		if( !result[1]) { // 앞 오른쪽
			car.FrontRightTire = new HankookTire(13 , "앞 오른쪽" );
		}
		if( !result[2]) { // 뒤 왼쪽
			car.backLeftTire = new KumboTire(14 , "뒤 왼쪽" );
		}
		if( !result[3]) { // 뒤 오른쪽
			car.backRightTire = new KumboTire(17 , "뒤 오른쪽" );

		}

		}
	}
}
