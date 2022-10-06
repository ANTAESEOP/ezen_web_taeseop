package ch8인터페이스;

public class Car {
	Tire  FrontLeftTire = new HankookTire();
	Tire  FrontRightTire = new HankookTire();
	Tire  BackLeftTire = new HankookTire();
	Tire  BackRightTire = new HankookTire();
	void run( ) {
		FrontLeftTire.roll(); BackLeftTire.roll();
		BackLeftTire.roll(); BackRightTire.roll();
	}
}
