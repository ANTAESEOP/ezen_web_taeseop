package model.dto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con; 			// DB 연결 인터페이스
	PreparedStatement ps ;		// SQL 조작 인터페이스
	ResultSet rs;				// 쿼리 조작 인터페이스

	public Dao () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			// 필수
			con = DriverManager.getConnection(					// DriverManager 구현객체
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {System.out.println("오류 : " + e );}
	}
	
	
}
