package SOLO;

import java.util.Scanner;

public class solo_project2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// 입력 객체
		
/*------------------------------------------------------------------------------------------------*/
		String korea = new String("이상한 변호사 우영우"); 				// 한국 드라마 정답
		String movie_kr = new String("헤어질결심");						// 한국 영화 정답
		String usa = new String("브레이킹 베드");						// 미국 드라마 정답
		String movie_us = new String("어벤저스");						// 미국 영화 정답
		String japan = new String("도망치는건 부끄럽지만 도움이 된다");		// 일본 드라마 정답
		String movie_japan = new String("귀멸의 칼날");					// 일본 영화 정답
		String uk = new String("드라큘라");							// 영국 드라마 정답
		String movie_uk = new String("해리포터");						// 영국 영화 정답
		int 점수 = 0;		
/*------------------------------------------------------------------------------------------------*/
			System.out.println("   I===================================I");
			System.out.println("   I------[ 드라마 제목 맞추기 프로그램 ]------I");
			System.out.println("   I===================================I" + "\n");
			System.out.println("            시작! ( START = 1 )");
			System.out.print("                     : "); int drama_select = scanner.nextInt();
/*-------------------------------------한국 드라마 출력 함수------------------------------------------------*/
			if( drama_select == 1) { // 1번을 선택하면 시작
				System.out.println("\n" + "ㅇㅅㅎ ㅂㅎㅅ ㅇㅇㅇ" + "\n"); // 한국 드라마 초성 출력
					System.out.println("한국 드라마의 제목을 맞춰주세요");
						System.out.println("첫 번째 문제입니다.");scanner.nextLine();
							System.out.print("한국 드라마 이름 : OOO OOO OOO " + "\n"); String drama_kr = scanner.nextLine();
				if( korea.equals(drama_kr)) { 점수++; // 정답일시 점수 증가 와 동시에 다음 문제로
						System.out.println("\n" + "정답! 다음문제로 넘어갑니다." + "\n" + 점수 + "점"); 
					}else { 점수--;	// 오답일시 점수 감소 와 동시에 다음문제로
						System.out.println("\n" + "오답. 다음문제로 넘어갑니다." + "\n" + 점수 + "점"); 
				}	
			}
/*---------------------------------미국 드라마 출력 함수-------------------------------------------------*/		
					System.out.println("\n" + "ㅂㄹㅇㅋ ㅂㄷ" + "\n");
						System.out.println("미국 드라마의 제목을 맞춰주세요");
							System.out.println("두 번째 문제입니다.");scanner.nextLine();
								System.out.print("미국 드라마 이름 : OOOO OO + " + "\n"); String drama_usa = scanner.nextLine();
			if( usa.equals(drama_usa)) { 점수++;
					System.out.println("\n" + "정답! 다음문제로 넘어갑니다." + "\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음문제로 넘어갑니다." +  "\n" + 점수 + "점"); 
			}
			
/*------------------------------------일본 드라마 출력 함수-------------------------------------------------*/
					System.out.println("\n" + "ㄷㅁㅊㄴㄱ ㅂㄲㄹㅈㅁ ㄷㅇㅇ ㄷㄷ" + "\n"); 
						System.out.println("일본 드라마의 제목을 맞춰주세요");
							System.out.println("세 번째 문제입니다.");scanner.nextLine();
								System.out.print("일본 드라마 이름 : OOOOO OOOOO OOO OO " + "\n") ;String drama_japan = scanner.nextLine();
			if( japan.equals(drama_japan)) { 점수++;
					System.out.println("\n" + "정답! 다음문제로 넘어갑니다." +  "\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음문제로 넘어갑니다." +  "\n" + 점수 + "점"); 
			}
/*-------------------------------------영국 드라마 출력 함수------------------------------------------------*/
					System.out.println("\n" + "ㄷㄹㅋㄹ" + "\n");
						System.out.println("영국 드라마의 제목을 맞춰주세요");
							System.out.println("마지막 드라마 문제입니다.");scanner.nextLine();
								System.out.print("영국 드라마 이름 : OOOO " + "\n") ; String drama_uk = scanner.nextLine();
			if( uk.equals(drama_uk)) { 점수++;
					System.out.println("\n" + "정답! 다음은 영화 문제 입니다." + "\n" +"\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음은 영화 문제입니다." + "\n" +"\n" + 점수 + "점");
			}
/*------------------------------------한국 영화 출력 함수----------------------------------------------*/
					System.out.println("\n" + "ㅎㅇㅈㄱㅅ" + "\n");
						System.out.println("한국 영화의 제목을 맞춰주세요");
							System.out.println("첫 번째 문제입니다.");scanner.nextLine();
								System.out.print("한국 영화 이름 : OOOOO " + "\n") ; String movie_korea = scanner.nextLine();
			if( movie_kr.equals(movie_korea)) { 점수++;
					System.out.println("\n" + "정답! 다음문제로 넘어갑니다" + "\n" +"\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음문제로 넘어갑니다." + "\n" +"\n" + 점수 + "점");
		}
/*-----------------------------------미국 영화 출력 함수---------------------------------------------------------*/
					System.out.println("\n" + "ㅇㅂㅈㅅ" + "\n");
						System.out.println("미국 영화의 제목을 맞춰주세요");
							System.out.println("두 번째 문제입니다.");scanner.nextLine();
								System.out.print("미국 영화 이름 : OOOO " + "\n") ; String movie_usa = scanner.nextLine();
			if( movie_us.equals(movie_usa)) { 점수++;
					System.out.println("\n" + "정답! 다음문제로 넘어갑니다." + "\n" +"\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음문제로 넘어갑니다.." + "\n" +"\n" + 점수 + "점");
	}	
/*------------------------------------영국 영화 출력 함수-------------------------------------------------*/
				System.out.println("\n" + "ㅎㄹㅍㅌ" + "\n");
					System.out.println("영국 영화의 제목을 맞춰주세요");
						System.out.println("세 번째 문제입니다.");scanner.nextLine();
							System.out.print("영국 영화 이름 : OOOO " + "\n") ; String movie_unk = scanner.nextLine();
			if( movie_uk.equals(movie_unk)) { 점수++;
					System.out.println("\n" + "정답! 다음문제로 넘어갑니다.." + "\n" +"\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 다음문제로 넘어갑니다." + "\n" +"\n" + 점수 + "점");
}
/*------------------------------------일본 영화 출력 함수--------------------------------------------------*/
				System.out.println("\n" + "ㄱㅁㅇ ㅋㄴ" + "\n");
					System.out.println("일본 영화의 제목을 맞춰주세요");
						System.out.println("마지막 영화 문제입니다.");scanner.nextLine();
							System.out.print("일본 영화 이름 : OOO OO " + "\n") ; String movie_jp = scanner.nextLine();
			if( movie_japan.equals(movie_jp)) { 점수++;
					System.out.println("\n" + "정답! 점수는?." + "\n" +"\n" + 점수 + "점"); 
				}else { 점수--;
					System.out.println("\n" + "오답. 점수는?." + "\n" +"\n" + 점수 + "점 !!" );
}
/*-----------------------------------등급 출력 함수-------------------------------------------------------*/
			if( 점수 >= 8 && 점수 >= 7) { // 점수가 8점 이거나 7점 이면
				System.out.println("A등급" + "\n" + "＼(^o^)／");} // A등급 출력
				else if( 점수 >= 6 && 점수 >= 5) {  // 6점 이거나 5점 이면
					System.out.println("B등급" + "\n" + "(^_^.);");} // B등급 출력
					else if( 점수 >= 4 && 점수 >= 3) { // 4점 이거나 3점 이면
						System.out.println("C등급" + "\n" + "(￣ー￣)");} // C등급 출력
						else if( 점수 >= 2 && 점수>= 1) { // 2점 이거나 1점 이면
							System.out.println("제시험" + "\n" + "(TーT)");} // 재시험 출력
								else{System.err.println("탈락" + "\n");} // 점수가 0점 미만 이면 탈락
/*----------------------------------------------------------------------------------------------*/
			
	} // main end	
} // class end
	

