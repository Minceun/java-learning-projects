package Entity;

public class COR {
	private String CORname;
	private String CORgender;
	private int CORage;
	private String CORidea;
	private String CORtele;
	public String getCORname() {
		return CORname;
	}
	public void setCORname(String cORname) {
		CORname = cORname;
	}
	public String getCORgender() {
		return CORgender;
	}
	public void setCORgender(String cORgender) {
		CORgender = cORgender;
	}
	public int getCORage() {
		return CORage;
	}
	public void setCORage(int cORage) {
		CORage = cORage;
	}
	public String getCORidea() {
		return CORidea;
	}
	public void setCORidea(String cORidea) {
		CORidea = cORidea;
	}
	public String getCORtele() {
		return CORtele;
	}
	public void setCORtele(String cORtele) {
		CORtele = cORtele;
	}
	public COR(String cORname, String cORgender, int cORage, String cORidea, String cORtele) {
		super();
		CORname = cORname;
		CORgender = cORgender;
		CORage = cORage;
		CORidea = cORidea;
		CORtele = cORtele;
	}
	
}
