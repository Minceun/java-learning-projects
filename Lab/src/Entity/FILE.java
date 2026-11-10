package Entity;

public class FILE {
	private String fileName;
	private String fileCon;
	private String filePath;
	private String fileOwner;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileCon() {
		return fileCon;
	}
	public void setFileCon(String fileCon) {
		this.fileCon = fileCon;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}
	public FILE(String fileName, String fileCon, String filePath, String fileOwner) {
		super();
		this.fileName = fileName;
		this.fileCon = fileCon;
		this.filePath = filePath;
		this.fileOwner = fileOwner;
	}
	
}
