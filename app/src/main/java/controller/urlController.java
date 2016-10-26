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
	

	
	Business_client bs_client= new Business_client(); // ��ü ������������ �ִ� DTO
	Client user = new Client(); // ������ ������ ����� ������ ������ �ִ� DTO

	
	@Autowired
	Login login; // ������ ���� �۾��� �ϱ� ���� DAO
	
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
		if (user == null) { // Client �� ���� ���� ���� ���
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
		} else {	// Client �� ���� �ϴ� ��� 
			
			if(user.getEmail().equals("admin@gmail.com")){	// id�� ������ ���̵��?				
				mv.addObject("user", user);
				mv.setViewName("admin/main");
				model.addAttribute("user", user);
				return mv; // ������ �������� �̵�
			}
			mv.addObject("user", user);
			mv.setViewName("client/main");
			model.addAttribute("user", user);
			return mv; 	// ����ȸ�� ���� �������� �̵�
		}
	}



	
	// �α��������� 
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main(Locale locale, Model model) {
			return "login";

	}
	//����������������������������������������������������������������������������ڿ리��������������������������������������������������������������������������������//
	// ����� - ȸ������ ��ư ������ �ÿ� ������ �̵�
	@RequestMapping(value = "/client/register", method = RequestMethod.GET)
	public String client_regist(Locale locale, Model model) {
		return "client/register";
	}
	
	// ����� - ȸ������ �Է½� �����ϸ� �������� �̵�
	@RequestMapping(value = "/client_regist", method = RequestMethod.POST)
	public String client_regist_post(Locale locale, Model model, Client client) {
		String ret = login.insert_Client(client);
		return "main";
	}
	
	
	//�������������������������������������������������������������������������� ü �리��������������������������������������������������������������������������������//

	// ��ü - �α��ν�  ��ü�� ����ȭ�� �̵�
	@RequestMapping(value = "business/main", method = RequestMethod.POST)
	public String bsmain(Locale locale, Model model) {
			return "business/main";

	}
	// ��ü - ��ü ȸ�� ���� ������ �ּ� �̵� 
	@RequestMapping(value = "/business/register", method = RequestMethod.GET)
	public String bs_regist(Locale locale, Model model) {
		return "business/register";
	}
	
	//��ü - ȸ������ ���� �� �������� �̵� 
	@RequestMapping(value = "/bs_regist", method = RequestMethod.POST)
	public String bs_regist_post(Locale locale, Model model, Business_client client) {
		String ret = login.insert_bs_Client(client);
		System.out.println(ret);

		return "main";
	}
	
	
	// ��ü ���� ����
	@RequestMapping(value = "/bs_update", method = RequestMethod.POST)
	public String bs_update_post(Locale locale, Model model, Business_client client) {
		
		
		return "updateInfo";
	}
	
	// ��ü - ������
	@RequestMapping(value = "/insertShop", method = RequestMethod.POST)
	public ModelAndView insertShop(Locale locale, Model model, Shop shop, String manager_name, String business_name){
		
		System.out.println("������");
		System.out.println(model);
		System.out.println(manager_name);
		System.out.println(business_name);
		ModelAndView mv = new ModelAndView();
		mv.addObject("business_name",business_name);
		mv.addObject("manager_name",manager_name);
		mv.setViewName("business/insertShop");
	
		return mv;
	}
	
	// ��ü - ������ ȭ���̵��� �ҽ�
	@RequestMapping(value = "/insertShopInfo", method = RequestMethod.POST)
	public String insertShopInfo(Locale locale, Model model, Shop shop){
		
		return "";
	}
	
	//�������������������������������������������������������������������������� ü �리��������������������������������������������������������������������������������//
	
}
