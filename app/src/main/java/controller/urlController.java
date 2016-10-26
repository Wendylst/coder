package controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.Login;
import business_client.Business_client;
import client.Client;

@Controller
public class urlController {
	
	Business_client bs_client= new Business_client();
	Client user = new Client(); // 관리자 정보를 가지고 있는 DTO

	@Autowired
	Login login; // 관리자 관련 작업을 하기 위한 DAO
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/loginChk", method = RequestMethod.POST)
	public String admin(String email, String pass) {
		System.out.println(email);
		System.out.println(pass);
		ModelAndView mv = new ModelAndView();
		user = login.login(email, pass);
		if (user == null) {
			System.out.println("존재하지않음");
			return "redirect:http://localhost:9999/app/login";
			
		} else {	
			System.out.println("관리자");
			if(user.getEmail().equals("admin@gmail.com")){
		
				return "admin_main";
			}
			
			return "main"; 	
		}
	}

	@RequestMapping(value = "/business/register", method = RequestMethod.GET)
	public String bs_regist(Locale locale, Model model) {
		return "business/register";
	}

	@RequestMapping(value = "/client/register", method = RequestMethod.GET)
	public String client_regist(Locale locale, Model model) {
		return "client/register";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main(Locale locale, Model model) {
		return "main";
	}
	@RequestMapping(value = "/admin_main", method = RequestMethod.POST)
	public String system_main(Locale locale, Model model) {
		System.out.println("관리자");
		return "admin_main";
	}
	@RequestMapping(value = "/client_regist", method = RequestMethod.POST)
	public String client_regist_post(Locale locale, Model model, Client client) {
		System.out.println("개인회원가입");
		System.out.println(client);
		String ret = login.insert_Client(client);
		System.out.println(ret);
		
		return "main";
	}
	@RequestMapping(value = "/bs_regist", method = RequestMethod.POST)
	public String bs_regist_post(Locale locale, Model model, Business_client client) {
		System.out.println("기업회원가입");
		System.out.println(client);
		String ret = login.insert_bs_Client(client);
		System.out.println(ret);

		return "main";
	}
	

}
