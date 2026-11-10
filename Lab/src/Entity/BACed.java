package Entity;

public class BACed {
	private String BACid;
	private String BACname;
	private String BACgender;
	private String BACtele;
	private String BACemail;
	private String BACMes;
	private int status;
	public String getBACid() {
		return BACid;
	}
	public void setBACid(String bACid) {
		BACid = bACid;
	}
	public String getBACname() {
		return BACname;
	}
	public void setBACname(String bACname) {
		BACname = bACname;
	}
	public String getBACgender() {
		return BACgender;
	}
	public void setBACgender(String bACgender) {
		BACgender = bACgender;
	}
	public String getBACtele() {
		return BACtele;
	}
	public void setBACtele(String bACtele) {
		BACtele = bACtele;
	}
	public String getBACemail() {
		return BACemail;
	}
	public void setBACemail(String bACemail) {
		BACemail = bACemail;
	}
	public String getBACMes() {
		return BACMes;
	}
	public void setBACMes(String bACMes) {
		BACMes = bACMes;
	}
	public int getstatus() {
		return status;
	}
	public void setstatus(int sta) {
		status = sta;
	}
	public BACed(String bACid, String bACname, String bACgender, String bACtele, String bACemail, String bACMes,int sta) {
		super();
		BACid = bACid;
		BACname = bACname;
		BACgender = bACgender;
		BACtele = bACtele;
		BACemail = bACemail;
		BACMes = bACMes;
		status = sta;
	}
	
}
