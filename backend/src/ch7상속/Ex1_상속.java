package ch7상속;

public class Ex1_상속 {
	
	public static void main(String[] args) {
		
		// 1. 객체 생성 [ 클래스명 객체명 = new 생성자() ]
		DmbCellPhone dmbCellPhone
			= new DmbCellPhone("자바폰", "검정", 10);
		
		// 2. 객체가 상속받은 필드 호출
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색상 : " + dmbCellPhone.color);
		
		// 3. 본인 클래스
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		// 4. 객체[클래스]가 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보쇼");
		dmbCellPhone.receiveVoice("안녕하세요 저는 김미영 팀장 입니다.");
		dmbCellPhone.sendVoice("대출 안 받아요");
		dmbCellPhone.hangUp();
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnoffDmb();
	}
}
