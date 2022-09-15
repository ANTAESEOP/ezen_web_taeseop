package SOLO;

import java.util.Scanner;

public class solo_project { // class end
	public static void main(String[] args) { // main start

		Scanner scanner = new Scanner(System.in);				// 입력 객체 선언
		String korea = new String("asd"); 						// 한국 드라마 정답 선언
		String usa = new String("asd");							// 미국 드라마 정답 선언
		String japan = new String("asd");						// 일본 드라마 정답 선언
		String uk = new String("asd");							// 영국 드라마 정답 선언
		int 점수 = 0;												// 점수를 저장할 빈 값 ++ or --
		
		while (true) {
		System.out.println("------[ 드라마 제목 맞추기 프로그램 ]------\n");
		System.out.println("시작하시겠습니까? ( YES = 1 / NO = 2 )");
		System.out.print(" 선택 : "); int drama_select = scanner.nextInt();
/*---------------------------------------------------------------------------*/
		if( drama_select == 1) {
			System.out.println("ㅇㅅㅎ ㅂㅎㅅ ㅇㅇㅇ");
			System.out.println("한국 드라마의 제목을 맞춰주세요");
			System.out.print("한국 드라마 이름 : "); String drama_kr = scanner.next();
			if( korea.equals(drama_kr)) { 점수++; 
				System.out.println("정답! 다음문제로 넘어갑니다." + 점수 + "점");
			}else { 점수 --;
				System.out.println("오답. 다음문제로 넘어갑니다." + 점수 + "점");
			}return;
		}
		
/*---------------------------------------------------------------------------*/
		else if (drama_select == 2) {
			System.out.println("ㅂㄹㅇㅋ ㅂㄷ");
			System.out.println("미국 드라마의 제목을 맞춰주세요"); String drama_usa = scanner.next();
			if( usa.equals(drama_usa)) { 점수++;
				System.out.println("정답! 다음문제로 넘어갑니다." + 점수 + "점");
			}else { 점수--;
				System.out.println("오답. 다음문제로 넘어갑니다." + 점수 + "점");
			}
		}
		
/*---------------------------------------------------------------------------*/
		
		else if (drama_select == 3) {
			System.out.println("ㄷㅁㅊㄴㄱ ㅂㄲㄹㅈㅁ ㄷㅇㅇ ㄷㄷ"); String drama_japan = scanner.next();
			System.out.println("일본 드라마의 제목을 맞춰주세요");
			if( japan.equals(drama_japan)) { 점수++;
				System.out.println("정답! 다음문제로 넘어갑니다." + 점수 + "점");
			}else { 점수--;
				System.out.println("오답. 다음문제로 넘어갑니다." + 점수 + "점");
			} 
		}
		
/*---------------------------------------------------------------------------*/
		else if (drama_select == 4) {
			System.out.println("ㄷㄹㅋㄹ");
			System.out.println("영국 드라마의 제목을 맞춰주세요"); String drama_uk = scanner.next();
			if( uk.equals(drama_uk)) { 점수++;
				System.out.println("정답! 점수는?" + 점수 + "점");
			}else { 점수--;
				System.out.println("오답. 점수는?" + 점수 + "점");}
		}
		else if ( drama_select == 5) { 
			if( 점수 >= 4 ) { // 점수가 4 점이면
				System.out.println("A등급");} // A등급 출력
			else if( 점수 == 3 ) {  // 점수가 3 점이면
					System.out.println("B등급");} // B등급 출력
			else if( 점수 == 2 ) { // 점수가 2점이면
						System.out.println("C등급");} // C등급 출력
			else if( 점수 == 1 ) { // 점수가 1점이면
							System.out.println("재시험");} // 재시험 출력
			else{System.out.println("탈락");} // 점수가 1점 ~ 4점도 아니면 탈락 출력 
		} break;
		
/*---------------------------------------------------------------------------*/
		
		
		

/*---------------------------------------------------------------------------*/
		}	// while end
	}	// main end
}	// class end
