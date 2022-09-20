package ch5클래스.Ex17_final;

public class Person {
	// 필드
	final String nation = "대한민국";
	final String ssn;
	String name;
	
	static final double EARTH_RADIUS = 6400; // 상수 ( 수정 불가능 )
	
	// 생성자 [ 매개변수 개수 따라 생성자 여러개 선언 ]

	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}

	
	// 메소드
}
