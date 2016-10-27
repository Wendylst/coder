package business_client;

public class Shop {
	/* 매 장 정 보 */
	private int shop_no;        	 // 매장번호     
	private String shop_name;   	 // 매장명
	private String shop_address; 	 // 매장주소
	private String operation_hour;   // 운영시간   
	private String shop_phone;       // 매장전화번호
	private String title;       	 // 소개
	private String approval_chk;   	 // 등록승인여부
	private int bs_no;               // 업체 번호
	private String shop_img;		 // 매장 로고 이미지
	
	public int getShop_no() {
		return shop_no;
	}
	public void setShop_no(int shop_no) {
		this.shop_no = shop_no;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getOperation_hour() {
		return operation_hour;
	}
	public void setOperation_hour(String operation_hour) {
		this.operation_hour = operation_hour;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApproval_chk() {
		return approval_chk;
	}
	public void setApproval_chk(String approval_chk) {
		this.approval_chk = approval_chk;
	}
	public int getBs_no() {
		return bs_no;
	}
	public void setBs_no(int bs_no) {
		this.bs_no = bs_no;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	@Override
	public String toString() {
		return "Shop [shop_no=" + shop_no + ", shop_name=" + shop_name + ", shop_address=" + shop_address
				+ ", operation_hour=" + operation_hour + ", shop_phone=" + shop_phone + ", title=" + title
				+ ", approval_chk=" + approval_chk + ", bs_no=" + bs_no + ", shop_img=" + shop_img + "]";
	}

	
	
	
	
	
}