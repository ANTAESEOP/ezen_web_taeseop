package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			// 필수
			con = DriverManager.getConnection(					// DriverManager 구현객체
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {System.out.println("오류 : " + e );}
	}
	
}
