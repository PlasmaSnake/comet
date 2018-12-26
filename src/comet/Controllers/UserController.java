package comet.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import comet.beans.User;
import comet.beans.Password;
import comet.beans.DAO.SQLDataDeletionDAO;
import comet.beans.DAO.SQLDataInsertDAO;

//TODO If session attribute is empty/null redirect to login page.

@Controller
@RequestMapping("/u/")
public class UserController {
	
	// HOME ROUTES
	@RequestMapping(value = "")
	public ModelAndView homepage(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/index-user");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView backIndex() {
		ModelAndView mav = new ModelAndView("redirect:/u/");
		return mav;
	}
	
	@RequestMapping("/mycoins")
	public ModelAndView coinList() {
		return new ModelAndView("/UserViews/my-coins");
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		return new ModelAndView("/UserViews/contact-user");
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("/UserViews/admin-controls");

	}
	
	// COIN INFO ROUTES
	//TODO Figure out get and send data to coin info
	@RequestMapping(value = "/coin/", method=RequestMethod.GET)
	public ModelAndView getCoinInfo(@ModelAttribute("queriedCoin") String coinName, HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/coin-info-user");
		mav.addObject("queriedCoin", coinName);
		return mav;
	}
	
	// USER COIN LIST AND SETTINGS ROUTES/CRUD
	@RequestMapping("/settings")
	public ModelAndView userSettings(HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/settings-user");
		//mav.addObject("loggedInUser", session.getAttribute("loggedInUser"));
		return mav;
	}
	
	//USER CRUD
	@RequestMapping(value="/updatepassword", method=RequestMethod.POST)
	public ModelAndView settingsUpdatePass(@ModelAttribute("passwordval") @Valid Password p,
			BindingResult errors,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/settings-user");
		User currentUserInfo = (User) session.getAttribute("userLoggedIn");
		// If any password has errors 
		if (errors.hasErrors())
		{
			return mav;
		}
		else {
			// validate password and change if correct
			if(p.getPassword().equals(currentUserInfo.getPassword())) {
				mav = new ModelAndView("/UserViews/settingsProcess-success");
				//update db
				SQLDataInsertDAO sqlDataInsert = new SQLDataInsertDAO();
				sqlDataInsert.updateAccountPassword(currentUserInfo.getUsername(), p.getNewPassword());
				
				//update session
				currentUserInfo.setPassword(p.getNewPassword());
				session.setAttribute("userLoggedIn", currentUserInfo);
				mav.addObject("pass_changed", "Password changed!" );
			}
			else { mav.addObject("password_error", "Incorrect password" );}
		}
		return mav;
	}
	

	@RequestMapping(value="/updatename", method=RequestMethod.POST)
	public ModelAndView settingsUpdateName(@ModelAttribute("fullName") String fullName,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/settingsProcess-success");
		User currentUserInfo = (User) session.getAttribute("userLoggedIn");
		if(fullName.equals("")) {
			mav.addObject("setting_changed", "Please enter a name.");
		}
		// If not null, update value in database and set new Session attribute.
		else {
			SQLDataInsertDAO sqlDataInsert = new SQLDataInsertDAO();
			sqlDataInsert.updateAccountFullName(currentUserInfo.getUsername(), fullName);
			currentUserInfo.setFullName(fullName);
			session.setAttribute("userLoggedIn", currentUserInfo);
			mav.addObject("setting_changed", "Name changed!");
		}
		return mav;
	}

	@RequestMapping(value="/updatecountry", method=RequestMethod.POST)
	public ModelAndView settingsUpdateCountry(@ModelAttribute("country") String country, 
			BindingResult errors,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("/UserViews/settingsProcess-success");
		User currentUserInfo = (User) session.getAttribute("userLoggedIn");
		// If null don't change.
		if(country.equals("")) {
			mav.addObject("setting_changed", "Please enter a country.");				
		}
		// If not null, update value in database and set new Session attribute.
		else {
			SQLDataInsertDAO sqlDataInsert = new SQLDataInsertDAO();
			sqlDataInsert.updateAccountCountry(currentUserInfo.getUsername(), country);
			currentUserInfo.setCountry(country);
			session.setAttribute("userLoggedIn", currentUserInfo);
			mav.addObject("setting_changed", "Country changed!");
			}
		return mav;
	}

	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("userToDelete") String username) {
		ModelAndView mav = new ModelAndView("/UserViews/admin-controls");
		SQLDataDeletionDAO sqlDataDeletionDAO = new SQLDataDeletionDAO();
		sqlDataDeletionDAO.deleteAccount(username);
		mav.addObject("deleted", true);
		return mav;
	}
	

	
	@ModelAttribute("modifiedUser")
	public User userCreation(String username, String password, String email, String fullName, String country) {
		return new User(username, password, email, fullName, country);
	}	
	
	@ModelAttribute("passwordval")
	public Password passwordCreation(String password, String newPassword) {
		Password p = new Password();
		p.setPassword(password);
		p.setNewPassword(newPassword);
		return p;
	}
}
