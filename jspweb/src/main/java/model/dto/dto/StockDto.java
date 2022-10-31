package model.dto.dto;

public class StockDto {
	public int psno; 		// 제품 사이즈 pk
	public String psize;	// 제품 사이즈명 
	public int pstno;		// 제품 색상재고 pk
	public String pcolor;	// 제품 색상명
	public int pstock;		// 제품 재고

	public StockDto() {}

	public StockDto(int psno, String psize, int pstno, String pcolor, int pstock) {
		super();
		this.psno = psno;
		this.psize = psize;
		this.pstno = pstno;
		this.pcolor = pcolor;
		this.pstock = pstock;
	}

	public int getPsno() {
		return psno;
	}

	public void setPsno(int psno) {
		this.psno = psno;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public int getPstno() {
		return pstno;
	}

	public void setPstno(int pstno) {
		this.pstno = pstno;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	@Override
	public String toString() {
		return "StockDto [psno=" + psno + ", psize=" + psize + ", pstno=" + pstno + ", pcolor=" + pcolor + ", pstock="
				+ pstock + "]";
	}
	
}
