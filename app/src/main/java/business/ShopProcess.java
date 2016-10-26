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

	public String insert_Shop(Shop shop){
		int ret=  session.insert("loginchk.a.insert_Shop", shop);
		 return ret>0? "입력성공":"입력실패";
	 }



}
