package business;

public class Order {
	
	/*주 문 정 보*/
	
	private int order_no;			// 주문번호
	private String order_name;      // 메뉴 이름
	private int order_price;		// 메뉴 가격
	private String order_size;		// 사이즈
	private String order_option;	// 옵션
	private int quantity;			// 수량
	private String ordre_date;		// 주문날짜
	private int order_point;		// 포인트
	private int client_no;			// 회원번호 
	
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int oder_no) {
		this.order_no = oder_no;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_size() {
		return order_size;
	}
	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}
	public String getOrder_option() {
		return order_option;
	}
	public void setOrder_option(String order_option) {
		this.order_option = order_option;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrdre_date() {
		return ordre_date;
	}
	public void setOrdre_date(String ordre_date) {
		this.ordre_date = ordre_date;
	}
	public int getOrder_point() {
		return order_point;
	}
	public void setOrder_point(int order_point) {
		this.order_point = order_point;
	}
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	
	
	
	
	
}
