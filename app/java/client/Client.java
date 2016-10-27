package client;

public class Client {
	
	/*유저 사용자 정보 */
	private int client_no;	 	 // 회원번호 
	private String email; 		 // 이메일 -> 아이디로 사용
	private String password;	 // 비밀번호
	private String name;		 // 이름
	private String phone; 		 // 전화번호 
	
	
	@Override
	public String toString() {
		return "Client [client_no=" + client_no + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + "]";
	}

	
	
	
	public Client(String email, String password, String name, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}




	public Client(){
		
	}
	
	
	public Client(int client_no, String email, String password, String name, String phone) {
		super();
		this.client_no = client_no;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}




	public Client(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
