package controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import business.Login;
import business.ShopProcess;
import business_client.Business_client;
import business_client.Shop;
import client.Client;

@Controller
public class urlController {

	@Autowired
	ShopProcess shopProcess; // ������� ������ ������ �ִ� DAO

	Shop shop = new Shop();
	Business_client bs_client = new Business_client(); // ��ü ������������ �ִ� DTO
	Client user = new Client(); // ������ ������ ����� ������ ������ �ִ� DTO

	@Autowired
	Login login; // ������ ���� �۾��� �ϱ� ���� DAO

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/testpage", method = RequestMethod.GET)
	public String testpage(Locale locale, Model model) {
		return "client/main";
	}

	
	
	
	
	
	@RequestMapping(value = "/loginChk", method = RequestMethod.GET)
	public ModelAndView login_get(Locale locale, Model model, HttpSession session, HttpServletResponse re)
	{	
		
		ModelAndView mv = new ModelAndView();
		String email_Chk = (String) session.getAttribute("email");
		System.out.println(email_Chk);
		if(email_Chk == null){
			mv.setViewName("redirect:http://localhost:9999/testsol/login");
			return mv;
		}
		
		String account = (String)session.getAttribute("acount");
		
		switch(account){
		case "0": 
			mv.setViewName("redirect:http://localhost:9999/testsol/admin/main");
			return mv;
		case "1": 
			
			
			mv.setViewName("redirect:http://localhost:9999/testsol/client/main");
			return mv;
		case "2": 
			mv.setViewName("redirect:http://localhost:9999/testsol/business/main");
			return mv;
		}
		return null;	
	}
	
	
	
	
	@RequestMapping(value = "/loginChk", method = RequestMethod.POST)
	public ModelAndView login_main(String email, String pass, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		user = login.login(email, pass);
		if (user == null) { // Client �� ���� ���� ���� ���
			bs_client = login.bs_login(email, pass);
			if (bs_client != null) {
				mv.setViewName("business/main");
				model.addAttribute("user", bs_client);
				mv.addObject("user", bs_client);
				session.setAttribute("acount", "2");
				session.setAttribute("bs_no", bs_client.getBs_no());
				session.setAttribute("email", bs_client.getBs_email());
				session.setAttribute("business_name", bs_client.getBusiness_name());
				session.setAttribute("manager_name", bs_client.getManager_name());
				int bs_no = (int) session.getAttribute("bs_no");
				System.out.println(bs_no);
				return mv;
				
				
			} else {
				session.removeAttribute("email");
				mv.setViewName("redirect:http://localhost:9999/testsol/login");
				return mv;
			}
		} // Client �� ���� �ϴ� ���
		session.setAttribute("user", user);
		mv.addObject("user", user);
		if ("admin@gmail.com".equals(user.getEmail())) {
			mv.setViewName("admin/main");
			session.setAttribute("acount", "0");
			session.setAttribute("email",user.getEmail());
			
			return mv; // ������ �������� �̵�
		}
		session.setAttribute("acount", "1");
		session.setAttribute("email",user.getEmail());
		mv.setView(new RedirectView("loginChk"));
	
		return mv; // ����ȸ�� ���� �������� �̵�
	}

	// ����������������������������������������������������������������������������ڿ리��������������������������������������������������������������������������������//
	// ����� - ȸ������ ��ư ������ �ÿ� ������ �̵�
	@RequestMapping(value = "/client/register", method = RequestMethod.GET)
	public String client_regist(Locale locale, Model model) {
		return "client/register";
	}

	// ����� - ȸ������ �Է½� �����ϸ� �������� �̵�
	@RequestMapping(value = "/client_regist", method = RequestMethod.POST)
	public String client_regist_post(Locale locale, Model model, Client client) {
		String ret = login.insert_Client(client);
		return "client/main";
	}

	// �������������������������������������������������������������������������� ü  �리��������������������������������������������������������������������������������//

	// ��ü - �α��ν� ��ü�� ����ȭ�� �̵�
	@RequestMapping(value = "/business/main", method = RequestMethod.GET)
	public ModelAndView bsmain(Locale locale, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		System.out.println("�ڷΰ���");
		if (session.getAttribute("email") == null) {
			mv.setViewName("login");
			return mv;
		} else {
			mv.setViewName("business/main");
			return mv;
		}
	}

	// ��ü - ��ü ȸ�� ���� ������ �ּ� �̵�
	@RequestMapping(value = "/business/register", method = RequestMethod.GET)
	public String bs_regist(Locale locale, Model model) {

		return "business/register";
	}

	// ��ü - ȸ������ ���� �� �������� �̵�
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

	// ��ü ���� ���� �������� ��ȯ
	@RequestMapping(value = "/business/bs_update", method = RequestMethod.POST)
	public ModelAndView bs_update_post(Locale locale, Model model, HttpSession session) {
		String bs_no = String.valueOf((int) session.getAttribute("bs_no"));
		ModelAndView mv = new ModelAndView();
		bs_client = login.bs_Client_Info(bs_no);
		System.out.println(bs_client);
		mv.setViewName("business/updateInfo");
		mv.addObject("user", bs_client);
		return mv;
	}

	@RequestMapping(value = "/business/updateInfo", method = RequestMethod.POST)
	public ModelAndView bs_update_Info(Business_client client, Model model) {
		System.out.println(client);
		ModelAndView mv = new ModelAndView();
		int ret = login.bs_Client_update(client);
		if (ret == 0) {
			System.out.println("��������");
			mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
			return mv;
		}
		System.out.println("��������");
		mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
		return mv;
	}

	// ��ü - ������ �������� ��ȯ
	@RequestMapping(value = "/business/insertShop", method = RequestMethod.POST)
	public ModelAndView insertShop(Locale locale, Model model, Shop shop, String manager_name, String business_name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("business_name", business_name);
		mv.addObject("manager_name", manager_name);
		mv.setViewName("business/insertShop");

		return mv;
	}

	// ��ü - ������ ȭ���̵��� �ҽ�
	@RequestMapping(value = "/insertShopInfo", method = RequestMethod.POST)
	public String insertShopInfo(Locale locale, Model model, Shop shop) {
		System.out.println("������");
		int ret = shopProcess.insert_Shop(shop);
		if (ret == 0) {
			System.out.println("�Է½���");
			return "business/main";
		}
		System.out.println("��ϼ���");
		return "business/main";
	}

	// ��ü - ���� ���� ���� (���� ����Ʈ)
	@RequestMapping(value = "/business/shopUpdate", method = RequestMethod.POST)
	public ModelAndView ShopInfo(Locale locale, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String bs_no = String.valueOf((int) session.getAttribute("bs_no"));
		List<Shop> list = shopProcess.ShopList(bs_no);
		mv.addObject("shop", list);
		//mv.setViewName("business/shopList");
		mv.setViewName("business/shopList");
		return mv;
	}

	// ��ü - ���� ���� ���� / ����
	@RequestMapping(value = "/business/updateShop", method = RequestMethod.POST)
	public ModelAndView updateShop(Locale locale, Model model, Shop shop, String shop_no, String option) {
		ModelAndView mv = new ModelAndView();
		int ret = 0;	
		switch(option){
			case "����" :{
				System.out.println(option);
				System.out.println(shop);
				try{
					ret = shopProcess.update_shop(shop);	
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					if(ret > 0){
						System.out.println("��������");
						mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
						return mv;
					}
				}
				System.out.println("��������");
				mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
				return mv; 
			
			}case "����" :{	
				try{
					shopProcess.delete_shop(shop_no);
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					if(ret > 0){
						System.out.println("��������");
						mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
						return mv;
					}
				}
				mv.setViewName("redirect:http://localhost:9999/testsol/loginChk");
				return mv; 
			}
		}
		return mv;
	}
	
	
	
	
	// �������������������������������������������������������������������������� �� �� �리��������������������������������������������������������������������������������//
	
}
