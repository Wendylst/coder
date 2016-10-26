package business;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import business_client.Shop;
import client.Client;

@Repository
public class ShopProcess {
	
	Shop shop = new Shop();
	
	@Autowired
	SqlSession session;
	
	@Autowired
	DataSource dataSource;

	public int insert_Shop(Shop shop){
		System.out.println(shop);
		int ret=  session.insert("system.a.insert_Shop", shop);
		return ret;
	 }



}
