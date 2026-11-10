package Entity;

public class DOCed {
	private String DOCid;
	private String DOCname;
	private String DOCgender;
	private String DOCtele;
	private String DOCfield;
	private String DOCemail;
	private String DOCMes;
	private String DOCresult;
	private String DOCpatent;
	private int status;
	public DOCed(String dOCid, String dOCname, String dOCgender, String dOCtele, String dOCfield, String dOCemail,
			String dOCMes, String dOCresult, String dOCpatent,int sta) {
		super();
		DOCid = dOCid;
		DOCname = dOCname;
		DOCgender = dOCgender;
		DOCtele = dOCtele;
		DOCfield = dOCfield;
		DOCemail = dOCemail;
		DOCMes = dOCMes;
		DOCresult = dOCresult;
		DOCpatent = dOCpatent;
		status=sta;
	}
	public String getDOCid() {
		return DOCid;
	}
	public void setDOCid(String dOCid) {
		DOCid = dOCid;
	}
	public String getDOCname() {
		return DOCname;
	}
	public void setDOCname(String dOCname) {
		DOCname = dOCname;
	}
	public String getDOCgender() {
		return DOCgender;
	}
	public void setDOCgender(String dOCgender) {
		DOCgender = dOCgender;
	}
	public String getDOCtele() {
		return DOCtele;
	}
	public void setDOCtele(String dOCtele) {
		DOCtele = dOCtele;
	}
	public String getDOCfield() {
		return DOCfield;
	}
	public void setDOCfield(String dOCfield) {
		DOCfield = dOCfield;
	}
	public String getDOCemail() {
		return DOCemail;
	}
	public void setDOCemail(String dOCemail) {
		DOCemail = dOCemail;
	}
	public String getDOCMes() {
		return DOCMes;
	}
	public void setDOCMes(String dOCMes) {
		DOCMes = dOCMes;
	}
	public String getDOCresult() {
		return DOCresult;
	}
	public void setDOCresult(String dOCresult) {
		DOCresult = dOCresult;
	}
	public String getDOCpatent() {
		return DOCpatent;
	}
	public void setDOCpatent(String dOCpatent) {
		DOCpatent = dOCpatent;
	}
	public int getstatus() {
		return status;
	}
	public void setstatus(int status1) {
		status = status1;
	}
	
}
