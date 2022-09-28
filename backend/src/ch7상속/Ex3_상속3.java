package ch7상속;

public class Ex3_상속3 {
	
	public static void main(String[] args) {
		
		int r = 10;
		
		Calcuator calcuator = new  Calcuator();
		System.out.println("원면적 : " + calcuator.areaCircle(r));
		
		// 자식클래스가 객체 선언
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
		
		
	}
}
