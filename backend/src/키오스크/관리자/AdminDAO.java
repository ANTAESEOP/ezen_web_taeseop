package 키오스크.관리자;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO {
	// 1.필드
	private Connection con;			// Connection  		: db연동 인터페이스
	private PreparedStatement ps;	// PreparedStatement: sql연동/조작 인터페이스 
	private ResultSet rs;			// ResultSet 		: sql결과[쿼리] 조작 인테페이스 		
	private static AdminDAO adao = new AdminDAO(); // 싱글톤 DAO 객체 [ 1. 생성자를 private , 2.정적객체 ]

	// 2.생성자
	private AdminDAO() {
		
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mmth", "root",  "1234");
		}catch (Exception e) { System.out.println("경고) DB연동 실패 : " + e ); } 
		
	}
	
	// 3.메소드
		// 1. 외부에서 싱글톤 객체를 반환 하는 메소드 
	public static AdminDAO getInstance() { return adao; }
	
	// 4. 기능 메소드 
		// 1. 메뉴 추가 [ 인수 : 메뉴이름   반환 : 성공/실패 ] 
	boolean inMenu( String menuname ) {
		String sql = "insert into menu values( null , ?  )"; // 1. SQL 작성
		try {
			ps = con.prepareStatement(sql); // 2. SQL 연결/조작
			ps.setString( 1 , menuname );	// ? : 첫번째 ? 에 변수 대입 
			ps.executeUpdate();				// 3. SQL 실행/결과조작
			return true;					// 4. 반환
		}catch (Exception e) { System.out.println("경고) 메뉴 추가 실패 : " + e ); }
		return false;
	}
		// 2. 메뉴 호출
	ArrayList< MenuDto > getMenu() {
		ArrayList< MenuDto > list = new ArrayList<>();
		String sql = "select * from menu";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // rs.next() : 다음 레코드
				MenuDto menu = new MenuDto(rs.getInt(1), rs.getString(2) );
				// 현재 검색된 현재 레코드의 필드 호출 : rs.get 자료형(검색필드순번)
				list.add(menu);
			}
			return list;
		}catch (Exception e) { System.out.println("경고) 메뉴 호출 실패 : " + e ); }
		return list;
		
	}
		// 3. 제품 추가 
	boolean InProduct(ProductDto productdto) {
		String sql ="insert into product values(null, ? , ? , ? , ? , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, productdto.getPname());
			ps.setInt(2, productdto.getPprice());
			ps.setString(3, productdto.getPcomment());
			ps.setShort(4, productdto.getPamount());
			ps.setByte(5, productdto.getMno());
			ps.executeLargeUpdate();
			return true;
		} catch (Exception e) 
			{ System.out.println("경고) 메뉴 추가 실패 : " + e );
		} // catch
		return false;
	} // 메소드 end
		// 4. 주문 확인 
}

/*
 1. view 에서 입력 받고 -> 컨트롤러로 이동
2. 컨트롤러 (inMenu)메뉴추가로직 ( menuname ) 에 담고 
3. 그 값을 return ( 반환 ) 해서 dao 로 이동
연결되어있는 (con) db에 PreparedStatement (sql)로 조작
slq = insert into menu values( null , ?  )
 */
 
