package ch5클래스.Ex9;

public class Ex9실행 {

		public static void main(String[] args) {


			
		// 1. 객체 생성
		Calculator myCalc = new Calculator();
		
		// 2. 메소드 호출 ( 매개변수 x 반환 x ) [ 객체명.매개변수 ]
		myCalc.powerOn();
		
		// 3. 매소드 호출 ( 매개변수 2개  반환 1개 )
		System.out.println( myCalc.plus(5, 6));
		
		int result1 = myCalc.plus(5, 6);
			// 메소드가 돌려준값[반환값]을 result1 변수에 저장
			// * 반환타입 과 변수의 자료형 동일해야 한다.
		System.out.println("result1 : " + result1 );
		
		// 3. 
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2 );
		
		//4.
		myCalc.powerOff();
			

		} // main end
} // class start
