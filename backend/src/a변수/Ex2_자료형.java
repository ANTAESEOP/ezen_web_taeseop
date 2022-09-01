package a변수;

// 1. 모든 코드는 클래스 안에서 작성
public class Ex2_자료형 { // class start
	// 2. 실행할 코드는 main 메소드 안에서 작성
	public static void main(String[] args) { // main start
		
		// p.61
		// 정수 타입 [ 10진수 ]
		// 1. byte +-128정도
		byte 바이트변수1 = -128; System.out.println("바이트변수1 : " + 바이트변수1 );
		byte 바이트변수2 = 127; System.out.println("바이트변수2 : " + 바이트변수2 );
			// byte 바이트변수3 = 128; // 오류 발생 : 저장 범위 초과
		
		// 2. char [ 한글자 ] : 유니코드
			// 문자[1개] 입력시 : ' ' 작은 따음표
			// 문자열[여러개] 입력시 : " " 큰 따음표
		char 문자변수1 = 65; 		System.out.println("문자변수1 : " + 문자변수1);
		char 문자변수2 = 'A';		System.out.println("문자변수2 : " + 문자변수2); // char 문자 표현 ㄱㄴ
			int 문자변수3 = 'A';	System.out.println("문자변수3 : " + 문자변수3); // int는 문자 표현 ㄴ
		char 문자변수4 = '가'; 	System.out.println("문자변수4 : " + 문자변수4);
			int 문자변수5 = '가'; 	System.out.println("문자변수5 : " + 문자변수5);
		
		// 3. short [ 10진수 ] +-3만정도
		short 쇼트변수1 = 30000;	System.out.println("쇼트변수1 : " + 쇼트변수1);
			//short 쇼트변수2 = 40000; // 오류 발생 : 저장 범위 초과
		
		// 4. int [ * 정수 기본 자료형 ] : +-20억정도
		int 인트변수1 = 1000000000;	System.out.println("인트변수1 : " + 인트변수1);
			// int 인트변수2 = 3000000000; // 오류발생 : 저장 범위 초과
		// 5. long[ - 입력 숫자 뒤에 L ] : int 이상
		long 롱변수1 = 1000000000;	System.out.println("롱변수1 : " + 롱변수1);
		long 롱변수2 = 3000000000L;	System.out.println("롱변수2 : " + 롱변수2);	
		
		// 실수 타입
		// 1. float		[ 입력 숫자 뒤에 F ]	[ 소수점 7자리 ]
		// 2. double	[ * 실수 기본 자료형 ] [ 소수점 15자리 ]
		float 실수1 = 3.14F; System.out.println("실수 1 : " + 실수1);
		double 실수2 = 3.14; System.out.println("실수 2: " + 실수2);
		
		double 실수3 = 0.12837891236789231; // [ 소수점 17자리 까지만 저장 ]
		System.out.println("실수 3: " + 실수3);
		
		float 실수4 = 0.129031829378891237F; // [ 소수점 8자리 까지만 저장 ]
		System.out.println("실수 : " + 실수4 );
		
		// 논리 타입
			// 1. boolean : true 혹은 flase
		boolean 논리변수 = true; System.out.println("논리변수 : " + 논리변수);
		// boolean 논리변수 2; = 10;	// 오류발생 [ 범위 초과 ]
		
		// 1. int : 10진수 정수를 저장하는 자료형[상자]
		int var1 = 0b1011; // 2진수 [ 0b : 2진수 작성 가능 ]
		System.out.println("2진수[ 1011 --int(10진수)---> 11 ]: " + var1 );
		int var2 = 0206; // 8진수 [ 0 : 8진수 작성 가능 ]
		System.out.println("8진수[ 206 --int(10진수)---> 134 ]: " + var2 );
		int var3 = 365; // 10진수
		System.out.println("10진수[ 365 --int(10진수)---> 365 ]: " + var3 );
		int var4 = 0xb3; // 16진수 [ 0x : 16진수 작성 가능 ]
		System.out.println("16진수[ b3 --int(10진수)---> 179 ]: " + var4 );
		
		// 2. byte :
	} // main end
		
} // class end

/*
 	진수
 		* 2진수를 다른 진수로 변환해서 다양한 표현 단위 사용할 수 있다. ---> 많은 단위를 표현가능
 		2진수	0,1 [ 기계어 , 이진 코드 ] 문제: 표현단위적다 ---> 8진수,10진수,16진수
 		8진수	0,1,2,3,4,5,6,7
 		10진수	0,1,2,3,4,5,6,7,8,9 [ 사람이 사용하는 일상 숫자 단위 ]
 		16진수	0,1,2,3,4,5,6,7,8,9,a(10),b(11),c(12),d(13),e(14),f(15)
 				10 ---> 16
 */
