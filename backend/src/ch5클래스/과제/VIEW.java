package ch5클래스.과제;

import java.util.ArrayList;
import java.util.Scanner;

public class VIEW {
	Scanner scanner = new Scanner(System.in);
	CONTROL con = new CONTROL();
	
	public static void main(String[] args) {
		VIEW cashview = new VIEW();
		cashview.cashInput();
	}
	
	void cashInput() {
		while(true) {
			read();
			System.out.println("1.추가 2.삭제 3.수정 4.검색 5.통계");
			try {
				int ch = scanner.nextInt();
				if( ch == 1) { cashcreate(); }
				else if (ch == 2) {delete();}
				else if (ch == 3) {cashedit();}
				else {System.out.println("알수없는버노");}
			}catch (Exception e) {
				System.out.println("실패" + e);
				scanner = new Scanner(System.in);
			} // catch end
		} // while end
	} // cash end	
	
	void cashcreate() {
		System.out.print("날짜"); scanner.nextLine(); String cash_date = scanner.nextLine();
		System.out.print("가격"); int cash_price = scanner.nextInt();
		System.out.print("내용"); scanner.nextLine(); String cash_content = scanner.nextLine();
		boolean result = con.cashInput(cash_date, cash_price, cash_content);
		
		if( result ) {System.out.println("가계부 추가 했슴다.");}
		else {System.out.println("가계부 추가 실패해씀다.");
		}
	}
	
	void read() {
		ArrayList<CashDTO> list = con.read();
		System.out.println("번호\t날짜\t금액\t내용");
		for( CashDTO dto : list ) {
			System.out.print(dto.getPno() +"\t");
			System.out.print(dto.getCash_date() +"\t");
			System.out.print(dto.getCash_price() +"\t");
			System.out.print(dto.getCash_content() +"\n");
		}
	}
	
	void delete() {
		System.out.println(" 삭제할 번호 : "); 
		int pno = scanner.nextInt();
		boolean result = con.delete( pno );
		if( result ) {System.out.println("삭제성공");}
		else {System.out.println("삭제실패");}
	}

	void cashedit() {
		System.out.println("수정할 번호"); int pno = scanner.nextInt();
		System.out.println("수정할 날짜"); scanner.nextLine(); String cash_date = scanner.nextLine();
		System.out.println("수정할 가격"); int cash_price = scanner.nextInt();
		System.out.println("수정할 내용"); scanner.nextLine(); String cash_content = scanner.nextLine();
		boolean result = con.cashInput(cash_date, cash_price, cash_content);
		
		if( result ) {System.out.println("가계부 수정 했슴다.");}
		else {System.out.println("가계부 수정 실패해씀다.");
		}
	}

} // view end