package 키오스크.관리자;

public class MenuDto {
	
	private int mno;
	private String mname;
	
	public MenuDto() {}
	public MenuDto(int mno, String mname) {
		this.mno = mno;
		this.mname = mname;	
		
	}
	// 3. 메소드 [ pravite 필드 접근 메소드 : getter , setter ]
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
