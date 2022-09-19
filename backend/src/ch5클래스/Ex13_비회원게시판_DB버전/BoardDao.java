package ch5클래스.Ex13_비회원게시판_DB버전;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDao { // class start
	
	// JDBC 자주 사용 하는 클래스 / 인터페이스
	Connection con; 		// DB 접속할 수 있는 인터페이스
		// con = DriverManager.getConnection("DB주소" , "DB계정명" , "DB비밀번호" )
	PreparedStatement ps; 	// 접속된 DB에 SQL 연결 조작하는 인터페이스
	ResultSet rs;			// SQL 결과를 조작하는 인터페이스
	
	// 2. 생성자
	public BoardDao () {
		// 빈 생성자에 DB 접속 코드 ( 객체 생성시 자동으로 DB 접속 )
		
		try {
		con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardtest",
					"root",
					"1234");
		} catch (Exception e) {System.out.println(" 경고) DB 접속 실패 " + e);}
	}
	// 3. 메소드
		// 1. 등록 메소드
	boolean regist( BoardDto boardDto) {
			// 1. SQL 작성
		String sql = "insert "
				+ "	into "
				+ "	board( b_title , b_content , b_writer , b_password , b_view ) "
				+ "	values( ? , ? , ? , ? , ? )";
			// ? : 변수 들어갈 자리 [ 와일드카드 ]
			// 2. SQL 연결 조작
		try {
			ps = con.prepareStatement(sql); // 위에서 작성된 sql을 ps 인터페이스 연결
				// * : ? 에 변수 넣기
				ps.setString(1 , boardDto.b_title);		// 1 : 첫 번쨰 ? , 제목
				ps.setString(2 , boardDto.b_content);	// 2 : 두 번쨰 ? , 내용
				ps.setString(3 , boardDto.b_writer);	// 3 : 세 번쨰 ? , 작성자
				ps.setString(4 , boardDto.b_password);	// 4 : 네 번쨰 ? , 패스워드
				ps.setInt( 5 , 0 );						// 5 : 다섯 번째 ? , 0 	게시물 등록시 조회수 0 으로 시작
			ps.executeUpdate();				// ps 인터페이스 sql 실행
			return true; 					// 등록 성공시 true
			// 3. SQL 결과
		} catch (Exception e) {System.out.println("경고) DB오류 : " + e );}
		return false; // 등록 실패시 false
	}
	
	// * 전체 게시물 수 메소드
	int getrows() {
		String slq = "select count(*) from board"; // 1. SQL 작성
		try { // 2. SQL 연결 / 조작
			ps = con.prepareStatement(slq);
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt(1);} // 레코드[ =행 / =게시물 ] 수 반환
		} catch (Exception e) { System.out.println("경고) DB오류 : " + e);}
		return 0; // 없으면 0
	}
	
		// 2. 모든 게시물 출력 메소드
		BoardDto[] getBoardlist( ) {
			int count = getrows( ); // 전체 게시물 수 함수 호출 ->  반환 count 저장
			BoardDto[] boardlist = new BoardDto[getrows()]; // 배열 선언 [ 배열의길이 = 게시물수 ]
			
			String sql = "select * from Board;"; // 1. SQL 작성
			try { // 2. SQL 연결 / 조작
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery(); // select : executeQuery() // insert , update , delete
				// ResultSer rs : 쿼리[SQL결과]에 조작
				// rs - > null ->.next()--> 검색된레코드1
				int row = 0;
				while( rs.next() ) {
					// 레코드 한개당 6개의 필드 -> 6개 변수 -> 객체 - > 배열
					int b_no = rs.getInt( 1 ); // 해당 레코드의 첫번째 필드의 데이터 호출
					String b_title = rs.getString(2);
					String b_content = rs.getString(3);
					String b_writer = rs.getString(4);
					String b_password = rs.getString(5);
					int b_view = rs.getInt(6);
					// 객체화
					BoardDto board = new BoardDto(b_no, b_title, b_content, b_writer, b_password, b_view);
					// 객체화2
					//
					// 2. 객체를 배열에 저장
					boardlist[row] = board;
					row++;
					// 3. 인덱스 증가
			}
			
		} catch (Exception e) {System.out.println("경고) DB오류 : " + e );}
		// 3. SQL 결과
		return boardlist;
	}
		// 3. 개별 게시물 출력 메소드
	BoardDto getboard( int b_no ) {
		BoardDto board = null;
		// 1. SQL 작성
		String slq = "select * from board where b_no = ?"; // ? 변수가 들어갈 자리
		// 2. SQL 연결/조작
		try {
			ps = con.prepareStatement(slq);
			ps.setInt(1, b_no);
			rs = ps.executeQuery(); // ResultSet : rs
			if( rs.next() ) {
				board = new BoardDto(rs.getInt(1) , rs.getString(2) , rs.getString(3)
						, rs.getString(4) , rs.getString(5) , rs.getInt(6));
			}
		} catch (Exception e) { System.out.println("경고) DB오류 : " + e);}

		// 3. SQL 조작
		return board;
	}
		// 4. 수정 처리 메소드
	// boolean update( int b_no , String b_password , String new_title , String new_content ) {
		// 1. SQL 작성
		String sql = "update * from board where b_no = ? , b_password = ? , b_title = ? , b_content = ?";
		// try {
			// ps = con.prepareStatement(sql);
			// ps.setInt(b_no , sql);
			// ps.setString(b_password, sql);
			// ps.setString(new_title, sql);
			// ps.setString(new_content, sql);
			// ps.executeUpdate();
		//} catch (SQLException e) { System.out.println("경고) DB오류 : " + e);}
			
		// return false;
	// }
	
		// 5. 삭제 처리 메소드
	boolean delete( int b_no , int b_password) {
		// SQL 코드 들어갈 예정
		return false;
	}
	
	
	
	
} // class end	
