package ch5클래스.과제;

import java.util.ArrayList;

public class CONTROL {

	
// 가계부 추가 로직
	boolean cashInput( String cash_date , int cash_price , String cash_content  ) {
		
		CashDTO dto = new CashDTO(0 , cash_date , cash_price , cash_content);
		return DAO.getInstance().cashInput(dto);
	}	
		
// 내용 호출
	ArrayList<CashDTO> read() {
		return DAO.getInstance().read();
	}
	
// 가계부 삭제 로직
	boolean delete (int pno) {
		return DAO.getInstance().delete(pno);
	}

// 가계부 수정 로직
	boolean cashEdit(String cash_date , int cash_price , String cash_content) {
		
		CashDTO dto = new CashDTO(0 , cash_date , cash_price , cash_content);
		return DAO.getInstance().cashInput(dto);
	}
}