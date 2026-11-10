package Entity;

public class MASed {
	private String MASid;
	private String MASname;
	private String MASgender;
	private String MAStele;
	private String MASfield;
	private String MASemail;
	private String MASMes;
	private String MASresult;
	private String MASpatent;
	private int status;
	public String getMASid() {
		return MASid;
	}
	public void setMASid(String mASid) {
		MASid = mASid;
	}
	public String getMASname() {
		return MASname;
	}
	public void setMASname(String mASname) {
		MASname = mASname;
	}
	public String getMASgender() {
		return MASgender;
	}
	public void setMASgender(String mASgender) {
		MASgender = mASgender;
	}
	public String getMAStele() {
		return MAStele;
	}
	public void setMAStele(String mAStele) {
		MAStele = mAStele;
	}
	public String getMASfield() {
		return MASfield;
	}
	public void setMASfield(String mASfield) {
		MASfield = mASfield;
	}
	public String getMASemail() {
		return MASemail;
	}
	public void setMASemail(String mASemail) {
		MASemail = mASemail;
	}
	public String getMASMes() {
		return MASMes;
	}
	public void setMASMes(String mASMes) {
		MASMes = mASMes;
	}
	public String getMASresult() {
		return MASresult;
	}
	public void setMASresult(String mASresult) {
		MASresult = mASresult;
	}
	public String getMASpatent() {
		return MASpatent;
	}
	public void setMASpatent(String mASpatent) {
		MASpatent = mASpatent;
	}
	public MASed(String mASid, String mASname, String mASgender, String mAStele, String mASfield, String mASemail,
			String mASMes, String mASresult, String mASpatent,int sta) {
		super();
		MASid = mASid;
		MASname = mASname;
		MASgender = mASgender;
		MAStele = mAStele;
		MASfield = mASfield;
		MASemail = mASemail;
		MASMes = mASMes;
		MASresult = mASresult;
		MASpatent = mASpatent;
		status=sta;
	}
	public int getstatus() {
		return status;
	}
	public void setstatus(int status1) {
		status = status1;
	}
}
