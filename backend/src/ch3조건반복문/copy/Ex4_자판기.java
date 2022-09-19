package ch3조건반복문.copy;

import java.util.Scanner;

public class Ex4_자판기 { // class start
	public static void main(String[] args) { // main start
		
		// 0. 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 1. 공통변수 ( 제품3개 -> 3개, 장바구니제품 3개 - 3개 )
		int 콜라재고 = 10;	int 환타재고 = 10;	int 사이다재고 = 10;
		int 콜라구매수 = 0;	int 환타구매수 =0;		int 사이다구매수 = 0;
		
		while(true) { // 2. 무한루프 [ 무한반복 ]
			System.out.println("------[자판기]------");
			System.out.println("메뉴 : 1.콜라(300) 2.환타(400) 3.사이다(500) 4. 결제 ");
			System.out.print(" 선택 : "); int 메뉴선택 = scanner.nextInt();
			if( 메뉴선택 == 1 ) { // 1 을 입력했을때
				// 재고 있다/없다 [ 경우의수 2개 ]
				if( 콜라재고 > 0 ) {
					콜라재고--;	콜라구매수++;
					System.out.println("안내) 콜라를 장바구니에 담았습니다.");
				}else { // 재고 없다
					System.out.println("안내) 콜라재고가 없습니다. [죄송합니다]");
				}	
				
			}	
			else if( 메뉴선택 == 2 ) { // 2 을 입력했을때
				if( 환타재고 > 0 ) {
					환타재고--;	환타구매수++;
					System.out.println("안내) 환타를 장바구니에 담았습니다.");
				}else { // 재고 없다
					System.out.println("안내) 환타재고가 없습니다. [죄송합니다]");
				}	
			} 
			
			else if( 메뉴선택 == 3 ) { // 3 을 입력했을때
				if( 사이다재고 > 0 ) {
					사이다재고--;	사이다구매수++;
					System.out.println("안내) 사이다를 장바구니에 담았습니다.");
				}else { // 재고 없다
					System.out.println("안내) 사이다재고가 없습니다. [죄송합니다]");
				}	
			}
			
			else if( 메뉴선택 == 4 ) { // 4 을 입력했을때
				System.out.println("===================장바구니===================");
				System.out.println("제품명\t구매수\t가격");
				if( 콜라구매수 > 0 ) { System.out.println("콜라\t"+콜라구매수+"\t"+(콜라구매수*300)); }
				if( 환타구매수 > 0 ) { System.out.println("환타\t"+환타구매수+"\t"+(환타구매수*400)); }
				if( 사이다구매수 > 0 )  { System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*500)); }
				int 총결제금액 = (콜라구매수*300)+(환타구매수*400)+(사이다구매수*500);
				
				System.out.println("안내) 총 결제예정금액 : " + 총결제금액 + "원");
				System.out.println("안내) 결제하시겠습니까? [Y] [N] "); String 결제여부 = scanner.next();
				
				boolean 결제성공 = false; // 결제 성공 여부를 저장하는 변수 [스위치변수]
				
				if( 결제여부.equals("y") || 결제여부.equals("y") ) {
				System.out.println("안내) 결제금액을 투여 해주세요 ~ "); int 투입금액 = scanner.nextInt();
				if( 총결제금액 > 투입금액 ) { System.out.println("안내) 금액이 부족합니다. [결제취소]");}
				else { System.out.println("안내) 구매 완료 번호:0000 [잔돈 : "+(투입금액-총결제금액)+"원]");}
				}
				
				if( 결제성공 == false ) { // 결제성공 : 장바구니 0으로 초기화
					콜라재고+= 콜라구매수; 환타재고+= 환타구매수; 사이다구매수+= 사이다구매수;
				}
				콜라구매수 = 0 ; 환타구매수 = 0 ; 사이다구매수 = 0;
				
				// 결제취소 : 금액이 부족 하거나 , 결제여부가 N 이면 => 재고를 다시 채우기
			}
			else {System.err.println("안내) 선택할 수 없는 번호입니다[다시선택]");} // 그외 입력했을때
		}
		

	} // main end 
} // class end
/*
	자판기 프로그램
		[조건]
		1. 제품 : 콜라 , 환타 , 사이다
		2. 초기재고 : 각 10개
		3. 메뉴판에서 선택한 제품을 장바구니 담기
			1. 선택 제품의 재고가 0보다 작으면 '재고 없음' 출력 -> 나감
			2. 제품의 수를 1차감	->	장바구니제품의 1증가
			3. '장바구니에 담았습니다'
		4. 결제를 선택했을때 장바구니 현황 표시 결제[ 돈 입력 ]
		5. 결제예정인 금액보다 투입금액이 금액이 부족 결제취소 투입금액이 초과 잔돈 출력
		[화면구현]
		1. 메뉴판 : 1.콜라 2.환타 3.사이다 4.결제 (추가 5. 관리자)	[경우의수 : 5 ]
		
		[ 추가 할 기능 ]
		1. 제품 구매 수량 차감 메뉴
		2. 관리자메뉴 ( 비밀번호 : 1234 )
			재고추가




*/