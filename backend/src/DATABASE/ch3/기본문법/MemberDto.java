package DATABASE.ch3.기본문법;

public class MemberDto {
	// 1. 필드
	// DB TABLE 필드명 동일 gka
	String mem_id;
	String mem_name;
	int mem_number;	
	String addr;		
	String phone1;					
	String phone2;					
	short height;			
	String debut_date; 
	int num;
	String pord_name;
	String group_name;
	int price;
	int amount;
	
	
	// 2. 생성자
	public MemberDto() {}


	public MemberDto(String mem_id, String mem_name, int mem_number, String addr, String phone1, String phone2,
			short height, String debut_date, int num, String pord_name, String group_name, int price, int amount) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_number = mem_number;
		this.addr = addr;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.height = height;
		this.debut_date = debut_date;
		this.num = num;
		this.pord_name = pord_name;
		this.group_name = group_name;
		this.price = price;
		this.amount = amount;
	}
	
	
		
}
