package Entity;

public class admin {
	private String id;
	private String admin_num;
	private String admin_name;
	private String admin_password;
	private int status;
	public admin(String id, String admin_num, String admin_name, String admin_password, int status) {
		super();
		this.id = id;
		this.admin_num = admin_num;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(String admin_num) {
		this.admin_num = admin_num;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public admin(String id, String admin_num, String admin_name, String admin_password) {
		super();
		this.id = id;
		this.admin_num = admin_num;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}
	public admin(String admin_num, String admin_password) {
		super();
		System.out.println("创建账号密码对象");
		this.admin_num = admin_num;
		this.admin_password = admin_password;
	}
	
}
