package ch3조건반복문.copy;

import java.util.Scanner;

public class Ex7_별찍기 { // class start
	
	public static void main(String[] args) { // main start
		
		// 0. 입력객체 [ 1번 선언]
		Scanner scanner = new Scanner(System.in);
		
		// 1. 입력받은 수 만큼 * 출력
		System.out.print("문제1) 별의 수 : "); int s1 = scanner.nextInt();
		for( int i = 1 ; i <= s1; i++) { // i는 1부터 입력받은 수 까지 1씩 증가반복
			System.out.print("*");
		} // for end
System.out.println("\n--------------------------------------------");	
		// 2. 입력받은 수 만큼 * 출력 [ 3줄마다 줄바꿈 처리 ]
		System.out.print("문제2) 별의 수 : "); int s2 = scanner.nextInt();
		for( int i = 1 ; i<= s2; i++) {
			System.out.print("*"); if( i % 3 == 0 ) {System.out.println();}
		} // for end
System.out.println("\n--------------------------------------------");	
		// 3.입력받은 줄 만큼 * 출력
		System.out.print("문제3) 줄의 수 : "); int s3 = scanner.nextInt();
		for( int i = 0 ; i<= s3; i++) {
			for( int j = 1; j<= i; j++) {
				System.out.print("*"); 
			}
			System.out.println();
		}
System.out.println("\n--------------------------------------------");	
		//4.입력받은 줄 만큼 * 출력
		System.out.println("문제4) 줄의 수 : "); int s4 = scanner.nextInt();
		for( int i = 1 ; i<= s4; i++) {
			for( int j = 1; j<=s4-i+1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
System.out.println("\n--------------------------------------------");	
		// 5. 입력받은 줄 만큼 * 출력
		System.out.println("문제5) 줄의 수 : "); int s5 = scanner.nextInt();
		for( int i = 1 ; i<= s5; i++) {
			for( int b = 1; b<=s5-i; b++)
				System.out.print(" ");
			for (int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
System.out.println("\n--------------------------------------------");	
		// 6. 입력받은 줄 만큼 * 출력
		System.out.println("문제6) 줄의 수 : "); int s6 = scanner.nextInt();
		for( int i = 1 ; i<= s6; i++) {
			for( int b = 0; b<=s6-i; b++)
				System.out.print("*");
			for (int j = 0; j<=i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
System.out.println("\n--------------------------------------------");		
		// 7. 입력받은 줄 만큼 * 출력
		System.out.println("문제7) 줄의 수 : "); int s7 = scanner.nextInt();
		for( int i = 1 ; i<= s7; i++) {
				for( int b = 1; b<=s7-i; b++)
		System.out.print(" ");
				for (int j = 1; j<=i*2-1; j++) {
		System.out.print("*");
	}
	System.out.println();
}
System.out.println("\n--------------------------------------------");	
		//8. 입력받은 줄 만큼 * 출력
		int num = 0;
		System.out.println("문제8) 줄의 수 : "); int s8 = scanner.nextInt();
		for( int i = 1 ; i<= s8; i++) {
				for( int b = 1; b<=s8-i; b++)
		System.out.print(" ");
				for (int j = 1; j<=i*2-1; j++) {
		System.out.print(num);
	}
		System.out.println();
		num++;
}
System.out.println("\n--------------------------------------------");	
		// 9. 입력받은 줄 만큼 * 출력
		System.out.println("문제9) 줄의 수 : "); int s9 = scanner.nextInt();
		for( int i = 1 ; i<= s9-1; i++) {
					System.out.print(" ");
				for( int b = 1; b<=s9+i; b++)
		System.out.print("*");
				for (int j = 1; j<=i*2+1; j++) {
		System.out.println(" ");
	}
	System.out.println();
}

	} // main end
} // class end
