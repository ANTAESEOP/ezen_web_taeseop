package ch10예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Dao dao = new Dao();

	public static Dao getInstance() { return dao; }

	// 생성자 
	private Dao() {
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mmth", "root",  "1234");
		}catch (Exception e) { System.out.println(e); }
	}
	
	// 메소드 
	public void signup( ) throws SQLException {
		String sql = "insert into menu values( null , ? )"; // 1. SQL 작성
			ps = con.prepareStatement(sql); // 2. SQL 연결/조작
			ps.setString( 1 , "과자" );	// ? : 첫번째 ? 에 변수 대입 
							// 3. SQL 실행/결과조작
			ps.executeUpdate(); // executeUpdate() : 실행
	}
	public void login( ) throws SQLException {
		String sql ="";
		ps = con.prepareStatement(sql);
		ps.executeQuery();
	}
	
}

