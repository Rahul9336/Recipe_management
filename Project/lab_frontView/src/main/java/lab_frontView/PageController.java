package lab_frontView;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import recipe_lab.dataAccessObject.CuisineDao;
import recipe_lab.dataAccessObject.RecipeDao;
import recipe_lab.dataAccessObject.UserDao;
import recipe_lab.dto.Cuisine;
import recipe_lab.dto.Recipe;
import recipe_lab.dto.User;

@Controller
public class PageController {

	@Autowired
	CuisineDao cuisineDao;
	@Autowired
	RecipeDao recipeDao;
	@Autowired
	UserDao userDao;
	Cuisine cuisine;
	User user;
	Recipe recipe;
	@RequestMapping(value="/")
	public  ModelAndView homepage(Map<String, Object> map,Principal principal) {
		map.put("cuisine", cuisineDao.getCuisine());
		map.put("recipelist", recipeDao.homepageRandomly());
		try {
		if(principal.getName()!=null) 
		{
			user=userDao.getUserByUsername(principal.getName());
			map.put("user", user);
			map.put("username", user);
		}
		}catch(Exception ex){ }
		ModelAndView model=new ModelAndView("Home");
		return model;
	}
	
	@RequestMapping(value="/user/addrecipe")
	public ModelAndView AddRecipePage(Map<String, Object> map,Principal principal) {
		ModelAndView model=new ModelAndView("user/Recipe");
		try {
			if(principal.getName()!=null) {user=userDao.getUserByUsername(principal.getName());}}catch(Exception ex){ }
		
		map.put("cuisine", cuisineDao.getCuisine());
		map.put("user", user);
		return model;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(Map<String, Object> map) {
		ModelAndView model=new ModelAndView("login");
		map.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
	@RequestMapping(value="/signup")
	public ModelAndView SignUP(Map<String, Object> map) {
		ModelAndView model=new ModelAndView("signup");
		map.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
	@RequestMapping(value="/searchbox")
	public ModelAndView SearchBox(Map<String, Object> map,HttpServletRequest request,Principal principal) {
		ModelAndView model=new ModelAndView("Home");
		try {
			if(principal.getName()!=null) 
			{
				user=userDao.getUserByUsername(principal.getName());
				map.put("user", user);
				map.put("username", user);
			}
			}catch(Exception ex){ 
				
			}
		map.put("recipelist", recipeDao.searchRecipe(request.getParameter("search")));
		map.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
	@RequestMapping(value="/recipedetail/{recipe_id}")
	public ModelAndView RecipeDetail(Map<String, Object> map,HttpServletRequest request,@PathVariable(value = "recipe_id") Long id,Principal principal) {
		ModelAndView model=new ModelAndView("user/recipeDetail");
		try {
			if(principal.getName()!=null) 
			{
				user=userDao.getUserByUsername(principal.getName());
				map.put("user", user);
				map.put("username", user);
			}
			}catch(Exception ex){ }
		map.put("recipe", recipeDao.getRecipeById(id));
		map.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
	@RequestMapping(value="/user/edited/{recipe_id}")
	public ModelAndView RecipeEditHistoryDetail(Map<String, Object> map,HttpServletRequest request,@PathVariable(value = "recipe_id") Long id,Principal principal) {
		ModelAndView model=new ModelAndView("user/myRecipeDetail");
		try {
			if(principal.getName()!=null) 
			{
				user=userDao.getUserByUsername(principal.getName());
				map.put("user", user);
				map.put("username", user);
			}
			}catch(Exception ex){ }
		map.put("recipe", recipeDao.recipeChangesYouMake(id));
		map.put("cuisine", cuisineDao.getCuisine());
		return model;
	}
}
