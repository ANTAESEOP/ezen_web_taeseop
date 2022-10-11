package model.dao;

import model.dto.postDto;

public class postDao extends Dao {
	
	// 싱글톤
	private static postDao pdao = new postDao();
	public static postDao getInstance() {return pdao;}
	
	postDto dto = new postDto();
	
	// 1. 게시판 등록
	public boolean inputpost(postDto dto) {
		String sql = "insert into post(ptitle , pwriter , pcontent , ppassword) values (?,?,?,?)";;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPtitle() );
			ps.setString(2, dto.getPwriter() );
			ps.setString(3, dto.getPcontent() );
			ps.setString(4, dto.getPpasword() );
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	} // 게시판 end
	
	
	
}
