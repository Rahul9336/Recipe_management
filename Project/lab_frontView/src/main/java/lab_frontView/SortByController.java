package lab_frontView;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import recipe_lab.dataAccessObject.CuisineDao;
import recipe_lab.dataAccessObject.RecipeDao;
import recipe_lab.dataAccessObject.UserDao;
import recipe_lab.dto.Recipe;
import recipe_lab.dto.User;

@Controller
public class SortByController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	RecipeDao recipeDao;
	@Autowired
	CuisineDao cuisineDao;
	@Autowired
	UserDao userDao;
	User user;
	Recipe recipe;
	
	@RequestMapping(value="/user/sortByname")
	public ModelAndView RecipeSortByName(Map<String,Object>list,Principal principal) {
		ModelAndView model=new ModelAndView("user/myRecipe");
		user=userDao.getUserByUsername(principal.getName());
		list.put("myRecipe", recipeDao.ForUserSortByName(user.getUser_id()));
		list.put("cuisine", cuisineDao.getCuisine());
		list.put("user", user);
		return model;
	}
	
	@RequestMapping(value="/user/sortByIngredients")
	public ModelAndView RecipeSortByIngredients(Map<String,Object>list,Principal principal) {
		ModelAndView model=new ModelAndView("user/myRecipe");
		user=userDao.getUserByUsername(principal.getName());
		list.put("myRecipe", recipeDao.ForUserSortByIngredients(user.getUser_id()));
		list.put("cuisine", cuisineDao.getCuisine());
		list.put("user", user);
		return model;
	}
	
	@RequestMapping(value="/user/sortBydate")
	public ModelAndView RecipeSortBydate(Map<String,Object>list,Principal principal) {
		ModelAndView model=new ModelAndView("user/myRecipe");
		user=userDao.getUserByUsername(principal.getName());
		list.put("myRecipe", recipeDao.ForSortByDate(user.getUser_id()));
		list.put("cuisine", cuisineDao.getCuisine());
		list.put("user", user);
		return model;
	}
	
}
