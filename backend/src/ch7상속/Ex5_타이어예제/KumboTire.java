package ch7상속.Ex5_타이어예제;

public class KumboTire extends Tire{
	// ??? : 슈퍼클래스와 생성자가 다르기 때문에.
	public KumboTire(int maxRotation, String loction) {
		super(maxRotation, loction);

	}
	public boolean roll() {
		++accumlatedRotation; // 누적 회전 수 1 씩 증가
		if( accumlatedRotation < maxRotation ) { // 최대 회전 수 보다 누적 회전 수 가 더 작으면 [ 수명 남음 ]
			System.out.println( loction + "KumboTire 수명 : " 
				+ (maxRotation-accumlatedRotation) + "회");
			return true; // 수명 있을경우 true
		}else {
			System.out.println("***" + loction + "KumboTire 펑크 ***");
			return false; // 수명 없을경우 false [ 펑크 일 경우 ]
		}

	}
}