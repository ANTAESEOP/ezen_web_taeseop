package ch5클래스.Ex5;

public class Car { // p.239
	
	// 목적 : 반복적인 코드 , 식별용 [ 내부필드와 매게변수 ]
	// this.필드명	: 현재 클래스의 필드 호출
	// this( )		: 현재 클리스의 생서앚 호출
	// this.메소드명	: 현재 클래스의 메소드 호출
	
	
	
	// 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	// 생성자
		// 오버로딩 : 동일한 이름으로 선언 [ 매게변수 따라 구별 ]
		// 생성자에서 사용되는 매게변수명은 필드명과 동일하게 작성 [ this 키워드 ]
		// 1. 빈생성자 : 매게변수 가 없는 생성자 [ 기본생성자 ]
	Car(){}
	
		// 2. 매게변수가 1개인 생성자
	Car( String model ){this.model = model;}
	
		// 3. 매게변수가 2개인 생성자
	Car( String model , String color ){
		this(model , color , 5000 );
	}
	
		// 4. 매게변수가 3개인 생성자
	Car( String model , String color , int maxSpeed ){}
	
	
	// 메소드

}
