package ch5클래스.Ex15;

public class Ex15실행 {
	
	public static void main(String[] args) {
		
		// 정적 맴버 호출
			// 클래스명.정적맴버
		double result = Calculator.pi2;
		Calculator.plus2( 10 , 5 );
		Calculator.minus2( 10 , 5 );
			// 주의할점 : static 맴버에서 static 아닌 맴버 ( 필드 , 메소드 ) 호출X
			// 해결방안 : static 맴버에서 static 아닌 맴버 ( 필드 , 메소드 ) 호출할때 객체 이용한 맴버 호출
		
		// 인스턴스 맴버 호출
			// 객체생성
		Calculator c = new Calculator();
		double result2 = c.pi2;
		c.plus1( 10 , 5 );
		c.minus1( 10 , 5 );
		
		
	}
}
