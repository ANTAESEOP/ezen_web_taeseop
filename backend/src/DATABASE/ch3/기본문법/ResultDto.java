package DATABASE.ch3.기본문법;

public class ResultDto {

		String mem_id;
		double value; // 집계 함수 결과를 저장하는 필드
		
		public ResultDto(String mem_id, double value) {
			super();
			this.mem_id = mem_id;
			this.value = value;
		}
		
		// 2. 생성자
		
}
