package comet.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@SessionAttributes("userModel")
public class HomeController {
	
	// HOME ROUTES
	@RequestMapping("")
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView backIndex() {
		return new ModelAndView("index");
	}

	// USER LOGIN AND LOGOUT ROUTES
	@RequestMapping(value = "/login_process", method=RequestMethod.POST)
	public ModelAndView processLoginFromModal(@ModelAttribute("userModel") @Valid User u, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("login_error", "Sign up or retry login.");
			return mav;
		}
		ModelAndView mav = new ModelAndView("loginProcess");
		mav.addObject("login_error", "Username or password incorrect.");
		mav.addObject("userLoggedIn", u);
		return mav;
	}
	
	@RequestMapping(value = "/login_page_process", method=RequestMethod.POST)
	public ModelAndView processLoginFromPage(@ModelAttribute("userModel") @Valid User u, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("loginProcess");
			mav.addObject("login_error", "Username or password incorrect.");
			return mav;
		}
		ModelAndView mav = new ModelAndView("loginProcess");
		mav.addObject("login_error", "Username or password incorrect.");
		mav.addObject("userLoggedIn", u);
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
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
	    httpSession.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
	
	// COIN ROUTES
	@RequestMapping(value = "/coin/", method=RequestMethod.GET)
	public ModelAndView getCoinInfo(@ModelAttribute("queriedCoin") String coinName) {
		ModelAndView mav = new ModelAndView("coin-info");
		mav.addObject("queriedCoin", coinName);
		return mav;
	}
	
	
	@ModelAttribute("userModel")
	public User userCreation(String username, String password, String email, String fullName, String country) {
		return new User(username, password, email, fullName, country);
	}	
}