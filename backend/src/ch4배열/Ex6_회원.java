package ch4배열;

import java.lang.reflect.Member;
import java.util.Scanner;

public class Ex6_회원 { // class start

	public static void main(String[] args) { // main start
		
		
		// 0. 메모리
		String[][] mumberlist = new String[100][4]; // 문자열 400개를 저장 할 수 있
		Scanner scanner = new Scanner(System.in);	// 입력객체
		
		// 1. 무한루프 [ 프로그램 실행 ]
		while ( true ) { // while start [ 종료조건 : X(없다) ]
			System.out.println("================== 회원제 페이지 ==================");
			System.out.println("메뉴 : 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기");
			System.out.println("===============================================");
			System.out.print("선택 : "); int btn = scanner.nextInt();
			
			if( btn == 1) // 1 입력했을때
			{
						
				// 1. 아이디 / 비밀번호 입력받는다.
				System.out.println("================== 로그인 페이지 ==================");
				System.out.println("아이디 : "); 	String id = scanner.next();
				System.out.println("비밀번호 : "); String password = scanner.next();
				System.out.println("===============================================");
				// 2. 배열내 모든 항목[인덱스]와 비교해서 입력한 아이디와 비밀번호 있는지 확인
				int logincheck = 0 ; // 로그인 처리에 대한 상태를 저장하는 변수
				for( int i = 0; i<mumberlist.length ; i++) {
					if( mumberlist[i][0] != null ) { 
						// 해당 인덱스가 null이 아니면서
						if( mumberlist[i][0].equals(id) ) { 
							// 해당 인덱스의 아이디가 입력받은 id와 같으면서
							logincheck = 2;
							if( mumberlist[i][i].equals(password) ) { 
								// 해당 인덱스의 비밀번호가 입력받은 password 와 같으면
								System.out.println("안내) 로그인 성공 !!");
								logincheck = 1; // 로그인 성공[ 아이디와 비밀번호가 모두 맞았을때 ]
								
									// (추후코드) 로그인메뉴 //
									while(true) { // while start
										System.out.println("회원 메뉴 : 1. 회원탈퇴 2. 로그아웃");
										int btn2 = scanner.nextInt();
										if (btn2 == 1 ) {
											// --------------------------------------------- //
											// i = 로그인 성공한 인덱스 = 로그인한 회원의 인덱스
											mumberlist[i][0] = null;	mumberlist[i][1] = null;
											mumberlist[i][2] = null;	mumberlist[i][3] = null;
												// null 뒤로 한칸씩 당기기
												for( int j = i ; j<mumberlist.length; j++) {
													mumberlist[j][0] = mumberlist[j+1][0];
													mumberlist[j][1] = mumberlist[j+1][1];
													mumberlist[j][2] = mumberlist[j+1][2];
													mumberlist[j][3] = mumberlist[j+1][3];
													// 다음 인덱스의 null 이면 [ 회원이 없다는 뜻으로 ]
													if( mumberlist[j+1][0] == null ) break;
												}
											// --------------------------------------------- //
											System.out.println("안내) 회원탈되가 되었습니다.");
											break;
										}
										else if (btn2 == 2 ) {break;}
									} // while end
								
								
								break;
							}// if end
						}// if end
					}// if end
				} // for end
				// 3. 있으면 로그인 성공 없으면 로그인 실패
				if( logincheck == 0) { System.out.println("안내) 동일한 아이디가 없습니다."); }
				else if ( logincheck == 2) {System.out.println("안내) 비밀번호가 일치하지 않습니다.");}
				else if ( logincheck == 1) {System.out.println("안내) 로그아웃 되었습니다.");}

			}
			else if( btn == 2) // 2 입력했을때
			{
				System.out.println("================== 회원가입 페이지 ==================");
				// 1. 회원정보를 4개의 변수로 입력받기  [ 바로 배열에 대입 X ]
				System.out.println("아이디 : "); String id = scanner.next();
				// 2. 아이디 중복체크 : 입력받은 id가 배열내 존재하면 회원가입실패
				boolean idcheck = true; // 아이디 중복 여부 [ true : 중복없다 , false : 중복있다.
				for( int row = 0; row<mumberlist.length; row++ ) {
					if( mumberlist[row][0] !=null && mumberlist[row][0].equals(id) ) { // 입력받은 데이터와 배열내 id 같다 !! [ 중복 찾음 ]
						System.out.println("안내) 이미 사용중인 아이디 입니다.");
						idcheck = false; break;
					} // if end
				} // for end
				
				// 3. 아이디 중복 흐름 제어
				if( idcheck ) {
					
				}
				
				System.out.println("비밀번호 : "); String password = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				// 3. 입력받은 배열에 저장한다. [ 배열호출 : 배열명[행인덱스][열인덱스] ]
					// 1. 배열내 빈 행 찾는다.
					for( int row = 0; row<mumberlist.length; row++ ) {
						if( mumberlist[row][0] == null ) {
							// row번째 아이디가 null이면 = 회원이 없다 !!
							mumberlist[row][0] = id; mumberlist[row][1] = password;
							mumberlist[row][2] = name; mumberlist[row][3] = phone; 
							System.out.println(" 회원가입 성공 ");
							// 2-3 : 저장했으면 반복문 종료 [ 끝내기 ]
							break;
						}// if end
						if( row == 99 ) { System.out.println("안내) 최대 회원수가 찼습니다. [회원가입불가능 : 관리자에게문의 ");}
					} // for end
				} // if 3 end
			else if( btn == 3) // 3 입력했을때
			{
				System.out.println("================== 아이디찾기 페이지 ==================");
				// 1. 이름 , 전화번호 입력받기
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				// 2. 배열내 모든 항목 비교해서 동일한 이름 , 전화번호
				for( int i = 0; i<mumberlist.length; i++) { // 모든 항목 출력
					if( mumberlist[i][0] != null && 		// null 이 아니면서
							mumberlist[i][2].equals(name) &&	// 이름이 같고
								mumberlist[i][3].equals(phone) ) {	// 전화번호가 같으면
						System.out.println("회원님의 아이디 : " + mumberlist[i][0]);
						break;
					} // if end
					if( i == mumberlist.length-1 ) { // i가 마지막인덱스와 같으면 [ 모두 검사했는데 조건 못찾음 ]
						System.out.println("안내) 동일한 회원정보가 없습니다.");
					}
				} // for end
				// 3. 존재하면 해당 아이디 출력 아니면 미출력

				
			}
			else if( btn == 4) // 4 입력했을때
			{
				System.out.println("================== 비밀번호찾기 페이지 ==================");
				// 1. 아이디 , 전화번호 입력받기
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				// 2. 배열내 모든 항목 비교해서 동일한 아이디 , 전화번호
				for( int i = 0 ; i<mumberlist.length; i++) { // 모든 항목 출력
					if( mumberlist[i][0] != null &&			// null 이 아니면서
							mumberlist[i][0].equals(id) &&	// 아이디가 같고
								mumberlist[i][3].equals(phone) ) { // 전화번호가 같으면
						System.out.println("회원님의 비밀번호 : " + mumberlist[i][1]);
						break;
					} // if end
					if( i == mumberlist.length-1) { // i 가 마지막 인덱스와 같으면 [ 모두 검사했는데 조건 못찾으면]
						System.out.println("안내) 동일한 회원정보가 업습니다.");
					}
				} // for end
				// 3. 존재하면 해당 비밀번호 출력 아니면 미출력
			} 	
			else {System.out.println("알 수 없는 번호입니다.");} // 그외 입력했을때
		} // while end
		
	} // main end
} // class end

/*
 	회원제 프로그램 구현
 		[조건]
 			1. 2차원 배열
 		[기능]
 			1. 회원가입 기능
 				1. 아이디 비밀번호 이름 전화번호 입력받아 등록
 				2. 배열내 빈 공간의 인덱스를 찾아서 해당 인덱스에 회원정보 넣기
 					String = null
 					int = 0		double = 0.0	 boolean =
 				3. 아이디 중복체크
 				4. 최대 회원 100명
 					* 1명 4개 변수 -> 400변수 -> 2차원 배열 -> [100][4]
 					* 행 당 1명
 					* 0열 : 아이디 / 1열 : 비밀번호 / 2열 : 이름 / 3열 : 전화번호 /
 			2. 로그인 기능
 				아이디 비밀번호 가 동일하면 로그인 성공
 			3. 아이디찾기 기능
 				이름 전화번호 가 동일하면 아이디 알려주기
 			4. 비밀번호찾기 기능
 				아이디 전화번호 가 동일하면 비밀번호 알려주기
 		[출력]
 			1. 메뉴 : 1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
*/
