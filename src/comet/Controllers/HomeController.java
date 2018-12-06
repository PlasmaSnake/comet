package comet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	//TODO implement - create User test object for login
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/success")
	public ModelAndView successLogin() {
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	
	@RequestMapping("/index")
	public ModelAndView backIndex() {
		return new ModelAndView("index");
	}
}
