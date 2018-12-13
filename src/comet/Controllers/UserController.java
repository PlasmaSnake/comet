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
@RequestMapping("/u/")
@SessionAttributes("userLoggedIn, queriedCoin")
public class UserController {
	
	// HOME ROUTES
	@RequestMapping(value = "")
	public ModelAndView homepage(@ModelAttribute("userLoggedIn") User u) {
		ModelAndView mav = new ModelAndView("/UserViews/index-user");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView backIndex() {
		return new ModelAndView("/UserViews/index-user");
	}
	
	// COIN LIST ROUTES
	//TODO Figure out get and send data to coin info
	@RequestMapping(value = "/coin/", method=RequestMethod.GET)
	public ModelAndView getCoinInfo(@ModelAttribute("queriedCoin") String coinName) {
		ModelAndView mav = new ModelAndView("/UserViews/coin-info-user");
		mav.addObject("queriedCoin", coinName);
		return mav;
	}
	
	// USER COIN LIST AND SETTINGS ROUTES/CRUD
	@RequestMapping("/settings")
	public ModelAndView userSettings() {
		return new ModelAndView("/UserViews/settings-user");
	}
	
	@RequestMapping("/settingsupdate")
	public ModelAndView settingsUpdate(@ModelAttribute("loggedInUser") @Valid User u, 
			@ModelAttribute("password") String password, 
			@ModelAttribute("fullName") String name,
			@ModelAttribute("country") String country,
			BindingResult errors) {
		
		if (errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("/UserViews/settings");
			if (!password.equals(u.getPassword())) mav.addObject("input_error", "Username or password incorrect.");
			
			return mav;
		}
		//TODO See if email exists in database. If Emails valid
		
		ModelAndView mav = new ModelAndView("/UserViews/settings");
		if (!password.equals(u.getPassword())) mav.addObject("input_error", "Old password did not match current password.");
		if (password.equals(u.getPassword())) mav.addObject("pass_changed", "Password changed!");
		return new ModelAndView("/UserViews/settings-user");
	}
	
	@RequestMapping("/mycoins")
	public ModelAndView coinList() {
		return new ModelAndView("/UserViews/my-coins");
	}
	
	@ModelAttribute("userLoggedIn")
	public User userCreation(String username, String password, String email, String fullName, String country) {
		return new User(username, password, email, fullName, country);
	}	
}
