package ch13컬렉션프레임워크;

import java.util.ArrayList;

public class Ex1_arraylist {
		
	public static void main(String[] args) {
		
		// 1. 객체 [ 클래스명 변수명 = new 생성자();
		// 1. 컬렉션프레임워크 객체[ 클래스명<타입파라미터> 변수명 new = 클래스명<>(); ]
			// < > : 클래스 안에 클래스를 매개 넣는 방식
		
		// 정수 int 여러개를 저장할 수 있는 리스트 선언
		ArrayList<Integer> intlist = new ArrayList<>();
		
		// 실수 double 여러개를 저장할 수 있는 리스트 선언
		ArrayList<Double> doublelist = new ArrayList<>();
		
		// 내가 만든 저료형을 여러개 저장할 수 있는 리스트 선언
		ArrayList<Member> memberlist = new ArrayList<>();
		
		// String 여러개를 저장할 수 있는 리스트 선언
		ArrayList<String> list = new ArrayList<>();
		
		// 1. add
		list.add( "java" ); 		System.out.println("리스트 현황 : " + list.toString() );
		 // "java" : String 타입
		list.add( "jdbc" ); 		System.out.println("리스트 현황 : " + list.toString() );
		list.add( "Servlet/JSP" ); 	System.out.println("리스트 현황 : " + list.toString() );
		list.add( 2 , "database" ); System.out.println("리스트 현황 : " + list.toString() );
		list.add("ibatis"); 		System.out.println("리스트 현황 : " + list.toString() );
		
		// 2. size()
		System.out.println("리스트내 객체 수 : " + list.size());
		
		// 3. get()
		System.out.println("특정 인덱스 호출 : 0 " + list.get(0));
		System.out.println("특정 인덱스 호출 : 1 " + list.get(1));
		System.out.println("특정 인덱스 호출 : 2 " + list.get(2));
		System.out.println("특정 인덱스 호출 : 3 " + list.get(3));
		System.out.println("특정 인덱스 호출 : 4 " + list.get(4));
		
		// 4. remove()
		System.out.println("특정 인덱스[0] 삭제 : " + list.remove(0));
		System.out.println("리스트 현황 : " + list.toString() );
		System.out.println("동일한 객체로 삭제 " + list.remove("ibatis") );
		System.out.println("리스트 현황 : " + list.toString() );
		
		// 5. 리스트 / 배열 < ----- > 반복문
			// 1.
		for( int i = 0 ; i < list.size(); i++) { // 순수 0부터 꺼내옮
			System.out.println(list.get(i));
		}
			// 2.
		for( String s : list ) { // for( 타입파라미터 ) 인덱스 생략
			System.out.println(s);
		}
		
		// 6. .contains 		: 해당 객체가 존재하면 true ( 검색 ? )
		System.out.println( list.contains("jdbㅋc"));
		
		// 7. .indexOf(객체) 		: 해당 객체의 인덱스 위치 반환 ( 검색 ? )
		System.out.println(list.indexOf("jdㅋbc"));
		
		// 8. list.isEmpty() 	: 리스트가 객체가 하나도 없으면 true / false
		System.out.println(list.isEmpty());
		
		// 9. list.iterator() 	: 리스트내 객체 순회
		System.out.println(list.iterator());
		
		// 7.
		list.clear();
		
		// 함수는 관례적 이름 get ~~ , set ~~ , is ~~
		
	}	
}
/*
	문자열 10개 저장한다.
	1. String[10] 배열 = new String[10]				/ 길이 필요 		
		 1. 선언된 길이는 변경 X
		 2. 추가 삭제 삽입 -> 직접 인덱스 시용
	2. ArrayList< String > 배열 = new ArrayList<>(); / 자동이라 길이 필요 X
		 1. 길이가 자동 [ 기본값 10 부터 ]
		 2. 추가 삭제 삽입 -> 함수( 미리 만들어진 코드 ) - > 편리하지만 무겁다.
		 
 */ 
 
