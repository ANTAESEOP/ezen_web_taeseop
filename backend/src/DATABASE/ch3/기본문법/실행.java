package DATABASE.ch3.기본문법;

import java.util.Scanner;
import java.util.ArrayList;

public class 실행 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
				System.out.println("1 ~ 19 예제 번호 선택 : ");
				int ch = scanner.nextInt();
				
				// 메소드\ 호출 방법
					// 1. static(정적) 선언된 함수 : 클래스명.함수명()
					// 2. 일반함수 : 객체명.함수명()
				DAO dao = new DAO(); // dao 객체 생성
				// 1.
				if( ch == 1 ) {
					ArrayList< MemberDto > list = dao.예제1결과();
					System.out.println("--------------예제1 결과물 --------------");
					for( MemberDto dto : list ) {
						System.out.print(dto.mem_id			+ "\t");
						System.out.print(dto.mem_name		+ "\t");
						System.out.print(dto.mem_number		+ "\t");
						System.out.print(dto.addr			+ "\t");
						System.out.print(dto.phone1			+ "\t");
						System.out.print(dto.phone2			+ "\t");
						System.out.print(dto.height			+ "\t");
						System.out.print(dto.debut_date		+ "\n");
					} // for end
				} // if ch == 1 end
				
				//2.
				else if ( ch == 2 ) {
					ArrayList< String > list = dao.예제2결과();
					System.out.println("--------------예제2 결과물 --------------");
					for( String a : list ) {
						System.out.println(a + "\t");
					} // for end
					System.out.println();
				} // ch == 2 end
				
				// 3.
				else if ( ch == 3 ) {
					ArrayList< String > list = dao.예제3결과();
					System.out.println("--------------예제3 결과물 --------------");
					for( String b : list ) {
						System.out.printf(b + "\t");
					} // for end
					System.out.println();
				} // ch == 3 end
				
				// 4.
				else if  ( ch == 4 ) {
					System.out.println("--------------예제4 결과물 --------------" + "\n");
					ArrayList< String > list = dao.예제4결과();
					for( String c : list ) {
						System.out.printf(c + "\n");
					} // for end
					System.out.println();
				} // ch == 4 end
				
				// 5. 
				else if ( ch == 5 ) {
					ArrayList<MemberDto> list = dao.예제5결과();
					System.out.println("--------------예제5 결과물 --------------");
					for( MemberDto dto : list) {
						System.out.println(dto.mem_name		+ "\t");
						System.out.println(dto.height		+ "\t");
						System.out.println(dto.mem_number	+ "\n");
					}
				} // ch == 5 end
				
				// 6.
				else if ( ch == 6 ) {
					ArrayList<MemberDto> list = dao.예제6결과();
					System.out.println("--------------예제6 결과물 --------------");
					for( MemberDto dto : list) {
						System.out.println(dto.mem_name		+ "\t");
						System.out.println(dto.height		+ "\t");
						System.out.println(dto.mem_number	+ "\n");
					}
				} // ch == 6 end
				
				// 7.
				else if ( ch == 7 ) {
					MemberDto dto = dao.예제7결과(); {
					System.out.println("--------------예제7 결과물 --------------");
							System.out.print(dto.mem_id			+ "\t");
							System.out.print(dto.mem_name		+ "\t");
							System.out.print(dto.mem_number		+ "\t");
							System.out.print(dto.addr			+ "\t");
							System.out.print(dto.phone1			+ "\t");
							System.out.print(dto.phone2			+ "\t");
							System.out.print(dto.height			+ "\t");
							System.out.print(dto.debut_date		+ "\n");
					} // for end
				} // ch == 7 end
				
				// 8.
				else if ( ch == 8 ) {
					ArrayList< String > list = dao.예제8결과();
					System.out.println("--------------예제8 결과물 --------------");
					for( String e : list ) {
						System.out.print(e + "\t");
					}
				}
				
				// 9.
				else if ( ch == 9 ) {

					}
				
		} // while end
	} // main end
} // class end
