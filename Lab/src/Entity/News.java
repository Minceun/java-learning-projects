package Entity;

public class News {
	private String newTitle;
	private String newText;
	private String newTime;
	
	public News( String newTitle, String newText, String newTime) {
		super();
		
		this.newTitle = newTitle;
		this.newText = newText;
		this.newTime = newTime;
	}
	
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewText() {
		return newText;
	}
	public void setNewText(String newText) {
		this.newText = newText;
	}
	public String getNewTime() {
		return newTime;
	}
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
}
