package java1.ch4배열;

import java.util.Random;
import java.util.Scanner;

public class Ex3_틱택토게임 {
	public static void main(String[] args) {
		// * String(문자) 9개 를 저장할수 있는 배열 선언과 초기값[처음값]
		String 승리자= "c";
		String[ ] 게임판 = { "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]" };
		Scanner scanner = new Scanner(System.in);
		
		while (true) { // 무한루프 [ 종료조건 : 승리판단 있을경우 ] // while 1 
			
			// 1. 게임판 출력 - 배열내 모든 데이터 출력 
			for( int i = 0 ; i<게임판.length ; i++ ) { // i는 0부터 마지막인덱스( 배열의길이-1 ) 까지 1씩 증가
				System.out.print( 게임판[i] );
				// 1-2 3줄[ 인덱스 : 2 , 5 , 8 ] 마다 줄바꿈
				if( i == 2 || i == 5 || i == 8 ) { System.out.println(); }
				// if( i == 2 || i == 5 || i == 8 ) ---> if( i % 3 == 2 )
			} // for end 
			
			// 2. 사용자 에게 위치 입력받기 
			while( true ) { // 무한루프 [ 종료조건 : 알을 두었을때 종료 break ] // while 2
				System.out.print("안내) 위치 선택 : "); int 위치 = scanner.nextInt();
				if( 위치 < 0 || 위치 > 8 ) { System.out.println("안내) 선택할수 없는 번호입니다.");}
				// 해당 위치에 알이 없으면 해당 위치에 알두기 
				if( 게임판[위치].equals("[ ]") ) {  게임판[위치] = "[O]"; break; } // 알을 두면 무한루프 종료
				else { System.out.println("안내) 이미 알이 존재하는 위치 입니다. "); }
			} // while 2 end 
			int 공백 = 0;
			for( int i = 0; i<9; i++) { if(!게임판[i].equals("[ ]") ) 공백++;}
			if( 공백== 9) {	System.out.println("무승부입니다.");break;}
			
			// 3. 컴퓨터 에게 위치 난수 생성
			while( true ) { // while 2
				Random random = new Random(); // 랜덤 객체 생성 
				int 위치 = random.nextInt(9); // 0~8 난수 생성 
				if( 게임판[위치].equals("[ ]")){ 게임판[위치] = "[X]"; break; } // 알을 두면 무한루프 종료
			} // while 2 end 
			
			
			/*--------------------------------*/
			
			// 4. 승리진단[ 과제 ]
				// 1. 가로로 이기는 수 [ 0 1 2, 3 4 5, 6 7 8 ]
				for( int i = 0; i<=6; i+=3) {
				// i는 0부터 6까지 3씩 증가반복
					if( !게임판[i].equals("[ ]") && 게임판[i]==게임판[i+1]&& 게임판[i+1]==게임판[i+2]){
					승리자 = "i";
					break;
					}	
				}
				// 2. 세로로 이기는 수 [ 0 3 6 , 1 4 7 , 2 5 8
				for( int i = 0; i < 3; i++) {
					if((!게임판[i].equals("[ ]")) && 게임판[i]==(게임판[i+3]) && 게임판[i+3]==(게임판[i+6]) ) {
						승리자 = "i";
						break;
					}
				}
				// 3. 대각선으로 이기는 수 [ 0 4 8]
				if((!게임판[0].equals("[ ]")) && 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8]) ) {
					승리자 = "i";
					break;
				}
				// 4. 대각선으로 이기는 수 [ 2 4 6]
				if((!게임판[2].equals("[ ]")) && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6]) ) {
					승리자 = "i";
					break;
				}
				
				for( int i = 0; i<=6; i+=3) {
					// i는 0부터 6까지 3씩 증가반복
						if( !게임판[i].equals("[ ]") && 게임판[i]==게임판[i+1]&& 게임판[i+1]==게임판[i+2]){
						승리자 = "y";
						break;
						}	
					}
					// 2. 세로로 이기는 수 [ 0 3 6 , 1 4 7 , 2 5 8
					for( int i = 0; i < 3; i++) {
						if((!게임판[i].equals("[ ]")) && 게임판[i]==(게임판[i+3]) && 게임판[i+3]==(게임판[i+6]) ) {
							승리자 = "y";
							break;
						}
					}
					// 3. 대각선으로 이기는 수 [ 0 4 8]
					if((!게임판[0].equals("[ ]")) && 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8]) ) {
						승리자 = "y";
						break;
					}
					// 4. 대각선으로 이기는 수 [ 2 4 6]
					if((!게임판[2].equals("[ ]")) && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6]) ) {
						승리자 = "y";
						break;
					}
					
				
				
		/*----------------------------------------*/		
				
				
				if(승리자=="i"){System.out.println("나");}
				else if (승리자=="y"){System.out.println("컴");}
				
				
		}// while end	
	}// main end
}// class end

/*
	틱택토 게임
		[ 조건 ]
		1. 게임판 9칸 사용 -> 배열 [0 ~ 8]
			1. String 배열		클래스는 비교연산자 불가능 -----> 
			== : 그래서 문자열.equlas(문자열)
			!= : !문자열1.equlas(문자열2)
		2. 사용자[O] 가 알을 두고자 하는 위치 [ 인덱스 ] 입력
			1. 선택된 위치가 이미 다른 알이 존재하면 재입력 [ 중복제거 ]
		3. 컴퓨터[X] 가 난수생성 [0 ~ 8]
			1. 선택된 위치가 이미 다른 알이 존재하면 재생성 [ 중복제거 ]
		4. 승리자 판단	[ 1.가로로 이기는 수 2. 세로로 이기는 수 3. 대각선으로 이기는 수 4. 무승부 ]
			
		[ 출력 ]
			1. 게임판 출력 예시
			[ ] [ ] [ ] 
			[ ] [ ] [ ] 
			[ ] [ ] [ ]






*/