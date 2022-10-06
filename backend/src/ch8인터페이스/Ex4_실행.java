package ch8인터페이스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Ex4_실행 {

	public static void main(String[] args) {
		
		// 1. 인터페이스 변수에 구현객체 대입
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		
		// 2. 인터페이스에 없는 메소드 이므로 사용불가
		// vehicle.checkFare(); [X]
		
		// 3. 강제 형변환 [ 인터페이스 -> 객체 ]
			// 객체 / 변수 명 instanceof 클래스명
		System.out.println("관계확인 : " + (vehicle instanceof Television));
		System.out.println("관계확인 : " + (vehicle instanceof Bus));
		// Bus bus = (Television)vehicle
		Bus bus = (Bus)vehicle;
		
		bus.run();
		bus.checkFare();
		
		// *** 컬렉션 프레임워크
		List<String> list ; // 인터페이스 변수 선언
			
			// 1. 인터페이스 변수에 arraylist 객체 탑재
		list = new ArrayList<>();
			list.add("ㅇㅇ");
			
			// 2. 인터페이스 변수에 vector 객체 탑제
		list = new Vector<>();
			list.add("ㅁㅁ");
			
			// 3. 인터페이스 변수에 Linkedlist 객체 탑재
		list = new LinkedList<>();
			list.add("ㅋㅋ");
		
		System.out.println();
		
		
		
		
	}
	
	
}
