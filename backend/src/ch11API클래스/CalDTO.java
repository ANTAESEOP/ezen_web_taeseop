package ch11API클래스;

public class CalDTO {
	
	int plan_num;
	String plan_date;
	String plan_mono;
	
	public CalDTO(int plan_num, String plan_date, String plan_mono) {
		this.plan_num = plan_num;
		this.plan_date = plan_date;
		this.plan_mono = plan_mono;
	}

	public int getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}
	public String getPlan_date() {
		return plan_date;
	}
	public void setPlan_date(String plan_date) {
		this.plan_date = plan_date;
	}
	public String getPlan_mono() {
		return plan_mono;
	}
	public void setPlan_mono(String plan_mono) {
		this.plan_mono = plan_mono;
	}
	
}
