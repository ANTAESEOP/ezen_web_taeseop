package ch12스레드;

public class Ex2_스레드이름 {

	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread(); //  Thread.currentThread() : 현재 스레드 호출
		System.out.println(" main함수에 있는 스레드 이름은 : " 
							+ mainThread.getName());
		스레드A 스레드a = new 스레드A();
		스레드a.start();
		
		스레드B 스레드b = new 스레드B();
		스레드b.start();
		
		
	}
	
}
