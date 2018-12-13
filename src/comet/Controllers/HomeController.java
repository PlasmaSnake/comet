package comet.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import comet.beans.User;

@Controller
@RequestMapping("/")
@SessionAttributes("userModel, loggedIn")
public class HomeController {
	
	@RequestMapping("")
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	

	//TODO implement - test database for matching user/pw
	//TODO optional: fix modal and false input upon form submission interaction
	@RequestMapping(value = "/login_process", method=RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("userModel") @Valid User u, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("login_error", "Username or password incorrect. Create an account or retry login!");
			return mav;
		}
		ModelAndView mav = new ModelAndView("loginProcess");
		mav.addObject("user", u);
		return mav;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("signup");
		
		return mav;
	}
	
	@RequestMapping(value = "/signup_process", method=RequestMethod.POST)
	public ModelAndView processSignup(@ModelAttribute("userModel") @Valid User u, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		}
		ModelAndView mav = new ModelAndView("signupProcess");
		mav.addObject("username", u.getUsername());
		mav.addObject("password", u.getPassword());
		mav.addObject("email", u.getEmail());
		mav.addObject("fullName", u.getFullName());
		mav.addObject("country", u.getCountry());
		return mav;
	}
	
	@RequestMapping("/success")
	public ModelAndView successLogin(@ModelAttribute("loggedIn") boolean loggedIn ) {
		
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView backIndex() {
		return new ModelAndView("index");
	}
	
	@ModelAttribute("userModel")
	public User userCreation(String username, String password, String email, String fullName, String country) {
		return new User(username, password, email, fullName, country);
	}	
}