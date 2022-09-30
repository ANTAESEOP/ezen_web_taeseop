package ch10예외처리;

public class Ex3_예외던지기 {

	public static void main(String[] args) {
		try {findClass();}
		catch (Exception e) { System.out.println("함수에서 온 예외"); }
	}
								// 예외던지기 ( throws ) : 해당 메소드를 호출했던 곳으로
	public static void findClass() throws ClassNotFoundException {
		
		Class clazz = Class.forName("java.lang.String2"); // -- 예외 발생 시점
	}
}
