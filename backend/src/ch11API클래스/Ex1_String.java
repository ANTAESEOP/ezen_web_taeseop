package ch11API클래스;

public class Ex1_String {

public static void main(String[] args) {
		
		// 기본자료형으로는 문자열 저장X -> String 클래스
		// byte -> 문자		byte[] -> 문자열
		// 키모드 입력 ---->
		
		byte b = 72;  // [숫자]
		char c = (char) b; System.out.println( c );
		// [ char 기능 : (java) 유니코드 변환 ] 72 -> H
		
		byte[] bytes = { 72 , 101 , 108 , 108 , 111 , 32 , 74 , 97 , 118 , 97};
		char[] chars = new char[10];
		
			for( int i = 0 ; i<bytes.length; i ++ ) { chars[i] = (char)bytes[i]; }
			for( int i = 0 ; i<chars.length; i ++ ) { chars[i] = (char)chars[i]; }

			
		String str1 = new String( bytes ); System.out.println("\n" + str1);	
		
		String str2 = new String( bytes , 6 , 4 ); System.out.println(str2);
	
		// 2. 
		byte[] bytes2 = new byte[100];
		System.out.print("입력");
		
		try{
			int readByteNo = System.in.read(bytes2);
				// readByteNo : 읽어온 바이트 수 저장하는 변수
			
			// for( int i = 0 ; i<= bytes2.length ; i++) {
			//	System.out.println(bytes2[i]);
			// }
			
			String str3 = new String( bytes2 , 0 , readByteNo-2 );
			System.out.println( str3 );
			System.out.println("---------------------");
		}
		catch (Exception e) { }

	}
}
	
