package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC실행2 {
	public static void main(String[] args) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/shop_db3",
				"root",
				"1234");
		System.out.println("자비스 연동 성공"  + "\n");
		
		/*
		String sql = "insert into product values('바나나' , 1500 , '2021-07-01' , '델몬트' , 17),"
												+ "('카스',2500,'2022-03-01','OB',3),"
												+ "('삼각김밥',800,'2023-09-01','CJ',22);";
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.executeUpdate();
		*/
	
	/*	
		// 카스의 갯수 변경
		String sql = "update product set amount = 10 where product_name = '카스'";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
		
		
		// 삼각김밥 제거
		sql = "delete from product where product_name = '삼각김밥'";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	*/
		
	
		// 모든 제품의 정보를 console 출력
		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next() ) {
			System.out.println("제품명 : " + rs.getString(1) + "\t");
			System.out.println("가격 : " + rs.getString(2) + "원" + "\t");
			System.out.println("제조일자 : " + rs.getString(3) + "\t");
			System.out.println("제조회사 : " + rs.getString(4) + "\t");
			System.out.println("재고 : " + rs.getString(5) + "\n");
		}
			
		} catch (Exception e) {System.out.println("연동 실패 : " + e );}			
	}	
}

