package ch7상속.Ex5_타이어예제;

public class HankookTire extends Tire {
	
	// 1. 필드
	// 2. 생성자
	public HankookTire(int maxRotation, String loction) {
		super(maxRotation, loction);
	}
	// 3. 메소드
		// 1. roll 재정의
	@Override
	public boolean roll() {
		++accumlatedRotation; // 누적 회전 수 1 씩 증가
		if( accumlatedRotation < maxRotation ) { // 최대 회전 수 보다 누적 회전 수 가 더 작으면 [ 수명 남음 ]
			System.out.println( loction + "HankookTire 수명 : " 
				+ (maxRotation-accumlatedRotation) + "회");
			return true; // 수명 있을경우 true
		}else {
			System.out.println("***" + loction + "HankookTire 펑크 ***");
			return false; // 수명 없을경우 false [ 펑크 일 경우 ]
		}
	}
}
	

