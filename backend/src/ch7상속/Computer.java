package ch7상속;

public class Computer extends Calcuator {
	@Override
	double areaCircle(double r) {
	System.out.println("Computer 객체의 areaCircle() 실행");
	return Math.PI * r * r;
}
	
}
