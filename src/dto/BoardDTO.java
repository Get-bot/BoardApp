package dto;

public class BoardDTO {
	private int bnumber;
	private String bwriter;
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
	private String bfilename;
	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontents="
				+ bcontents + ", bdate=" + bdate + ", bhits=" + bhits + ", bfilename=" + bfilename + "]";
	}
	public int getBnumber() {
		return bnumber;
	}
	public String getBwriter() {
		return bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBcontents() {
		return bcontents;
	}
	public String getBdate() {
		return bdate;
	}
	public int getBhits() {
		return bhits;
	}
	public String getBfilename() {
		return bfilename;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}
	public void setBfilename(String bfilename) {
		this.bfilename = bfilename;
	}

	
}