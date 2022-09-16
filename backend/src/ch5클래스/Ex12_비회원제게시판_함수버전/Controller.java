package ch5클래스.Ex12_비회원제게시판_함수버전;

public class Controller {
		
		static Board[] boardlist = new Board[100];
		// 1. 게시물 등록 함수
		static boolean con_regist(String title , String content , 
				String writer , String password) {
			
		// 1. 객체 생성
		Board board = new Board(title , content , writer , password , 0);
		
		for( int index = 0 ; index < boardlist.length ; index++) {
			if( boardlist[index] == null ) {
				boardlist[index] = board;
				return true;
			}
		}
		// 3.
		return false;
		}
		// 2. 게시물 삭제 함수
		static boolean con_delete(int bnum , String password ) {
			if( boardlist[bnum].password.equals(password) ) {
			for( int i = bnum ; i < boardlist.length ; i++) {
				boardlist[i] = boardlist[bnum+1]; // 한칸씩 당기기
				if( boardlist[i+1] == null ) { break;}
			} // for end
			return true;
			
		}else {
			return false;}
}
		// 3. 게시물 수정 함수
		static boolean con_update( int bnum , String password , String title , String content) {
			if( boardlist[bnum].password.equals(password) ) {
				boardlist[bnum].title = title;
				boardlist[bnum].content = content;
				return true;	
			}else {
				return false;}
		} // m end
		
		
		
		
}
