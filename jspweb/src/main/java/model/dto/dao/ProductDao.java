package model.dto.dao;

import java.util.ArrayList;

import model.dto.dto.PcategoryDto;
import model.dto.dto.ProductDto;

public class ProductDao extends Dao {
	
	// 1. 카테고리 등록 [ C ]
	public boolean setpcategory( String pcname ) {
		String sql = "insert into pcategory(pcname) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 카테고리 출력 [ R ]
	public ArrayList<PcategoryDto> getpcategory(){
		ArrayList<PcategoryDto> list = new ArrayList<>();
		String sql = "select * from pcategory";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				PcategoryDto dto
				= new PcategoryDto(rs.getInt(1) , rs.getString(2) );
				list.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 제품 등록 [ C ]
	public boolean setproduct(ProductDto dto) {
		return false;
	}
	// 4, 제품 출력 [ R ]
	public ArrayList<ProductDto>getProductlist() {
		return null;
		
	}
	
	
	
	
	
}
