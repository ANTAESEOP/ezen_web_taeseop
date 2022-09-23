package ch11API클래스;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import 키오스크.관리자.AdminController;
import 키오스크.관리자.MenuDto;

public class Ex4_달력 {
	
	// 1. 필드
	Scanner scanner = new Scanner(System.in);	// 입력객체
	CalDAO cdao = new CalDAO();
	Calendar cal = Calendar.getInstance();		// 달력객체
	int year = cal.get( Calendar.YEAR );
	int month = cal.get( Calendar.MONTH) + 1;
	int day = cal.get( Calendar.DAY_OF_MONTH);
	
	// 2. 생성자
	
	// 3. 메소드
	void run() {
		while( true ) {
			cal.set(year , month-1 , 1); // *** 현재날짜를 이용한  1일의 요일 찾기
			int sweek = cal.get( Calendar.DAY_OF_WEEK); // *** 현재날짜의 마지막 일 수 찾기
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.printf("===== %d년 %d월 의 달력 ===== \n "
								, year , month ); 
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			// 1. 1일의 전 까지 공백 반복문
			for( int i = 1 ; i<sweek ; i++) {System.out.print("\t");}
			
			// 2. 1일부터 ~ 마지막 일 수 까지 일 수를 출력하는 반복문
			for( int i = 1 ; i<=eday ; i++) {System.out.printf( "%2d \t" , i);
				// 토요일 이후에 줄바꿈 처리
				if( sweek % 7 == 0  ) { System.out.println();}
				sweek++; // 일 수를 출력할 떄마다 요일도 증가처리
			}
			System.out.println("\n====================================================");
			/////////////////////////////////////////////////////////////////////////////
			System.out.println("◀이전달[1] ▶다음달[2] 검색[3] 일정추가[4]");
			int btn = scanner.nextInt();
				// 이전달 : 월에서 1차감 [ 만일 월이 0이면 월=12 설정 연도 1 차감 ]
			if( btn == 1 ) {this.month--; if( month == 0) { month=12; year--;}}
				// 다음달 : 월에서 1증가 [ 만일 월이 13이면 월=1 설정 연동 1 증가 ]
			else if( btn == 2 ) {this.month++; if(month == 13) {month=1; year++;}}
			else if( btn == 3 ) {
				System.out.println("연도를 입력주세요"); int syear = scanner.nextInt();
				System.out.println("월을 입력주세요"); int smonth = scanner.nextInt();
					if( syear < 1900 || syear >9999 ||  smonth < 1 || smonth >12 ) {
						System.out.println("경고 : 지원하지 않는 날짜 입니다.");
					}else {year = syear; month = smonth;}
			}
			else if( btn == 4 ) {inList();}
		} // while end
	} // run end
	void inList() {
		System.out.println("추가할 일정(날짜)"); String plan_date = scanner.next();
		System.out.println("추가할 일정(메모)"); String plan_memo = scanner.next();
		
		boolean result =
				cdao.inList(plan_date, plan_memo);
		if( result ) {System.out.println("일정 등록 완료");}
		else {System.out.println("일정 등록 실패");}
	}

	/*
	void 일정출력() {
		System.out.println("\n----- 일정확인 -----");
		System.out.println("번호\t날짜\t\t메모");
		HashMap<Integer, ArrayList<String> > map
			= CalDAO.getInstance().일정출력();
		
		for( Integer key : map.keySet() ) {
			System.out.println(key + "\t");
			for( String s : map.get(key)) {
				System.out.println(s + "\t");
			}
			System.out.println();
			
		}
	}
	*/
}

















