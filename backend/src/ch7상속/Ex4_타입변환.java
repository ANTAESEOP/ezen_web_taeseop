package ch7상속;

class A{}

class B extends A{}					// 			A
class C extends A{}					// 		B		C
									// 		D		E
class D extends B{}
class E extends C{}

public class Ex4_타입변환 {
	public static void main(String[] args) {
		B b = new B(); C c = new C();
		D d = new D(); E e = new E();
		
		A a1 = b;	A a2 = c;	A a3 = d; A a4 = e;
		B b1 = d;	C c1 = e;	
	}

}
