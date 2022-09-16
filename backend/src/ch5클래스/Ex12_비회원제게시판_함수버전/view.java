package ch5클래스.Ex12_비회원제게시판_함수버전;

import java.util.Scanner;

public class view {
	// 변수는 괄호 밖으로 못나감
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		start(); // 함수 호출
	}
	
	// 1. 프로그램 시작하는 함수 [ 매게변수 X /  반환 X /  정적메소드: 호출시 객체 생략 가능 ]
	static void start() {
		while(true) {
			view_boardlist(); // 무조건 view_boardlist( ); 함수 호출
			System.out.println("------------비회원 게시판------------");
			System.out.println("1. 글쓰기 2. 글보기 : ");
			int ch = scanner.nextInt();
			if( ch == 1) { view_regist(); } // 만일 1번을 입력했으면 view_regist(); 함수 호출
			else if ( ch== 2 ) {view_board(); } // 만일 2번을 입력했으면 view_board(); 함수 호출
			else { System.out.println("알수없는 번호 입니다."); }
		}
	} // start end
	
	// 2. 게시물 등록하는 화면 구현 함수
	static void view_regist( ) {
	System.out.println(">> 게시물 등록 페이지 <<");
	System.out.println(" 제목 : ");		String title = scanner.next();
	System.out.println(" 내용 : ");		String content = scanner.next();
	System.out.println(" 작성자 : ");		String writer = scanner.next();
	System.out.println(" 비밀번호 : ");	String password = scanner.next();
	Controller.con_regist(title, content, writer, password);
	
	
	// 1. 메소드 호출 [ 통신 ]
	boolean result = Controller.con_regist( title , content , writer , password );
	
	// 2. 메소드 호출한 결과
	if( result ) {
		System.out.println("안내)게시물 등록 완료");
	}else {
		System.out.println("안내)게시물 등록 실패");
	}
	return;
}
	
	// 3. 게시물 상세페이지 화면 구현 함수
	static void view_board( ) {
		System.out.println("게시물번호 선택 : "); int bnum = scanner.nextInt();
		System.out.println(">> 게시물 상세 페이지 <<");
		
		Board temp = Controller.boardlist[bnum]; // 새로운 객체 = 입력받은 인덱스의 객체
		if( temp == null ) {System.out.println("안내) 없는게시물번호입니다. "); return; }
		
		System.out.println("제목 : " + temp.title  +"      작성자 : " + temp.writer );
		System.out.println("내용 : " + temp.content );
		System.out.print("1.뒤로가기 2.수정 3.삭제 선택 : ");	int ch = scanner.nextInt();
		if( ch == 1 ) {} 
		else if( ch== 2 ) {} // 수정 화면 함수 호출 
		else if( ch == 3 ) {view_delete(bnum);} // 삭제 화면 함수 호출 
		else { } 
		return;
	}
		
		
	// 4. 게시물 목록 화면 구현 함수
	static void view_boardlist () {
		
	System.out.println(">> 게시물 목록 페이지 <<");
	System.out.println("번호\t\t작성자\t\t제목");
	for( int i = 0 ; i < Controller.boardlist.length; i++ ) {
		Board temp = Controller.boardlist[i];
		if( temp != null ) {
			System.out.print( i +"\t\t");
			System.out.print( temp.writer +"\t\t"); // temp 미사용시 Contorller.boardlist[i].writer
			System.out.print( temp.title +"\n");
		} 
	}
	return;
	}
	
	//5. 게시물 삭제 구현 함수
	static void view_delete (int bnum) {
		System.out.println(" 비밀번호 : "); String password = scanner.next();
		if( Controller.boardlist[bnum].password.equals(password) ) {
			Controller.con_delete(bnum , password);
		}else {
			System.out.println("안내) 비밀번호가 다릅니다.");
		}
	} // m end
	
	// 6. 게시물 수정 함수
	static void view_update( int bnum ) {
		System.out.println("비밀번호 : "); String password = scanner.next();
		System.out.println("수정할 제목 : "); String title = scanner.next();
		System.out.println("수정할 내용 : "); String content = scanner.next();
		
		boolean result =
				Controller.con_update(bnum, password, title, content);
		if( result ) { System.out.println("안내) 게시물 수정 선공");}
		else {System.out.println("안내) 게시물 수정 실패");
	}
	
}
}
