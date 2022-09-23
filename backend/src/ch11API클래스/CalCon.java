package ch11API클래스;

import java.util.ArrayList;


public class CalCon {
	
	// 1. 일정 추가 로직
		boolean inList( String plan_date , String plan_memo ) {
			return CalDAO.getInstance().inList(plan_date , plan_memo);
		}	
}		
		
