package ch5클래스.과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DAO dao = new DAO();
	
	// 2. 생성자
	public DAO () {
		try {
		con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cash_db",
					"root",
					"1234");
		} catch (Exception e) {System.out.println(" 경고) DB 접속 실패 " + e);}
	}
	
	public static DAO getInstance() {return dao;}
	// 가계부 추가
	boolean cashInput(CashDTO cashDTO) {
		String sql = "insert into cash values(null , ? , ? , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cashDTO.getCash_date());
			ps.setInt(2, cashDTO.getCash_price());
			ps.setString(3, cashDTO.getCash_content());
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("추가실풰" + e);}
		return false;
	} // insert end
	
	// 2. 가계부 출력
	ArrayList<CashDTO> read() {
		ArrayList<CashDTO> list = new ArrayList<>();
		String sql = "select * from cash";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				CashDTO dto = new CashDTO(
						rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4));
			list.add(dto);
			}
			return list;
			} catch (Exception e) {System.out.println("추가실풰" + e);}
		return list;
	} // read end
	
	// 가계부 삭제
	boolean delete( int pno ) {
		String sql = "delete from cash where num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate(); return true;
		}catch (Exception e) {}
		return false;
	} // delete end

	// 가계부 수정
		boolean cashEdit(CashDTO cashDTO) {
			String sql = "UPDATE from cash set cash_date = ? , cash_price = ? , cash_content = ? where num = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(0, cashDTO.getCash_date());
				ps.setInt(1, cashDTO.getCash_price());
				ps.setString(2, cashDTO.getCash_content());
				ps.setInt(3, cashDTO.getPno());
				ps.executeUpdate(); return true;
			} catch (Exception e) {System.out.println("추가실풰" + e);}
			return false;
			
	} // edit end
} // class end