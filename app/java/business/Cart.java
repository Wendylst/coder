package business;

public class Cart {

	/* �� �� �� �� */
	private int client_no; //ȸ����ȣ
	private int menu_no;   // �Ŵ���ȣ
	private int cart_no;   // ��ٱ��� ��ȣ  
	private int cart_quantity; //����
	
	public int getClient_no() {
		return client_no;
	}
	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}
	public int getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	
}
