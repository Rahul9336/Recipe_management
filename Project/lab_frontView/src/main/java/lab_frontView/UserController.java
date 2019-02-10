package lab_frontView;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import recipe_lab.dataAccessObject.UserDao;
import recipe_lab.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	@RequestMapping(value = "/signupSuccess", method = RequestMethod.POST)
	public ModelAndView Signupsuccess(@Valid @ModelAttribute("user1") User user, BindingResult result,Map<String,String>map) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("signup");
			return model;
		} else {
			ModelAndView model1 = new ModelAndView("login");
			try {
			userDao.add(user);
			map.put("message", "Sign up Success");
			
			}catch(Exception ex){
				map.put("Exception", "Email Alreday IN Used");
			}
			return model1;
		}
	}
}
