package business;

public class BookMark {
	
	/* 자주 가는 카페 설정 */
	
	private int client_no;   // 회원번호
	private int shop_no;	 // 매장번호
	private int bookmark_no; // 즐겨찾기 번호 
	
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	public int getShop_no() {
		return shop_no;
	}
	public void setShop_no(int shop_no) {
		this.shop_no = shop_no;
	}
	public int getBookmark_no() {
		return bookmark_no;
	}
	public void setBookmark_no(int bookmark_no) {
		this.bookmark_no = bookmark_no;
	}
	
	
	
	
}
