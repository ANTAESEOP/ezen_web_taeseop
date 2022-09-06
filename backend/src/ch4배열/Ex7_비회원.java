package ch4배열;

import java.util.Scanner;

public class Ex7_비회원 { // main start
		public static void main(String[] args) { // main start
			
			int writinglist = 0;
			String[][] writing = new String[100][2]; // 문자열 100개를 저장
			Scanner scanner = new Scanner(System.in); // 입력객체
			
			
			while ( true ) { // while start
				
			System.out.println("================== 커뮤니티 페이지 ==================");
			System.out.println("번호 작성자 제목");
			System.out.println("1. 글쓰기 2.글보기");
			System.out.println("===============================================");
			System.out.print("선택 : "); int btn = scanner.nextInt();
			
			if( btn == 1) { // if btn 1 start
			System.out.println("================== 글 쓰기 페이지 ==================");
			System.out.print("title : "); String title = scanner.next();
			System.out.print("content : "); String content = scanner.next();
			System.out.print("writer : "); String writer = scanner.next();
			System.out.print("password : "); String password = scanner.next();
			
			} // if btn 1 end

			
			else if ( btn == 2) {
				{
					for( int i = 0 ; i<writing.length ; i++) {
						System.out.printf("[%d]> %d \n", i , writing[i] );
					} // for end
				} 
			}
			
			
			
			
			
			
			
			
			//for( int i = 0 ; i<writing.length; i++) {
			//System.out.println("?");
		//}
		// btn = new int[writinglist];// 입력받은  글수 만큼 배열에 메모리(길이) 할당
			
			
			
			
			
			
			//else if {}
			//else if {}
		} // while end
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} // main end

} // main end
