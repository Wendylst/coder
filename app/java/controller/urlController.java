package controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.Login;
import business.ShopProcess;
import business_client.Business_client;
import business_client.Shop;
import client.Client;

@Controller
public class urlController {

	@Autowired
	ShopProcess shopProcess; // 매장관련 정보를 가지고 있는 DAO

	Shop shop = new Shop();
	Business_client bs_client = new Business_client(); // 업체 정보를가지고 있는 DTO
	Client user = new Client(); // 관리자 정보와 사용자 정보를 가지고 있는 DTO

	@Autowired
	Login login; // 관리자 관련 작업을 하기 위한 DAO

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}


	@RequestMapping(value = "/loginChk", method = RequestMethod.POST)
	public ModelAndView login_main(String email, String pass, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		user = login.login(email, pass);
		if (user == null) { // Client 에 존재 하지 않은 경우
			bs_client = login.bs_login(email, pass);
			if (bs_client != null) {
				mv.setViewName("business/main");
				model.addAttribute("user", bs_client);
				mv.addObject("user", bs_client);
				session.setAttribute("user", bs_client);
				return mv;
			} else {
				session.removeAttribute("user");
				mv.setViewName("redirect:http://localhost:9999/app/login");
				return mv;
			}
		} else { // Client 에 존재 하는 경우
			if (user.getEmail().equals("admin@gmail.com")) { // id가 관리자 아이디냐?
				session.setAttribute("user", user);
				mv.addObject("user", user);
				model.addAttribute("user", user);
				if (user.getEmail().equals("admin@gmail.com")) { // id가 관리자 
					mv.setViewName("admin/main");
					
					return mv; // 관리자 페이지로 이동
				}
				mv.setViewName("client/main");
				return mv; // 개인회원 메인 페이지로 이동
			}
		}
		return mv;
	}

	// 로그인페이지
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main(Locale locale, Model model) {
		return "login";

	}

	// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━사용자용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//
	// 사용자 - 회원가입 버튼 눌렀을 시에 페이지 이동
	@RequestMapping(value = "/client/register", method = RequestMethod.GET)
	public String client_regist(Locale locale, Model model) {
		return "client/register";
	}

	// 사용자 - 회원가입 입력시 성공하면 메인으로 이동
	@RequestMapping(value =	 "/client_regist", method = RequestMethod.POST)
	public String client_regist_post(Locale locale, Model model, Client client) {
		String ret = login.insert_Client(client);
		return "client/main";
	}

	// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━업 체  용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//

	// 업체 - 로그인시 업체용 메인화면 이동
	@RequestMapping(value = "/business/main", method = RequestMethod.GET)
	public ModelAndView bsmain(Locale locale, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		System.out.println("뒤로가기");
		if (session.getAttribute("email") == null) {
			mv.setViewName("../login");
			return mv;
		} else {
			mv.setViewName("redirect:main");
			return mv;
		}
	}

	// 업체 - 업체 회원 가입 폼으로 주소 이동
	@RequestMapping(value = "/business/register", method = RequestMethod.GET)
	public String bs_regist(Locale locale, Model model) {
		
		return "business/register";
	}

	// 업체 - 회원가입 성공 시 메인으로 이동
	@RequestMapping(value = "/bs_regist", method = RequestMethod.POST)
	public String bs_regist_post(Locale locale, Model model, Business_client client, HttpSession session) {
		String ret = login.insert_bs_Client(client);
		System.out.println(ret);
		if (session.getAttribute("email") == null) {
			return "login";
		} else {
			return "business/main";
		}
	}

	// 업체 정보 수정 페이지로 전환
	@RequestMapping(value = "/business/bs_update", method = RequestMethod.POST)
	public ModelAndView bs_update_post(Locale locale, Model model, String bs_no, HttpSession session) {
		System.out.print("업체정보 수정 업체번호 : ");
		System.out.println(bs_no);
		ModelAndView mv = new ModelAndView();
		bs_client = login.bs_Client_Info(bs_no);
		System.out.println(bs_client);
		mv.setViewName("business/updateInfo");
		mv.addObject("user", bs_client);
		return mv;
	}
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public ModelAndView bs_update_Info(Business_client client,Model model){
		System.out.println(client);
		ModelAndView mv = new ModelAndView();
		int ret = login.bs_Client_update(client);
		if (ret == 0) {
			System.out.println("수정실패");
			mv.setViewName("business/main");
			return mv;
		}
		System.out.println("수정성공");
		mv.setViewName("business/main");
		return mv;
	}
	
	

	// 업체 - 매장등록 페이지로 전환
	@RequestMapping(value = "/business/insertShop", method = RequestMethod.POST)
	public ModelAndView insertShop(Locale locale, Model model, Shop shop, String manager_name, String business_name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("business_name", business_name);
		mv.addObject("manager_name", manager_name);
		mv.setViewName("business/insertShop");

		return mv;
	}

	// 업체 - 매장등록 화면이동용 소스
	@RequestMapping(value = "/insertShopInfo", method = RequestMethod.POST)
	public String insertShopInfo(Locale locale, Model model, Shop shop) {
		System.out.println("매장등록");
		int ret = shopProcess.insert_Shop(shop);
		if (ret == 0) {
			System.out.println("입력실패");
			return "business/main";
		}
		System.out.println("등록성공");
		return "business/main";
	}

	// 업체 - 매장 정보 수정
	@RequestMapping(value = "/business/shopUpdate", method = RequestMethod.POST)
	public ModelAndView ShopInfo(Locale locale, Model model, String bs_no) {
		ModelAndView mv = new ModelAndView();
		List<Shop> list = shopProcess.ShopList(bs_no);
		mv.addObject("shop",list);
		mv.setViewName("ShopList");
		return mv;
	}

	
	
	
	
	
	
	
	// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━관 리 자 용━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━//

}
