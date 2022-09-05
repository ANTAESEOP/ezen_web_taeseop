package ch1변수;

public class Ex3_문자열 { // class start
	public static void main(String[] args) { // main start
		
		// p.64 String 타입 [ String 클래스 ]
			//	char 문자 = "자바"; // 오류발생 : char 문자 한개만 저장할 수 있다.
		String 문자열 = "자바";
		
		// p.65
		String name = "홍길동";	System.out.println(name);
		String job = "프로그래머"; System.out.println(job);
		
		// p.66
		System.out.println("안녕하세요");	// printin : 출력 후 줄바꿈처리 O
		System.out.println("자바입니다.");	// 출력 후 줄바꿈처리 X
		System.out.println("하하하하하.");
		
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄\\여름\\가을\\겨울");
		
		System.out.println("\\\t/\\");
		System.out.println(" )     ( ')");
		System.out.println("(     /  )");
		System.out.println(" \\   (__)|");
		
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		System.out.println("\t[[ 출석부 ]]");
		System.out.println();
        /*  예제1 ) console 에 토끼모양 출력
			\    /\
			 )  ( ')
			(  /  )
			 \(__)|
		*/
		/*
		    예제2 ) 강아지 console 출력
			|\_/|
			|q p|   /}
			( 0 )"""\
			|"^"`    |
			||_/=\\__|
		 */
		/*
		    예제3 ) 출석부 출력
		    
		    	            [[ 출석부 ]]
			 --------------------------------------
			 이름			1교시	    2교시	    3교시
			 강호동		출석		결석		출석
			 유재석		출석		결석		출석
			 --------------------------------------
					
		 */
	} // main end
	
} // class end
/*
	문자 [ 한글자 ]		: char		:	'차'
	문자열[ 두글자 이상 ]	: String	: 	" 자바 입니다"
	
	- console 화면에 출력하는 함수
		print()		: 출력
		printin()	: 출력 하고 줄바꿈 [\n] 포함
		printf		: 형식문자 출력
		
	- 제어[이스케이프] 문자
		1. \n : 줄바꿈	2. \t : 들여쓰기[tab 5칸]
		3. \" : "출력
			"홍길동" ----> 홍길동
			"\"홍길동\"" ----> "홍길동"
*/