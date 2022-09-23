package ch11API클래스;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import 키오스크.관리자.MenuDto;



public class CalDAO {
	// 1.필드
		private Connection con;			// Connection  		: db연동 인터페이스
		private PreparedStatement ps;	// PreparedStatement: sql연동/조작 인터페이스 
		private ResultSet rs;			// ResultSet 		: sql결과[쿼리] 조작 인테페이스 		
		private static CalDAO cdao = new CalDAO(); // 싱글톤 DAO 객체 [ 1. 생성자를 private , 2.정적객체 ]
		

		// 2.생성자
		CalDAO() {
			
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/cal_db", "root",  "1234");
			}catch (Exception e) { System.out.println("경고) DB연동 실패 : " + e ); } 
			
		}
		public static CalDAO getInstance() { return cdao; }

		boolean inList( String plan_date , String plan_memo ) {
			String sql = "insert into cal_plan values (null , ? , ? );"; // 1. SQL 작성
			try {
				ps = con.prepareStatement(sql); // 2. SQL 연결/조작
				ps.setString( 1 , plan_date );	// ? : 첫번째 ? 에 변수 대입 
				ps.setString( 2 , plan_memo );	// ? : 첫번째 ? 에 변수 대입 
				ps.executeUpdate();				// 3. SQL 실행/결과조작
				return true;					// 4. 반환
			}catch (Exception e) { System.out.println("경고) 메뉴 추가 실패 : " + e ); }
			return false;
		}
		/*
		HashMap<Integer, ArrayList<String> > 일정출력() {
			String sql = "select * from cal_plan";
			HashMap<Integer, ArrayList<String> > map = new HashMap<>();
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					ArrayList<String> values = new ArrayList<>();
					values.add(rs.getString(2));
					values.add(rs.getString(3));
					map.put(rs.getInt(1), values);
				}
				return map;
			}catch (Exception e) {}
			return map;
		}
		*/
		
		
		
		
		
}
