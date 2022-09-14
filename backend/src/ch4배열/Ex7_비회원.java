package ch4배열;

import java.util.Scanner;

public class Ex7_비회원 { // class start
		public static void main(String[] args) { // main start
			
			
			String[][] boardlist = new String [100][4]; // 문자열 100개를 저장
			Scanner scanner = new Scanner(System.in); // 입력객체
			
			
			while(true) {
				System.out.println("================ 커뮤니티 페이지 ================");
				System.out.println("번호	작성자	제목");
				for(int i = 0 ; i<boardlist.length ; i++) {
					if(boardlist[i][0] != null) {						
						System.out.println(i + "\t" + boardlist[i][2] + "\t" + boardlist[i][0]);
					}
				}
					while(true) {
						System.out.println("1.글쓰기  2.글보기  선택: ");
						int btn = scanner.nextInt();
					// 글쓰기
					if ( btn == 1 ) {
						for(int row = 0 ; row<boardlist.length ; row++) {
							if(boardlist[row][0] == null) {
								System.out.println("================ 글쓰기 페이지 ================");
								System.out.print("제목 : "); String title = scanner.next();
								System.out.print("내용 : "); String content = scanner.next();
								System.out.print("글작성자 : "); String writer = scanner.next();
								System.out.print("비밀번호 : "); String password = scanner.next();

								boardlist[row][0] = title;  boardlist[row][1] = content; 
								boardlist[row][2] = writer; boardlist[row][3] = password;
								
								System.out.println("================ 커뮤니티 페이지 ================");
								System.out.println("번호	작성자	제목");

									if(boardlist[row][0] != null) {						
										for(int i = 0 ; i<=row ; i++) {						
											System.out.println(i + "\t" + boardlist[i][2] + "\t" + boardlist[i][0]);
										} // for end
									} // if end
								break;
							} // if end
						} // for end
					} // if end	
					
					// 글보기
					else if (btn == 2) {
						System.out.println("게시물 번호 선택 : ");
						for(int row = 0 ; row<boardlist.length ; row++) {
								System.out.println("================ 글보기 페이지 ================");
								int selectboard = scanner.nextInt();
								System.out.println("작성자 : " + boardlist[selectboard][2]);
								System.out.println("제목 : " + boardlist[selectboard][0]);
								System.out.println("내용 : " + boardlist[selectboard][1]);
								System.out.println("1. 목록보기(뒤로가기) 2.글삭제 3.글수정 \n선택 : ");
								if(selectboard == 1) {
									break;
								
								}else if( selectboard == 2) { 
									System.out.println("비밀번호입력 : ");
									String pw = scanner.next();
									
									if(boardlist[selectboard][3].equals(pw));
										boardlist[selectboard][2] = null;
										boardlist[selectboard][0] = null;
										boardlist[selectboard][1] = null;
									}
						}
					}
					
					} // while 2 end
			} // while end
			
			} // main end
		} // class end


