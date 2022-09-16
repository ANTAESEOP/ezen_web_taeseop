package ch5클래스.Ex13_비회원게시판_DB버전;

import java.util.Scanner;

public class BoardPage {
	Scanner scanner = new Scanner(System.in); // 입력객체 [ 함수 밖에 만든 이유 : 모든 메소드에서 사용하려고 ]
	BoardControl control = new BoardControl();
	public static void main(String[] args) {
	
		// 메소드 호출 방식 : 1. static 2. new
		BoardPage  page = new BoardPage();
		page.view();
	} // main end
	// 0. 메인화면
	void view () {
		
		BoardPage page = new BoardPage(); // 메소드 호출용 객체
		
		while( true ) { // 무한루프
			page.getBoardlist();
			System.out.println("1. 글쓰기 2. 글 제목 선택 : "); // 1. 안내[출력] -> 입력 [scanner] - > 저장[변수]
			int btn = scanner.nextInt(); // int 변수를 사용하는 이유 ??
			
			// 경우의수 2개+1개(그외)
			if( btn == 1) {page.regist(); }						// 1번 입력하면 등록함수 호출
			else if (btn == 2) {page.getBoard(); }			// 2번 입력하면 개별게시물 출력화면 함수 호출
			else {System.out.println("경고) 알수 없는 번호 입니다.");} 	//
			
		} // while end
	} // view end
	// 1. 등록화면
	
	void regist () {
		System.out.println(">> 등록 페이지 ");
		// 1. 출력 -> 입력 -> 저장
		System.out.print(">> 제목 : "); 		String b_title = scanner.nextLine();
		System.out.print(">> 내용 : ");		String b_content = scanner.nextLine();
		System.out.print(">> 작성자 : ");		String b_writer = scanner.next();	
		System.out.print(">> 패스워드 : ");	String b_password = scanner.next();
		scanner.nextLine(); // scanner.nextLine(); 겹치는 문제 해결방안 
		// 2. 입력받은 데이터를 control 이동 [ 다른 클래스의 메소드 호출 ]
		boolean result = control.regist(b_title, b_content, b_writer, b_password);
		// control 처리된 결과를 result 에 저장한 다음 제어 [ control 실행 후 결과의 경우의 수 ]
		if( result) { System.out.println("안내) 게시물 등록 완료");}
		else {System.out.println("안내) 게시물 등록 실패 ");}
	} // m end
	// 2. 모든 게시물 출력화면
	void getBoardlist () {	
		System.out.println(">> 게시판 ");
		System.out.println("번호\t작성자\t제목\t조회수");
		
		BoardDto[] boardlist = control.getBoardlist(); // control 에서 모든 게시물호출 메소드 호출 -> 모든 게시물의 배열을 변환 받는다.
		
		// for( int i = 0 ; i<boardlist.length; i++ ) {
		for( BoardDto dto : boardlist) { // 모든 게시물의 배열을 반복문 돌린다 [ 향상된 for 문 ]
		// for( 배열의자료형 반복변수명 : 배열 )
			System.out.print(dto.b_no + "\t");		System.out.print(dto.b_writer + "\t");
			System.out.print(dto.b_title + "\t");		System.out.print(dto.b_view + "\n");
		}
	} // m end
	// 3. 개별게시물 출력 화면
	void getBoard () {	
		System.out.println(">> 게시물 번호 : "); int b_no = scanner.nextInt();
		BoardDto board = control.getBoard( b_no ); // 2. 입력받은 번호를 getBoard 메소드에 전달하면 해당 게시물 출력
			if( board == null ) {System.out.println("경고) 해당 게시물이 없습니다. "); return;}
		
		
		System.out.println(">> 개별조회 페이지 ");
		System.out.println(" 제목 : " + board.b_title + "\t");
		System.out.println(" 작성자 : " + board.b_content + "\t");
		System.out.println(" 조회수 : " + board.b_view);
		System.out.println(" 내용 : " + board.b_content);
			// 출력
		System.out.println("1. 뒤로가기 2. 수정 3. 삭제 : ");
		int btn = scanner.nextInt();
		BoardPage page = new BoardPage();
		if( btn == 1) { return; }
		else if ( btn == 2 ) {page.update(); } // 2번 선택시 업데이트 함수 호출
		else if ( btn == 3 ) {page.delete(); } // 3번 선택시 삭제 함수 호출
		else {}
	} // m end
	// 4. 수정 처리 출력 화면
	void update () {	
		System.out.println(">> 수정처리 페이지 ");			
		System.out.println(" 수정할 번호 : " + "\t");	
		System.out.println(" 수정할 비밀번호 : " + "\t");	
		System.out.println(" 수정할 제목 : ");	
		System.out.println(" 수정할 내용 : ");	
	} // m end
	// 5. 삭제처리 출력 화면
	void delete () {	
		System.out.println(">> 삭제처리 페이지 ");
	} // m end
}
