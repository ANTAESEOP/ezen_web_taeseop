package ch5클래스.Ex8;

public class Member {
	
	// 맴버
	// 1. 필드
	String id;
	String password;
	String name;
	// 2. 생성자 : 객체 생성시 초기값 [ 필드의 처음값 설정 ]
		// * : 클래스명 이름 동일
		// * : 매게변수 개수에 따라 오버로딩 [ 여러개 사용 가능 ]
		// 1. 빈 생성자 [ 매게변수 X ]
	Member(){}
		// 2. 매게변수가 1개인 생성자
	Member( String id){
		this.id = id;
	}
		// 3. 매게변수가 2개인 생성자
	Member( String id , String password){
		this.id = id;
		this.password = password;
	}
		// 4. 풀 생성자 [ 매게변수가 3개인 생성자 ]
	Member( String id , String password , String  name ){
		this.id = id;
		this.password = password;
		this.name = name;
	}
	// 3. 메소드
}
