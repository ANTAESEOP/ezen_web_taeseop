package DATABASE.ch3.기본문법;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	// 1. 필드
	Connection con; 		// db연결 인터페이스
	PreparedStatement ps;	// sql 연결 / 조작 인터페이스
	ResultSet rs;			// sql 결과[쿼리] 조작 인터페이스
	
	// 2. 생성자 : 객체 생성시 초기값
	public DAO () {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/market_db",
					"root",
					"1234");
		} catch (Exception e) {System.out.println("오류 : " + e );}
	}
	
	// 3. 메소드
	// 1. 예제 1 : 레코드 10줄 - > memberDto 8개 -> 배열 / 리스트
	public ArrayList< MemberDto > 예제1결과( ) {
		
		// 배열 대신에 배열을 편하게 사용할 수 있는 미리 만들어진 클래스 [ 컬렉션(수집) 프레임워크 ]
			// 리스트 [선언] : ArrayList<리스트에 들어갈 클래스> 리스트명 = new Arraylist<>();
			// 리스트 객체 담기 : 리스트명.add( 객체명 )
		ArrayList< MemberDto > list = new ArrayList<>();	// MemberDto 로 생성된 객체 여러개를 담을 수 있는 list 객체 선언
		// 1. SQL 작성
		String sql = "select * from member";
		// 2. SQL 연결조작
		try {
			ps = con.prepareStatement(sql);
			// 3. SQL 결과조작
			rs = ps.executeQuery();
			while(rs.next() ) {
				// 레코드 -> 객체화
				MemberDto dto = new MemberDto
						(	rs.getString(1), rs.getString(2),
							rs.getInt(3), rs.getString(4),
							rs.getString(5), rs.getString(6),
							rs.getShort(7), rs.getString(8) );
				// 객체 -> 배열 / 리스트 담기
				list.add(dto);
			} // while end
			return list;
		}catch (Exception e) { System.out.println("예제1 오류 : " +  e); }
		return list;
		
	} // 예제1 결과 메소드 end
///////////////////////////////////////////////////////////////////////////////////////////
	// 2. 예제2 : 레코드 10줄 1 칸
	ArrayList< String > 예제2결과() {
		
		ArrayList< String > list = new ArrayList<>();
		String sql = "select mem_name from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // rs.next() : 다음 레코드 이동
				list.add(rs.getString( 1 ) );
			} // while end
			
			return list; // 반환
		}catch (Exception e) { System.out.println("예제2 오류 : " + e); }
		
		return list; // 반환
	} // 예제2 결과 메소드 end
///////////////////////////////////////////////////////////////////////////////////////////
	// 3. 예제3 :
	ArrayList< String > 예제3결과() {
	ArrayList< String > list = new ArrayList<>();
	String sql = "select * from member where mem_name ='블랙핑크'";
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while( rs.next() ) { // rs.next() : 다음 레코드 이동
			list.add(rs.getString( 1 ) );
			list.add(rs.getString( 2 ) );
			list.add(rs.getString( 3 ) );
			list.add(rs.getString( 4 ) );
			list.add(rs.getString( 5 ) );
			list.add(rs.getString( 6 ) );
			list.add(rs.getString( 7 ) );
			list.add(rs.getString( 8 ) );
		} // while end
		return list; // 반환
	}catch (Exception e) { System.out.println("예제3 오류 : " + e); }
	return list; // 반환
	} // 예제3 결과 메소드 end
///////////////////////////////////////////////////////////////////////////////////////////
	// 4. 예제4 :
	ArrayList< String > 예제4결과() {
	ArrayList< String > list = new ArrayList<>();
	String sql = "select mem_id , mem_name from member where height <= 162";
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while( rs.next() ) { // rs.next() : 다음 레코드 이동
			list.add(rs.getString( 1 ) ); 
			list.add(rs.getString( 2 ) );

		} // while end
		return list; // 반환
	}catch (Exception e) { System.out.println("예제4 오류 : " + e); }
	return list; // 반환
	} // 예제4 결과 메소드 end
///////////////////////////////////////////////////////////////////////////////////////////	
	ArrayList<MemberDto> 예제5결과 () {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select mem_name , height , mem_number"
				+ " from member "
				+ " where height >= 165 and mem_number > 6";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				MemberDto dto = new MemberDto(); 
				dto.mem_name = rs.getString(1);
				dto.height = rs.getShort(2);
				dto.mem_number = rs.getInt(3);
				list.add(dto);
			}
			return list;
		}catch (Exception e) { System.out.println("예제5 오류 : " + e);}
		return list;
	} 
///////////////////////////////////////////////////////////////////////////////////////////	
	ArrayList<MemberDto> 예제6결과 () {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select mem_name , height , mem_number"
				+ " from member"
				+ " where height >= 165 or mem_number > 6";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				MemberDto dto = new MemberDto(); 
				dto.mem_name = rs.getString(1);
				dto.height = rs.getShort(2);
				dto.mem_number = rs.getInt(3);
				list.add(dto);
			}
			return list;
		}catch (Exception e) { System.out.println("예제6 오류 : " + e);}
		return list;
	} 
///////////////////////////////////////////////////////////////////////////////////////////	
		MemberDto 예제7결과() {
		MemberDto dto = null;
		String sql = "select * from member"
				+ " where mem_name like '우%'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				dto = new MemberDto
						(rs.getString(1), rs.getString(2),
						rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getShort(7), rs.getString(8) );
				return dto;
			}
		}catch (Exception e) { System.out.println("예제7 오류 : " + e); }
		return dto; // 반환
		} // 예제7 결과 메소드 end
///////////////////////////////////////////////////////////////////////////////////////////	
		ArrayList< String > 예제8결과() {
			ArrayList< String > list = new ArrayList<>();
			String sql = "select * from member where mem_name like '__핑크'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) { // rs.next() : 다음 레코드 이동
					list.add(rs.getString( 1 ) );
					list.add(rs.getString( 2 ) );
					list.add(rs.getString( 3 ) );
					list.add(rs.getString( 4 ) );
					list.add(rs.getString( 5 ) );
					list.add(rs.getString( 6 ) );
					list.add(rs.getString( 7 ) );
					list.add(rs.getString( 8 ) );
				} // while end
				return list; // 반환
			}catch (Exception e) { System.out.println("예제8 오류 : " + e); }
			return list; // 반환
			} // 예제8 결과 메소드 end
/////////////////////////////////////////////////////////////////////////////////////////
		// 9.  예제9 :
		// 10. 예제10 :
		// 11. 예제11 :
		// 12. 예제12 :
		// 13. 예제13 :
		// 14. 예제14 :
		// 15. 예제15 :
		// 16. 예제16 :
		// 17. 예제17 :
		// 18. 예제18 :
		// 19. 예제19 :
		

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

