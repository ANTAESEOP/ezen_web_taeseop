package java1;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		
		String[][] boardlist = new String[100][4];
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(true) {
			
			System.out.println("-------------커뮤니티------------");
			System.out.println("번호	작성자	제목");
			for(int i = 0 ; i<boardlist.length ; i++) {
				if(boardlist[i][0] != null) {						
					System.out.println(i + "\t" + boardlist[i][2] + "\t" + boardlist[i][0]);
				}
			}
			
				while(true) {
					System.out.println("1.글쓰기  2.글보기  선택: ");
					int btn = scanner.nextInt(); // break로 빠져나오면 btn을 입력한다.
				if ( btn == 1 ) {
					for(int row = 0 ; row<boardlist.length ; row++) {
						// 비어 있을때 배열을 입력받는다.
						if(boardlist[row][0] == null) {
							System.out.print("title : ");
							String title = scanner.next();
							System.out.print("content : ");
							String content = scanner.next();
							System.out.print("writer : ");
							String writer = scanner.next();
							System.out.print("password : ");
							String password = scanner.next();
							
							boardlist[row][0] = title;
							boardlist[row][1] = content; 
							boardlist[row][2] = writer;
							boardlist[row][3] = password;
							
							System.out.println("-------------커뮤니티------------");
							System.out.println("번호	작성자	제목");
							
								// 총 배열의 값들을 출력한다.
								if(boardlist[row][0] != null) {						
									for(int i = 0 ; i<=row ; i++) {						
										System.out.println(i + "\t" + boardlist[i][2] + "\t" + boardlist[i][0]);
									}
								}
							break; // 출력하고 빠져나간다.
						}
					}
				} else if ( btn == 2 ) { // btn이 2라면 글보기를 선택한다.
					for(int row = 0 ; row<boardlist.length ; row++) { // 총 배열의 길이까지 반복한다.
						if(boardlist[row][0] == null) { // 각 배열의 값이 비어있다면
							System.out.println("---------------게시물 상세페이지--------------");
							
							System.out.println("게시물 번호(인덱스) 선택 : ");
							int boardpick = scanner.nextInt();
							
							System.out.print("작성자 : " + boardlist[boardpick][2] + "\t\t");
							System.out.println("제목 : " + boardlist[boardpick][0]);
							System.out.println("내용 : " + boardlist[boardpick][1]);
									
							System.out.println("1.목록보기(뒤로가기) 2.글삭제 3.글수정 선택 : ");
							int btn2 = scanner.nextInt(); // btn2를 받는다.
							if( btn2 == 1 ) { // btn2가 1이라면 뒤로가기
								break;
							}
							
							else if( btn2 == 2 ) {	// 삭제
								
								System.out.println("알림)) 현 게시물 비밀번호 : ");
								String passwordcheck = scanner.next();
								if (boardlist[boardpick][3].equals(passwordcheck)) {										
									boardlist[boardpick][0] = null;
									boardlist[boardpick][1] = null;
									boardlist[boardpick][2] = null;
									boardlist[boardpick][3] = null;
								
									for(int i = boardpick ; i<boardlist.length-1 ; i++) { // 최대 인덱스 넘으면 에러나서 -1 해주었음
										boardlist[i][0] = boardlist[i+1][0];
										boardlist[i][1] = boardlist[i+1][1];
										boardlist[i][2] = boardlist[i+1][2];
										boardlist[i][3] = boardlist[i+1][3];
											
										if( boardlist[i+1] == null ) break;
									}
								} else {
									System.out.println("잘못된 비밀번호 입니다.");
								}
										
									break; // 다음배열에 아이디 없으면 break
									
							} else if( btn2 == 3 ) {	// 수정
								System.out.println("알림)) 현 게시물 비밀번호 : ");
								String passwordcheck = scanner.next();
								
								if(boardlist[boardpick][3].equals(passwordcheck)) {
									System.out.print("수정할 제목 : ");
									String title2 = scanner.next();
									System.out.print("수정할 내용 : ");
									String content2 = scanner.next();
									
									boardlist[boardpick][0] = title2;
									boardlist[boardpick][1] = content2;
									System.out.println("알림)) 내용이 수정되었습니다.");
								} else {
									System.out.println("잘못된 비밀번호 입니다.");
								}
								break;
							}
							break;
						}
					}
					break;
				}
			}
		}
		
	}
}