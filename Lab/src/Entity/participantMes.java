package Entity;

public class participantMes {
	private String parName;
	private String parGender;
	private int parAge;
	private String parTele;
	private String parDegree;
	private String parWork;
	private String parPerMes;
	private String parPrize;
	private String parReason;
	public String getParName() {
		return parName;
	}
	public void setParName(String parName) {
		this.parName = parName;
	}
	public String getParGender() {
		return parGender;
	}
	public void setParGender(String parGender) {
		this.parGender = parGender;
	}
	public int getParAge() {
		return parAge;
	}
	public void setParAge(int parAge) {
		this.parAge = parAge;
	}
	public String getParDegree() {
		return parDegree;
	}
	public void setParDegree(String parDegree) {
		this.parDegree = parDegree;
	}
	public String getParWork() {
		return parWork;
	}
	public void setParWork(String parWork) {
		this.parWork = parWork;
	}
	public String getParPerMes() {
		return parPerMes;
	}
	public void setParPerMes(String parPerMes) {
		this.parPerMes = parPerMes;
	}
	public String getParPrize() {
		return parPrize;
	}
	public void setParPrize(String parPrize) {
		this.parPrize = parPrize;
	}
	public String getParReason() {
		return parReason;
	}
	public void setParReason(String parReason) {
		this.parReason = parReason;
	}
	public String getParTele() {
		return parTele;
	}
	public void setParTele(String parTele) {
		this.parTele = parTele;
	}
	public participantMes(String parName, String parGender, int parAge, String parTele, String parDegree,
			String parWork, String parPerMes, String parPrize, String parReason) {
		super();
		this.parName = parName;
		this.parGender = parGender;
		this.parAge = parAge;
		this.parTele = parTele;
		this.parDegree = parDegree;
		this.parWork = parWork;
		this.parPerMes = parPerMes;
		this.parPrize = parPrize;
		this.parReason = parReason;
	}
	
	
}
