package business_client;

public class Business_client {

	// ��ü ���� 
	private String business_name ;   // ��ü��    
	private int bs_no;				// ��ü ��ȣ
	private String bs_email;		// ��ü �̸���
	private String bs_password  ;   // ��ü ��й�ȣ     	
	private String business_phone;   // ��ǥ��ȣ   
	private String representative;   // ��ǥ�ڸ�
	private int cr_no;				 // ����ڵ�Ϲ�ȣ    
	private String manager_name;     // ����� �̸�
	private String manager_phone;    // ����� ��ȣ
	private String manager_email;    // ����� �̸���
	
	public Business_client(){
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Business_client [business_name=" + business_name + ", bs_no=" + bs_no + ", bs_email=" + bs_email
				+ ", bs_password=" + bs_password + ", business_phone=" + business_phone + ", representative="
				+ representative + ", cr_no=" + cr_no + ", manager_name=" + manager_name + ", manager_phone="
				+ manager_phone + ", manager_email=" + manager_email + "]";
	}




	public int getBs_no() {
		return bs_no;
	}
	public void setBs_no(int bs_no) {
		this.bs_no = bs_no;
	}
	public String getBs_email() {
		return bs_email;
	}
	public void setBs_email(String bs_email) {
		this.bs_email = bs_email;
	}
	public String getBs_password() {
		return bs_password;
	}
	public void setBs_password(String bs_password) {
		this.bs_password = bs_password;
	}

	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_phone() {
		return business_phone;
	}
	public void setBusiness_phone(String business_phone) {
		this.business_phone = business_phone;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public int getCr_no() {
		return cr_no;
	}
	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	public Business_client(int bs_no, String bs_email, String bs_password, String business_name, String business_phone,
			String representative, int cr_no, String manager_name, String manager_phone, String manager_email) {
		super();
		this.bs_no = bs_no;
		this.bs_email = bs_email;
		this.bs_password = bs_password;
		this.business_name = business_name;
		this.business_phone = business_phone;
		this.representative = representative;
		this.cr_no = cr_no;
		this.manager_name = manager_name;
		this.manager_phone = manager_phone;
		this.manager_email = manager_email;
	}
	public Business_client(String business_name, String bs_email, String bs_password, String business_phone,
			String representative, int cr_no, String manager_name, String manager_phone, String manager_email) {
		super();
		this.business_name = business_name;
		this.bs_email = bs_email;
		this.bs_password = bs_password;
		this.business_phone = business_phone;
		this.representative = representative;
		this.cr_no = cr_no;
		this.manager_name = manager_name;
		this.manager_phone = manager_phone;
		this.manager_email = manager_email;
	}      
	
	
	
	
}
