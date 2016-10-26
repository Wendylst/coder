package business;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import business_client.Business_client;
import client.Client;

@Repository
public class Login {
	Client user = new Client();
	@Autowired
	SqlSession session;
	
	@Autowired
	DataSource dataSource;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client login(String email,String password){
		 System.out.println("Login = "+email + "pass ="+ password);
	
		 Map<String,String> me= new HashMap<String, String>();
		 me.put("email", email);
		 me.put("password", password);
		 
		 return session.selectOne("loginchk.a.login", me);
	 }
	
	public String insert_Client(Client client){
		int ret=  session.insert("loginchk.a.insert_Client", client);
		 return ret>0? "입력성공":"입력실패";
	 }
	
	public String insert_bs_Client(Business_client client){
		int ret=  session.insert("loginchk.a.insert_bs_Client", client);
		return ret>0? "입력성공":"입력실패";
	}
	
	public Business_client bs_login(String email, String password){
		System.out.println("업체 회원 로그인    Login = "+email + " password ="+ password);
		 Map<String,String> me= new HashMap<String, String>();
		 me.put("bs_email", email);
		 me.put("bs_password", password);
		 
		return session.selectOne("loginchk.a.bs_login", me);
	}
	
	
	
	
}
