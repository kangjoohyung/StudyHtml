package ex22110678910;

public class Ex08UserDTO {
   private String userId; //DB user_id
   private String pwd;
   private String name;
   
   
   public Ex08UserDTO() {
	   //순서확인용출력
	   System.out.println("UserDTO");
   }
   public Ex08UserDTO(String userId, String pwd) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		
	}
	public Ex08UserDTO(String userId, String pwd, String name) {
	super();
	this.userId = userId;
	this.pwd = pwd;
	this.name = name;
}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
