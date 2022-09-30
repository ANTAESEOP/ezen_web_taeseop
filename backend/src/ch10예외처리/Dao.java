package ch10예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	// 필드
	private Connection con;			// Connection  		: db연동 인터페이스
	private PreparedStatement ps;	// PreparedStatement: sql연동/조작 인터페이스 
	private ResultSet rs;			// ResultSet 		: sql결과[쿼리] 조작 인테페이스 		
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	// 생성자
	private Dao() throws SQLException{
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mmth", "root",  "1234");
		}catch (Exception e) { System.out.println( e ); } 	
	}
	
	// 메소드
	public void signup() throws SQLException{
		String sql = "insert into menu values( null , ?  )"; // 1. SQL 작성
			ps = con.prepareStatement(sql); 
			ps.setString( 1 , "과자" );	
			ps.executeUpdate();

	}
	public void login() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeQuery();
	}
}
