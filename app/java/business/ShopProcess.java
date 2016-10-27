package business;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import business_client.Shop;

@Repository
public class ShopProcess {
	
	Shop shop = new Shop();
	
	@Autowired
	SqlSession session;
	
	@Autowired
	DataSource dataSource;

	// ���� ���
	public int insert_Shop(Shop shop){
		System.out.println(shop);
		int ret=  session.insert("system.a.insert_Shop", shop);
		return ret;
	 }
	
	// ���� ����Ʈ ��������
	public List<Shop> ShopList(String bs_no){			
		return session.selectList("system.a.shopList", bs_no);
	}

	// ���� ���� ����
	public int update_shop(Shop shop){
		System.out.println(shop);
		return session.selectOne("system.a.shopUpdate", shop);
	}
	// ���� ����
	public int delete_shop(String shop_no){
		System.out.println(shop_no);
		return session.selectOne("system.a.shopdelete", shop_no);
	}
	
	
	
	

}
