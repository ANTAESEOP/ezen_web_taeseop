package ch5클래스.과제;

public class CashDTO {
	
	// 1. 필드
	private int pno;
	private String cash_date;
	private int cash_price;
	private String cash_content;
	
	// 2. 생성자
	public CashDTO() {}

	public CashDTO(int pno, String cash_date, int cash_price, String cash_content) {
		super();
		this.pno = pno;
		this.cash_date = cash_date;
		this.cash_price = cash_price;
		this.cash_content = cash_content;
	
		
	// 3. 메소드
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getCash_date() {
		return cash_date;
	}
	public void setCash_date(String cash_date) {
		this.cash_date = cash_date;
	}
	public int getCash_price() {
		return cash_price;
	}
	public void setCash_price(int cash_price) {
		this.cash_price = cash_price;
	}
	public String getCash_content() {
		return cash_content;
	}
	public void setCash_content(String cash_content) {
		this.cash_content = cash_content;
	}
}
