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

	// 매장 등록
	public int insert_Shop(Shop shop){
		System.out.println(shop);
		int ret=  session.insert("system.a.insert_Shop", shop);
		return ret;
	 }
	
	// 매장 리스트 가져오기
	public List<Shop> ShopList(String bs_no){			
		return session.selectList("system.a.shopList", bs_no);
	}

	// 매장 정보 수정
	public int update_shop(Shop shop){
		System.out.println(shop);
		return session.selectOne("system.a.shopUpdate", shop);
	}
	// 매장 삭제
	public int delete_shop(String shop_no){
		System.out.println(shop_no);
		return session.selectOne("system.a.shopdelete", shop_no);
	}
	
	
	
	

}
