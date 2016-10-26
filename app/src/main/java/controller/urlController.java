package controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.object.MappingCommAreaOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.Login;
import business_client.Business_client;
import business_client.Shop;
import client.Client;

@Controller
public class urlController {
	

	
	Business_client bs_client= new Business_client(); // 업체 정보를가지고 있는 DTO
	Client user = new Client(); // 관리자 정보와 사용자 정보를 가지고 있는 DTO

	
	@Autowired
	Login login; // 관리자 관련 작업을 하기 위한 DAO
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/loginChk", method = RequestMethod.POST)
	public ModelAndView admin(String email, String pass, Model model) {
		System.out.println(email);
		System.out.println(pass);
		ModelAndView mv = new ModelAndView();
		user = login.login(email, pass);
		if (user == null) { // Client 에 존재 하지 않은 경우
			bs_client = login.bs_login(email, pass);
			if(bs_client != null){
				
				mv.setViewName("business/main");
				model.addAttribute("user", bs_client);
				System.out.println(bs_client.getBusiness_name()+"/"+bs_client.getManager_name());
				mv.addObject("user", bs_client);
				return mv;
				
			}else{
				mv.setViewName("redirect:http://localhost:9999/app/login");
				return mv;
			
			}
		} else {	// Client 에 존재 하는 경우 
			
			if(user.getEmail().equals("admin@gmail.com")){	// id가 관리자 아이디냐?				
				mv.addObject("user", user);
				mv.setViewName("admin/main");
				model.addAttribute("user", user);
				return mv; // 관리자 페이지로 이동
			}
			mv.addObject("user", user);
			mv.setViewName("client/main");
			model.addAttribute("user", user);
			return mv; 	// 개인회원 메인 페이지로 이동
		}
	}



	
	// 로그인페이지 
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main(Locale locale, Model model) {
			return "login";

	}
	//━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━사용자용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//
	// 사용자 - 회원가입 버튼 눌렀을 시에 페이지 이동
	@RequestMapping(value = "/client/register", method = RequestMethod.GET)
	public String client_regist(Locale locale, Model model) {
		return "client/register";
	}
	
	// 사용자 - 회원가입 입력시 성공하면 메인으로 이동
	@RequestMapping(value = "/client_regist", method = RequestMethod.POST)
	public String client_regist_post(Locale locale, Model model, Client client) {
		String ret = login.insert_Client(client);
		return "main";
	}
	
	
	//━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━업 체 용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//

	// 업체 - 로그인시  업체용 메인화면 이동
	@RequestMapping(value = "business/main", method = RequestMethod.POST)
	public String bsmain(Locale locale, Model model) {
			return "business/main";

	}
	// 업체 - 업체 회원 가입 폼으로 주소 이동 
	@RequestMapping(value = "/business/register", method = RequestMethod.GET)
	public String bs_regist(Locale locale, Model model) {
		return "business/register";
	}
	
	//업체 - 회원가입 성공 시 메인으로 이동 
	@RequestMapping(value = "/bs_regist", method = RequestMethod.POST)
	public String bs_regist_post(Locale locale, Model model, Business_client client) {
		String ret = login.insert_bs_Client(client);
		System.out.println(ret);

		return "main";
	}
	
	
	// 업체 정보 수정
	@RequestMapping(value = "/bs_update", method = RequestMethod.POST)
	public String bs_update_post(Locale locale, Model model, Business_client client) {
		
		
		return "updateInfo";
	}
	
	// 업체 - 매장등록
	@RequestMapping(value = "/insertShop", method = RequestMethod.POST)
	public ModelAndView insertShop(Locale locale, Model model, Shop shop, String manager_name, String business_name){
		
		System.out.println("매장등록");
		System.out.println(model);
		System.out.println(manager_name);
		System.out.println(business_name);
		ModelAndView mv = new ModelAndView();
		mv.addObject("business_name",business_name);
		mv.addObject("manager_name",manager_name);
		mv.setViewName("business/insertShop");
	
		return mv;
	}
	
	// 업체 - 매장등록 화면이동용 소스
	@RequestMapping(value = "/insertShopInfo", method = RequestMethod.POST)
	public String insertShopInfo(Locale locale, Model model, Shop shop){
		
		return "";
	}
	
	//━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━업 체 용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//
	
}
