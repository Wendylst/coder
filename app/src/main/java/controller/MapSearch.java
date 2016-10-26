package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapSearch {

	@RequestMapping(value = "/aroundMe", method = RequestMethod.GET)
	public ModelAndView aroundMe(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/mapView");
		return mv;		
	}
	
	@RequestMapping(value = "/searchShop", method = RequestMethod.GET)
	public ModelAndView searchShop(){
		ModelAndView mv = new ModelAndView();
		return mv;		
	}
	
}
