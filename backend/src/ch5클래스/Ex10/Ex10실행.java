package ch5클래스.Ex10;

public class Ex10실행 {

		public static void main(String[] args) {
			
			// 1. 객체 선언
			Car myCar = new Car();
			
			// 2. 객체에 메소드 호출 [ 인수O
			myCar.setGas(5); // 매게변수 5 / 반환타입 X
			
				// gas = 5
			
			// 3. 객체에 메소드 호출
			boolean gasState = myCar.isLeftGas();
				// 매개변수 X / 반환 boolean
				
				// gasState = true
			
			if( gasState ) {
				System.out.println("출발합니다.");
				myCar.run(); // 매게변수 X / 반환 X
			}
			
				// gas = 0
			
			// 4. 
			if (myCar.isLeftGas() ) {
				System.out.println("gas를 주입할 필요가 있습니다.");
			}else {
				System.out.println("gas를 주입하세요.");
			}
		}
}
