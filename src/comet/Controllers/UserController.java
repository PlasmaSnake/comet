package comet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import comet.beans.User;

@Controller
@RequestMapping("/u/")
@SessionAttributes("userLoggedIn")
public class UserController {
	
	@RequestMapping(value = "")
	public ModelAndView homepage(@ModelAttribute("userLoggedIn") User u) {
		ModelAndView mav = new ModelAndView("/UserViews/index-user");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView backIndex() {
		return new ModelAndView("/UserViews/index-user");
	}
	
	@ModelAttribute("userLoggedIn")
	public User userCreation(String username, String password, String email, String fullName, String country) {
		return new User(username, password, email, fullName, country);
	}	
}
