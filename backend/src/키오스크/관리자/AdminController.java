package 키오스크.관리자;

import java.util.ArrayList;

public class AdminController {
	
	
	// 2. 메뉴 추가 로직
	boolean inMenu( String menuname ) {
		return AdminDAO.getInstance().inMenu(menuname); // 싱글톤객체 메소드 호출 
	}
	// 3. 메뉴 호출 로직
	ArrayList< MenuDto > getMenu() {
		return AdminDAO.getInstance().getMenu();
	}
	// 3. 제품 추가 로직 
	boolean inProduct( String pname,int pprice,
			String pcomment , short pamount , byte mno ) { 
		ProductDto dto = new ProductDto(0 , pname , pprice , pcomment , pamount , mno);
		return AdminDAO.getInstance().InProduct(dto);
	}

	// 4. 주문 확인 로직 
	void getOrder( ) { }
	
}
