package dto;

public class BoardDTO {
	int bnumber;
	String bwriter;
	String btitle;
	String bcontents;
	String bdate;
	int bhits;
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontents() {
		return bcontents;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhits() {
		return bhits;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}
	public BoardDTO() {
		super();
	}
	public BoardDTO(int bnumber, String bwriter, String btitle, String bcontents, String bdate, int bhits) {
		super();
		this.bnumber = bnumber;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bdate = bdate;
		this.bhits = bhits;
	}
	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontents="
				+ bcontents + ", bdate=" + bdate + ", bhits=" + bhits + "]";
	}
	
	
}
