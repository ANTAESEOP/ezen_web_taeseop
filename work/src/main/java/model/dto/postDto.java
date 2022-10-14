package model.dto;

public class postDto {

		private int pno;
		private String ptitle;
		private String pwriter;
		private String pcontent;
		private String ppasword;
		private int pdate;
		private int pview;
		
		public postDto() {}

		public postDto(int pno, String ptitle, String pwriter, String pcontent, String ppasword, int pdate, int pview) {
			super();
			this.pno = pno;
			this.ptitle = ptitle;
			this.pwriter = pwriter;
			this.pcontent = pcontent;
			this.ppasword = ppasword;
			this.pdate = pdate;
			this.pview = pview;
		}

		public int getPno() {
			return pno;
		}

		public void setPno(int pno) {
			this.pno = pno;
		}

		public String getPtitle() {
			return ptitle;
		}

		public void setPtitle(String ptitle) {
			this.ptitle = ptitle;
		}

		public String getPwriter() {
			return pwriter;
		}

		public void setPwriter(String pwriter) {
			this.pwriter = pwriter;
		}

		public String getPcontent() {
			return pcontent;
		}

		public void setPcontent(String pcontent) {
			this.pcontent = pcontent;
		}

		public String getPpasword() {
			return ppasword;
		}

		public void setPpasword(String ppasword) {
			this.ppasword = ppasword;
		}

		public int getPdate() {
			return pdate;
		}

		public void setPdate(int pdate) {
			this.pdate = pdate;
		}

		public int getPview() {
			return pview;
		}

		public void setPview(int pview) {
			this.pview = pview;
		}

		@Override
		public String toString() {
			return "postDto [pno=" + pno + ", ptitle=" + ptitle + ", pwriter=" + pwriter + ", pcontent=" + pcontent
					+ ", ppasword=" + ppasword + ", pdate=" + pdate + ", pview=" + pview + "]";
		}

		
}		